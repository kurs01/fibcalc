package com.ihuk;

import com.ihuk.domain.PerformanceTester;
import com.ihuk.domain.impl.FibCalcImpl;
import com.ihuk.domain.impl.PerformanceTestResult;
import com.ihuk.domain.impl.PerformanceTesterImpl;

import java.lang.invoke.WrongMethodTypeException;

class Main {

    public static void main(String[] args) {

        int number = obtainIntValue(args[0]);
        int executionCount = obtainIntValue(args[1]);
        int threadPoolSize = obtainIntValue(args[2]);
        PerformanceTester tester = new PerformanceTesterImpl();
        try {
            PerformanceTestResult result = tester.runPerformanceTest(new FibCalcImpl(number), executionCount, threadPoolSize);
            System.out.println(String.format("calculate fib(%s) %s times using %s thread(s) by %s ms",
                    number, executionCount, threadPoolSize, result.getTotalTime()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static private int obtainIntValue(String val) {
        if (val == null) {
            return 0;
        }
        try{
            return Integer.valueOf(val);
        } catch (Exception e) {
            System.out.println("The application should take the following arguments: <n> <calculationCount> <threadPoolSize>");
            System.out.println("n = which fibonacci number to calculate");
            System.out.println("calculationCount = how many fibonacci calculations to run in total during the test");
            System.out.println("threadPoolSize = how many threads should be used to run the calculations");
            throw new WrongMethodTypeException(e.getMessage());
        }
    }
}
