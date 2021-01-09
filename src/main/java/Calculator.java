import Task6Metric.Metric;
import task5ProxyCache.Cache;

public interface Calculator {

    /**
     * Расчет факториала числа.
     * @param number
     */
    @Metric
    int calc (int number);

    @Cache
    @Metric
    int calcForCash (int number);

}
