/*
Задача 4:
        Проверить что все String константы имеют значение = их имени
public static final String MONDAY = "MONDAY";

 */

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Task4 {
    public static void main(String[] args) {

        Field[] declaredMethodsFields = TestClass.class.getDeclaredFields();
        for (Field field : declaredMethodsFields) {

            if (field.getType()==String.class && Modifier.isFinal(field.getModifiers())  && Modifier.isStatic(field.getModifiers()) ){
                try {
                    String val = field.get(null).toString();
                    System.out.println("String " + field.getName() + " = " + val);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                };


            }

        }
    }
}
