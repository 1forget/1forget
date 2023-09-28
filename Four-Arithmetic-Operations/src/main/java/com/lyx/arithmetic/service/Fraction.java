package com.lyx.arithmetic.service;

/**
 * Description: 分数类
 *
 * @author lyx
 * Date:2023/9/27 21:20
 */
public class Fraction {
    private int numerator;   // 分子
    private int denominator; // 分母

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        int gcd = gcd(numerator, denominator); // 计算最大公约数
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    // 加法
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // 减法
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction(int numerator) {
        this.denominator = 1;
        this.numerator = numerator;
    }

    // 乘法
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // 除法
    public Fraction divide(Fraction other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
    // 对分数进行约分
    public void Appointment() {
        if (numerator == 0 || denominator == 1) {
            return;
        }
        // 如果分子是0或分母是1就不用约分了
        long gcd = gcd(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    public boolean isZero() {
        return numerator == 0;
    }

    // 计算最大公约数
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    public  String transferFraction(Fraction fraction){//对分数进行约分化简
        int a = fraction.numerator;
        int b = fraction.denominator;
        int c = a/gcd(a,b);
        int d = b/gcd(a,b);
        int e = c/d;
        int f = c%d;
        String str = "";
        if(f==0){
            str += e;
        }else if(e!=0){
            str = e+"'"+f+"/"+d;
        }else{
            str +=f+"/"+d ;
        }
        return str;
    }
    public int getNumerator() {//获取分子
        return numerator;
    }

    public int getDenominator() {//获取分母
        return denominator;
    }

}
