package lab10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class NumberFinderTest {

    @Test
    @DisplayName("Zero iteration path: key not in empty array")
    void testEmptyArray() {
        assertEquals(-1, NumberFinder.locate(new int[]{}, 10));
    }

    @Test
    @DisplayName("Single element hit (start==end path)")
    void testSingleHit() {
        assertEquals(0, NumberFinder.locate(new int[]{5}, 5));
    }

    @Test
    @DisplayName("Interpolation jump forward and backward, not found")
    void testBounceNotFound() {
        int[] arr = {3, 8, 12, 19, 27, 34, 50};
        assertEquals(-1, NumberFinder.locate(arr, 25));
    }

    @Test
    @DisplayName("Late hit after several jumps")
    void testLateFound() {
        int[] arr = {2, 5, 7, 10, 14, 18, 21, 29, 33};
        assertEquals(8, NumberFinder.locate(arr, 33));
    }

    @Test
    @DisplayName("Data-flow fault reveal: division by zero scenario safety")
    void testEqualEdgeValuesCrash() {
        int[] edge = {7,7,7,7};
        assertThrows(ArithmeticException.class, 
    () -> NumberFinder.locate(edge, 7));

    }
}
