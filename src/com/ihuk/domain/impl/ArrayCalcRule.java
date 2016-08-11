package com.ihuk.domain.impl;

import com.ihuk.domain.CalcRule;

/**
 * <p>
 *     Calculation rule.
 *     Use array to obtain Fibonacci number.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 *
 */
public class ArrayCalcRule implements CalcRule {

    @Override
    public long calculate(int number) {
        long[] feb = new long[number];
        feb[0] = 0;
        feb[1] = 1;
        for(int i=2; i < number; i++){
            feb[i] = feb[i-1] + feb[i-2];
        }
        return feb[number - 1];
    }

    @Override
    public boolean isMatch(int number) {
        return number > NUMBER_70;
    }
}
