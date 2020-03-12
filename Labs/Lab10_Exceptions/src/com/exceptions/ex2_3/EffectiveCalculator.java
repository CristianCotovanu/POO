package com.exceptions.ex2_3;

import java.util.Collection;

public class EffectiveCalculator implements Calculator {
    @Override
    public Double add(Double nr1, Double nr2) {
        checkNullParameter(nr1);
        checkNullParameter(nr2);

        Double sum = nr1 + nr2;
        checkInfinity(sum);

        return sum;
    }

    @Override
    public Double divide(Double nr1, Double nr2) {
        checkNullParameter(nr1);
        checkNullParameter(nr2);

        Double div = nr1 / nr2;
        checkInfinity(div);

        return div;
    }

    @Override
    public Double average(Collection<Double> numbers) {
        checkNullParameter(numbers);
        Double numbersSum = 0d;

        for (Double num : numbers) {
            numbersSum += num;
        }

        double numbersAverage = numbersSum / (double) numbers.size();
        checkInfinity(numbersAverage);
        return numbersAverage;
    }

    private void checkNullParameter(Double element) {
        if (element == null) {
            throw new NullParameterException();
        }
    }

    private void checkNullParameter(Collection<Double> elements) {
        if (elements == null) {
            throw new NullParameterException();
        }
    }


    private void checkInfinity(Double element) {
        if (element == Double.POSITIVE_INFINITY) {
            throw new OverflowException();
        }
        if (element == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException();
        }
    }
}
