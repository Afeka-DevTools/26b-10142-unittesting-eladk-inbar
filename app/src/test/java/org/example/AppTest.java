package org.example;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void addShouldReturnSumOfTwoIntegers() {
        assertEquals(7, App.add(3, 4));
        assertEquals(0, App.add(-2, 2));
        assertEquals(-5, App.add(-2, -3));
    }

    @Test
    void isPrimeShouldIdentifyPrimeAndCompositeNumbers() {
        assertTrue(App.isPrime(2));
        assertTrue(App.isPrime(17));
        assertFalse(App.isPrime(1));
        assertFalse(App.isPrime(4));
        assertFalse(App.isPrime(0));
        assertFalse(App.isPrime(-3));
    }

    @Test
    void isPrimeShouldHandleBoundaryValuesAndCompositeNumbers() {
        assertFalse(App.isPrime(0));
        assertFalse(App.isPrime(1));
        assertTrue(App.isPrime(2));
        assertTrue(App.isPrime(3));
        assertFalse(App.isPrime(4));
        assertTrue(App.isPrime(5));
        assertFalse(App.isPrime(6));
        assertTrue(App.isPrime(7));
        assertFalse(App.isPrime(9));
        assertFalse(App.isPrime(15));
        assertTrue(App.isPrime(29));
        assertFalse(App.isPrime(-2));
    }

    @Test
    void reverseShouldReverseStrings() {
        assertEquals("olleh", App.reverse("hello"));
        assertEquals("", App.reverse(""));
        assertEquals("123321", App.reverse("123321"));
    }

    @Test
    void factorialShouldReturnExpectedValueForValidInput() {
        assertEquals(1, App.factorial(0));
        assertEquals(1, App.factorial(1));
        assertEquals(120, App.factorial(5));
    }

    @Test
    void factorialShouldHandleLargerInputsAndBoundaryValues() {
        assertEquals(1, App.factorial(0));
        assertEquals(1, App.factorial(1));
        assertEquals(2, App.factorial(2));
        assertEquals(6, App.factorial(3));
        assertEquals(3628800, App.factorial(10));
    }

    @Test
    void factorialShouldThrowForNegativeInput() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
        assertEquals("Negative number", ex.getMessage());
    }

    @Test
    void isPalindromeShouldIgnoreNonAlphanumericCharactersAndCase() {
        assertTrue(App.isPalindrome(""));
        assertTrue(App.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(App.isPalindrome("racecar"));
        assertFalse(App.isPalindrome("hello"));
        assertFalse(App.isPalindrome("ab"));
    }

    @Test
    void fibonacciUpToShouldReturnSequenceUpToLimit() {
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8), App.fibonacciUpTo(10));
        assertEquals(List.of(0), App.fibonacciUpTo(0));
    }

    @Test
    void fibonacciUpToShouldThrowForNegativeInput() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(-1));
        assertEquals("Negative input", ex.getMessage());
    }

    @Test
    void charFrequencyShouldCountCharactersInString() {
        Map<Character, Integer> expected = Map.of('b', 1, 'a', 3, 'n', 2);
        assertEquals(expected, App.charFrequency("banana"));
        assertTrue(App.charFrequency("").isEmpty());
    }

    @Test
    void isAnagramShouldCompareStringsIgnoringCaseAndWhitespace() {
        assertTrue(App.isAnagram("listen", "silent"));
        assertTrue(App.isAnagram("A gentleman", "elegant man"));
        assertTrue(App.isAnagram("", ""));
        assertFalse(App.isAnagram("hello", "world"));
    }

    @Test
    void averageShouldReturnMeanOfArray() {
        assertEquals(2.0, App.average(new int[]{1, 2, 3}), 0.0001);
        assertEquals(5.0, App.average(new int[]{5}), 0.0001);
        assertEquals(-1.0, App.average(new int[]{-3, 1}), 0.0001);
    }

    @Test
    void averageShouldHandleZerosNegativeValuesAndMultipleElements() {
        assertEquals(0.0, App.average(new int[]{0, 0, 0}), 0.0001);
        assertEquals(-1.0, App.average(new int[]{-2, -1, 0, 1, 2}), 0.0001);
        assertEquals(2.5, App.average(new int[]{1, 2, 3, 4}), 0.0001);
    }

    @Test
    void averageShouldThrowForEmptyArray() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> App.average(new int[]{}));
        assertEquals("Empty array", ex.getMessage());
    }

    @Test
    void filterEvensShouldReturnOnlyEvenNumbers() {
        assertEquals(List.of(2, 4, 6), App.filterEvens(List.of(1, 2, 3, 4, 5, 6)));
        assertTrue(App.filterEvens(List.of(1, 3, 5)).isEmpty());
        assertTrue(App.filterEvens(List.of()).isEmpty());
    }

    @Test
    void mostCommonWordShouldReturnTheMostFrequentWord() {
        assertEquals("test", App.mostCommonWord("This is a test. This test is only a test."));
        assertEquals("", App.mostCommonWord(""));
    }

    @Test
    void mostCommonWordShouldHandleRepeatedWordsAndPunctuation() {
        assertEquals("apple", App.mostCommonWord("apple banana apple orange apple"));
        assertEquals("hello", App.mostCommonWord("hello, hello! hello?"));
    }
}
