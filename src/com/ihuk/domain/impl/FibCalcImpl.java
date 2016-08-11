package com.ihuk.domain.impl;

import com.ihuk.domain.CalcRule;
import com.ihuk.domain.FibCalc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>
 *     Implementation of fibonacci calculator as Runnable task.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 *
 */
public class FibCalcImpl implements FibCalc, Runnable, Callable<Long> {

    /**
     * Default calculation rule.
     */
    CalcRule defaultCaclRule = new DefaultCalcRule();

    /**
     * Array calculation rule.
     */
    CalcRule arrayCaclRule = new ArrayCalcRule();

    /**
     * Calculation Rule list.
     */
    List<CalcRule> calcRuleList = new ArrayList<CalcRule>(){{
        add(defaultCaclRule);
        add(arrayCaclRule);
    }};

    /**
     * Number to calculate fibonacci.
     */
    private final int number;

    public FibCalcImpl(int number) {
        this.number = number;
    }

    @Override
    public long fib(int num) {
        CalcRule calculationRule = selectRule(num);
        return calculationRule.calculate(num);
    }

    private CalcRule selectRule(int number) {
        for (CalcRule rule : calcRuleList) {
            if(rule.isMatch(number)) {
                return rule;
            }
        }
        return defaultCaclRule;
    }

    /**
     * Calculate fibonacci number for number value.
     */
    @Override
    public void run() {
        fib(number);
    }

    /**
     * Calculate fibonacci number for number value. And calculate execution time to statistics.
     * @return - execution time
     * @throws Exception
     */
    @Override
    public Long call() throws Exception {
        long start = System.currentTimeMillis();
        fib(number);
        return System.currentTimeMillis() - start;
    }
}
