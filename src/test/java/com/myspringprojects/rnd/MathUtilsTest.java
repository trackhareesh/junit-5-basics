package com.myspringprojects.rnd;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    void setup() {
        mathUtils = new MathUtils();
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Cleaning Up");
    }

    @Test
    void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The add method should add 2 numbers");

    }


    @Test
    void testComputeCircleArea() {
        double radius = 10.0;
        double expected = Math.PI * radius * radius;
        double actual = mathUtils.computeCircleArea(radius);
        assertEquals(expected, actual, "Area of the circle should be pi * radius * radius");
    }

    @Test
    void testDivideWithZero() {
        assertThrows(
                ArithmeticException.class,
                () -> mathUtils.divide(1, 0), "" +
                        "Division by zero should throw ArithmeticException"
        );
    }
}