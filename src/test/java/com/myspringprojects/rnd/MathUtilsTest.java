package com.myspringprojects.rnd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testAdd() {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The add method should add 2 numbers");

    }


    @Test
    void testComputeCircleArea() {

        MathUtils mathUtils = new MathUtils();
        double radius = 10.0;
        double expected = Math.PI * radius * radius;
        double actual = mathUtils.computeCircleArea(radius);
        assertEquals(expected, actual, "Area of the circle should be pi * radius * radius");
    }
}