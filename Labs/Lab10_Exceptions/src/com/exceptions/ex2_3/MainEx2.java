package com.exceptions.ex2_3;

import java.util.List;

public class MainEx2 {
    public static void main(String[] args) {
        Calculator calculator = new EffectiveCalculator();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(List.of(1d, 2d, 3d, 4d)));

//      System.out.println(calculator.add(null, Double.MAX_VALUE));
//      System.out.println(calculator.add(Double.MAX_VALUE, null));
//      System.out.println(calculator.add(null, null));
//      System.out.println(calculator.add(Double.MAX_VALUE, Double.MAX_VALUE));
//      System.out.println(calculator.add(-Double.MAX_VALUE, -Double.MAX_VALUE));
//
//      System.out.println(calculator.divide(null, Double.MAX_VALUE));
//      System.out.println(calculator.divide(Double.MAX_VALUE, null));
//      System.out.println(calculator.divide(null, null));
//      System.out.println(calculator.divide(1d, 0d));
//      System.out.println(calculator.divide(-1d, 0d));
//
//      System.out.println(calculator.average(List.of(1d, 7d, Double.MAX_VALUE, Double.MAX_VALUE)));
//      System.out.println(calculator.average(List.of(8d, -300d, -Double.MAX_VALUE, -Double.MAX_VALUE)));
      System.out.println(calculator.average(null));
    }
}
