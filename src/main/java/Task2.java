
/*Задача 2:
        Вывести на консоль все методы класса, включая все родительские методы
        (включая приватные)

 */

import java.lang.reflect.Method;

public class Task2 {


    public static void main(String[] args) {

        Method[] declaredMethods = TestClass.class.getDeclaredMethods();
        for (Method method: declaredMethods){
            System.out.println(method.toString());
        }
    }
}
