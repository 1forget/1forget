package com.lyx.arithmetic.service;

import org.junit.Test;

/**
 * Description:
 *
 * @author lyx
 * Date:2023/9/27 22:42
 */
public class FractionTest {
    @Test
    public void test(){

            Fraction fraction1 = new Fraction(5, 4);
            Fraction fraction2 = new Fraction(1, 2);

            System.out.println("Sum: " + fraction1.add(fraction2));

            System.out.println("Subtract: " + fraction1.subtract(fraction2));

            System.out.println("Multi: " + fraction1.multiply(fraction2));

            System.out.println("Divide: " + fraction1.divide(fraction2));
    }
}
