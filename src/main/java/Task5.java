/*
Задача 5:
        Реализовать кэширующий прокси
 */

import task5ProxyCache.CachedInvocationHandler;

import java.lang.reflect.Proxy;

public class Task5 {
    public static void main(String[] args) {

        Calculator delegate=new CalculatorImpl();
        Calculator calculator=(Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), delegate.getClass().getInterfaces(), new CachedInvocationHandler(delegate));

        System.out.println(calculator.calcForCash(1));
        System.out.println(calculator.calcForCash(5));
        System.out.println(calculator.calcForCash(6));
        System.out.println(calculator.calcForCash(1));
        System.out.println(calculator.calcForCash(1));
        System.out.println(calculator.calcForCash(1));
        System.out.println(calculator.calcForCash(1));
        System.out.println(calculator.calcForCash(1));
        System.out.println(calculator.calcForCash(1));
    }

}
