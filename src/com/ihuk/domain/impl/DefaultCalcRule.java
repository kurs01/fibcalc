package com.ihuk.domain.impl;

import com.ihuk.domain.CalcRule;

/**
 * <p>
 *     Default calculation rule.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 *
 */
public class DefaultCalcRule implements CalcRule {

    @Override
    public long calculate(int number) {
        return Math.round(Math.pow((1+Math.sqrt(5))/2, number) / Math.sqrt(5));
    }

    @Override
    public boolean isMatch(int number) {
        return number <= NUMBER_70;
    }
}
