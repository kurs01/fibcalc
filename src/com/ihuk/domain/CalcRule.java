package com.ihuk.domain;

/**
 * <p>
 *     Calculation rule interface.
 * </p>
 *
 * @author Ihor Huk <iguk01@gmail.com>
 *
 */
public interface CalcRule {

    int NUMBER_70 = 70;

    /**
     * Do calculation.
     *
     * @param number - number of Fibonacci numbers.
     * @return - Fibonacci number
     */
    long calculate(int number);

    /**
     * Rules applicable verification.
     *
     * @param number - number of Fibonacci numbers.
     * @return - result of verification.
     */
    boolean isMatch(int number);
}
