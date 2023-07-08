package com.sda.java.advance.newFeatures.functionalInterface;

public class FunctionalExample {

    private static <T extends Number> T calculateSum(T a, T b){

        Calculator<T> calculator = new Calculator<T>() {
            @Override
            public T calculate(T a, T b) {
                Number result = 0;
                if (a instanceof Integer)
                    result = ((Number) a).intValue() + ((Number) b).intValue();
                if (a instanceof Float)
                    result = ((Number) a).floatValue() + ((Number) b).floatValue();
                if (a instanceof Double)
                    result = ((Number) a).doubleValue() + ((Number) b).doubleValue();
                return (T) (result);
            }
        };

        return calculator.calculate(a, b);

//        return  new Calculator<T>() {
//            @Override
//            public T calculate(T a, T b) {
//                Number result =  0;
//                if( a instanceof Integer)
//                    result = ((Number) a).intValue()+ ((Number) b).intValue();
//                if( a instanceof Float)
//                    result = ((Number) a).floatValue()+ ((Number) b).floatValue();
//                if( a instanceof Double)
//                    result = ((Number) a).doubleValue()+ ((Number) b).doubleValue();
//                return  (T)(result);
//            }
//        }.calculate(a, b) ;
    }

    private  static Calculator<Integer> universalCal(Action action){
        switch (action){
            case ADD:
                return new Calculator<Integer>() {
                    @Override
                    public Integer calculate(Integer a, Integer b) {
                        return a+b;
                    }
                };
            case SUBTRACTS:
                return new Calculator<Integer>() {
                    @Override
                    public Integer calculate(Integer a, Integer b) {
                        return a-b;
                    }
                };
            case MULTIPLY:
                return new Calculator<Integer>() {
                    @Override
                    public Integer calculate(Integer a, Integer b) {
                        return a*b;
                    }
                };
            case DIVISION:
                return new Calculator<Integer>() {
                    @Override
                    public Integer calculate(Integer a, Integer b) {
                        return a/b;
                    }
                };
            case REMAINDER:
                return new Calculator<Integer>() {
                    @Override
                    public Integer calculate(Integer a, Integer b) {
                        return a%b;
                    }
                };
            default:
                return new Calculator<Integer>() {
                    @Override
                    public Integer calculate(Integer a, Integer b) {
                        return null;
                    }
                };
        }
    }

    public static void main(String[] args) {
        Integer sum = calculateSum(20, 30);
        Double sum1 = calculateSum(20.5, 30.5);

        System.out.println("Sum: " + sum);
        System.out.println("Sum 1: " + sum1);

        Calculator<Integer> adding = universalCal(Action.ADD);
        Calculator<Integer> division = universalCal(Action.DIVISION);
        Calculator<Integer> subtracts = universalCal(Action.SUBTRACTS);
        Calculator<Integer> remainder = universalCal(Action.REMAINDER);
//
        System.out.println("Addition: " + adding.calculate(20, 30));
        System.out.println("Division: " + division.calculate(20, 30));

        System.out.println("subtracts: " + subtracts.calculate(20, 30));
        System.out.println("remainder: " + remainder.calculate(20, 30));
    }
}
