import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Задача 7:
        Реализовать следующий класс по документации
public class BeanUtils{

 Scans object "from" for all getters. If object "to"
 contains correspondent setter, it will invoke it
 to set property value for "to" which equals to the property
 of "from".
  <p/>
 The type in setter should be compatible to the value returned
 by getter (if not, no invocation performed).
 Compatible means that parameter type in setter should
 be the same or be superclass of the return type of the getter.
  <p/>
 The method takes care only about public methods.

 @param to  Object which properties will be set.
 @param from Object which properties will be used to get values.

         public static void assign(Object to, Object from) {... }
        }
        */
public class Task7 {

    public static void main(String[] args) {
        Test1 test1 = new Test1("test1", 1, 5L);
        Test2 test2 = new Test2();

        BeanUtils.assign(test2, test1);
        System.out.println(test2);
    }

    public static class BeanUtils{
        public static void assign(Object to, Object from) {

            List<Method> listOfGet = findMethods("get", from.getClass());
            List<Method> listOfSet = findMethods("set", to.getClass());

            for (Method methodGet: listOfGet){

                String nameGetter = methodGet.getName();
                String fieldGetter = nameGetter.substring(3,nameGetter.length());

                for (Method methodSet: listOfSet){
                    String nameSetter = methodSet.getName();

                    if (nameSetter.equals("set" + fieldGetter)){

                        if ( (Arrays.stream(methodSet.getParameterTypes()).count()==1) && methodSet.getParameterTypes()[0]==methodGet.getReturnType()){
                            try {
                                methodSet.invoke(to, methodGet.invoke(from));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

        }

       private static List<Method> findMethods(String typeMethod, Class clazz) {

            List<Method> listOfMethods = new ArrayList<>();

            Field[] declaredFields = clazz.getDeclaredFields();
            Method[] methods = clazz.getMethods();

            for (Field field : declaredFields) {
                for (Method method : methods) {

                    if (!method.getName().startsWith(typeMethod)){
                        continue;
                    }

                    if (method.getName().toLowerCase().equals(typeMethod + field.getName().toLowerCase())) {
                        listOfMethods.add(method);
                        //System.out.println(method.getName());
                        break;
                    }
                }
            }
            return listOfMethods;
        }

    }

    public static class Test1{

        private String string1;
        private Integer integer1;
        private Long long1;

        public String getString1() {
            return string1;
        }

        public Integer getInteger1() {
            return integer1;
        }

        public Long getLong1() {
            return long1;
        }

        public Test1(String string1, Integer integer1, Long long1) {
            this.string1=string1;
            this.integer1=integer1;
            this.long1=long1;
        }
    }


    public static class Test2{

        private String string1;
        private Integer integer1;
        private Long long1;

        public void setString1(String string1) {
            this.string1=string1;
        }

        public void setInteger1(Integer integer1) {
            this.integer1=integer1;
        }

        public void setLong1(Long long1) {
            this.long1=long1;
        }

        @Override
        public String toString() {
            return "Test2{" +
                    "string1='" + string1 + '\'' +
                    ", integer1=" + integer1 +
                    ", long1=" + long1 +
                    '}';
        }
    }



}
