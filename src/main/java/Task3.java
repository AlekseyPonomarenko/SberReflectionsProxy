import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*Задача 3:
        Вывести все геттеры класса
*/
public class Task3 {

    public static void main(String[] args) {

        Field[] declaredMethodsFields = TestClass.class.getDeclaredFields();
        Method[] declaredMethods = TestClass.class.getDeclaredMethods();

        for (Field field : declaredMethodsFields) {
            for (Method method : declaredMethods) {
                if (method.getName().toLowerCase().equals("get" + field.getName().toLowerCase())){
                    System.out.println(method.getName());
                    break;
                }
            }
        }


    }
}
