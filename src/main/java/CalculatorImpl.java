public class CalculatorImpl implements Calculator {

    @Override
    public int calc(int number) {

        if (number < 1 ){
            throw new IllegalArgumentException(" < 1");
        }

        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }

    @Override
    public int calcForCash(int number) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return number;
    }


}
