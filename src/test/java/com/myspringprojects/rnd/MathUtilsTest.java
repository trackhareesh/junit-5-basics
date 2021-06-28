package com.myspringprojects.rnd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
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
    @DisplayName("Add two positive numbers")
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
    @DisplayName("Exception when dividing with zero")
    void testDivideWithZero() {
        assertThrows(
                ArithmeticException.class,
                () -> mathUtils.divide(1, 0), "" +
                        "Division by zero should throw ArithmeticException"
        );
    }

    @Test
    @DisplayName("Disabled method should not run")
    @Disabled
    void testDisbledAnnotation() {
        fail("Disabled method should not run!!!");
    }
}