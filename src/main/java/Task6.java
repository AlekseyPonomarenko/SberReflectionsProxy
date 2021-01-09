import task5ProxyCache.CachedInvocationHandler;

import java.lang.reflect.Proxy;

/*
Создать свой аннотацию Metric. Реализовать proxy класс PerformanceProxy, который в случае если метод аннотирован Metric будет выводить на консоль время выполнения метода.
        Т.е написав
public interface Calculator{

     Расчет факториала числа.
     @param number

    @Metric
    int calc (int number);
}
    И использовав его
        Calculator  calculator=new PerformanceProxy(new Calculator()));
        System.out.println(calculator.calc(3));

        Должны увидеть:

        Время работы метода: ххххх (в наносек)
        6
*/
public class Task6 {
    public static void main(String[] args) {

        Calculator delegate=new CalculatorImpl();
        Calculator calculator=(Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), delegate.getClass().getInterfaces(), new CachedInvocationHandler(delegate));

        System.out.println(calculator.calc(5));
        System.out.println(calculator.calc(5));
        System.out.println(calculator.calc(6));
        System.out.println(calculator.calc(7));

    }


}
