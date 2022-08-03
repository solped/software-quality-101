package com.krungsri.workshop.tdd.string;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class StringProcessorImplTest {

    private static Stream<Arguments> dataProviderStringsWithVowels() {
        return Stream.of(
                Arguments.of("ahahah", 3),
                Arguments.of("aeiou", 5),
                Arguments.of("blahblah", 2),
                Arguments.of("aAAAAA", 6),
                Arguments.of("aEiOu", 5)
        );
    }

    private static Stream<Arguments> dataProviderStringsWithoutVowels() {
        return Stream.of(
                Arguments.of("bcdfgh"),
                Arguments.of("mmmm"),
                Arguments.of("zzzzzzzzzz")
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderStringsWithVowels")
    void givenVowelsExist_whenCountVowels_thenReturnNumberOfVowels(String message, int expectedCount) throws EmptyStringException {

    }

    @ParameterizedTest
    @MethodSource("dataProviderStringsWithoutVowels")
    void givenVowelsDontExist_whenCountVowels_thenReturnNumberZero(String message) throws EmptyStringException {

    }

    @Test
    void givenStringIsEmpty_whenCountVowels_thenReturnEmptyStringException() {

    }
}