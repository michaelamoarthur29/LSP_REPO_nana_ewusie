package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    // 1. Test average()
    @Test
    void testAverage() {
        GradeCalculator gc = new GradeCalculator();
        double result = gc.average(90, 80, 70);
        assertEquals(80.0, result);
    }

    // 2. Test letterGrade()
    @Test
    void testLetterGrade() {
        GradeCalculator gc = new GradeCalculator();
        assertEquals("A", gc.letterGrade(95));
    }

    // 3. Test isPassing()
    @Test
    void testIsPassing() {
        GradeCalculator gc = new GradeCalculator();
        assertTrue(gc.isPassing(65));
    }

    // 4. Boundary test (edge of A)
    @Test
    void testBoundaryA() {
        GradeCalculator gc = new GradeCalculator();
        assertEquals("A", gc.letterGrade(90));
    }

    // 5. Boundary test (edge of passing)
    @Test
    void testBoundaryPassing() {
        GradeCalculator gc = new GradeCalculator();
        assertTrue(gc.isPassing(60));
    }

    // 6. Exception test (below range)
    @Test
    void testInvalidScoreLow() {
        GradeCalculator gc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            gc.average(-1, 50, 60);
        });
    }

    // 7. Exception test (above range)
    @Test
    void testInvalidScoreHigh() {
        GradeCalculator gc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            gc.average(101, 90, 80);
        });
    }
}
