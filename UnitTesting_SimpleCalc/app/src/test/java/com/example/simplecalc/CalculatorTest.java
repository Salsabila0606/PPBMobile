/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.simplecalc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class) //used to run the tests in this class
@SmallTest //all the tests in this class are unit tests that have no dependencies, and run in milliseconds
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     * Actual Test
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        //assertThat(resultAdd, is(equalTo(2d)));
        //assertThat(resultAdd, is(equalTo(3d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }

    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(1d, 1d);
        assertThat(resultSub, is(equalTo(0d)));
    }

    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(1d, 17d);
        assertThat(resultSub, is(equalTo(-16d)));
    }

    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(32d, 2d);
        assertThat(resultMul, is(equalTo(64d)));
    }

    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(32d,2d);
        assertThat(resultDiv, is(equalTo(16d)));
    }

//    @Test
//    public void divTwoNumbersZero() {
//        double resultDiv = mCalculator.div(32d,0);
//        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
//    }

    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows() {
        mCalculator.div(32d,0);
    }

    @Test
    public void powTwoNumbers() {
        double resultPow = mCalculator.pow(2d,2d);
        assertThat(resultPow, is(equalTo(4d)));
    }

    @Test
    public void powTwoNumbersFstNeg() {
        double resultPow = mCalculator.pow(-1d,2d);
        assertThat(resultPow, is(equalTo(1d)));
    }

    @Test
    public void powTwoNumbersSecNeg() {
        double resultPow = mCalculator.pow(2d,-1d);
        assertThat(resultPow, is(equalTo(0.5d)));
    }

    @Test
    public void powTwoNumbersFstZero() {
        double resultPow = mCalculator.pow(0,5d);
        assertThat(resultPow, is(equalTo(0.0d)));
    }

    @Test
    public void powTwoNumbersSecZero() {
        double resultPow = mCalculator.pow(10d,0);
        assertThat(resultPow, is(equalTo(1.0d)));
    }

    @Test
    public void powTwoNumbersZero() {
        double resultPow = mCalculator.pow(0,-1d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powZeroNeg() {
        double resultPow = mCalculator.pow(-0,-1d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}