package com.ihuk.domain.impl;

import com.ihuk.domain.PerformanceTester;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * <p>
 *     Implementation of PerformanceTester.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 */
public class PerformanceTesterImpl implements PerformanceTester {

    @Override
    public PerformanceTestResult runPerformanceTest(Runnable task, int executionCount, int threadPoolSize) throws InterruptedException {
        if(!(task instanceof Callable)) {
            return new PerformanceTestResult(0, 0, 0);
        }
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        Set<Future<Long>> set = new HashSet<>();

        for (int i = 0; i< executionCount; i++){
            Future<Long> future = executor.submit((Callable<Long>) task);
            set.add(future);
        }
        PerformanceTestResult result = null;
        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        try {
            for (Future<Long> future : set) {
                long currentValue = future.get();
                if(currentValue < min) {
                    min = currentValue;
                }
                if(currentValue > max) {
                    max = currentValue;
                }
                sum += currentValue;
            }
            result = new PerformanceTestResult(sum, min, max);

        } catch (ExecutionException ee) {
            System.out.println(String.valueOf(ee.getMessage()));
        }
        executor.shutdown();

        return result;
    }

}
