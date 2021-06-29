package com.myspringprojects.rnd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When running MathUtils")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {

    private MathUtils mathUtils;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
    void setup(TestInfo testInfo, TestReporter testReporter) {
        mathUtils = new MathUtils();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Cleaning Up");
    }

    @Nested
    @DisplayName("add method")
    @Tag("Math")
    class AddTest {

        @Test
        @DisplayName("when adding two positive numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "should add 2 numbers");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testAddNegative() {
            assertEquals(1, mathUtils.add(2, -1), "should add 2 numbers");
        }

    }

    @RepeatedTest(3)
    @Tag("Circle")
    void testComputeCircleArea(RepetitionInfo repetitionInfo) {
        double radius = 10.0;
        double expected = Math.PI * radius * radius;
        double actual = mathUtils.computeCircleArea(radius);
        assertEquals(expected, actual, "Area of the circle should be pi * radius * radius");
    }

    @Test
    @Tag("Math")
    @DisplayName("Exception when dividing with zero")
    void testDivideWithZero() {
        assertThrows(
                ArithmeticException.class,
                () -> mathUtils.divide(1, 0), "" +
                        "Division by zero should throw ArithmeticException"
        );
    }

    @Test
    @Tag("Math")
    @DisplayName("Multiply Method Tests")
    void testMultiply() {
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        // assertEquals(4, mathUtils.multiply(2, 2), "Should return the right product");
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1)),
                () -> assertEquals(2, mathUtils.multiply(2, 1))
        );
    }

    @Test
    @DisplayName("Disabled method should not run")
    @Disabled
    void testDisbledAnnotation() {
        fail("Disabled method should not run!!!");
    }
}