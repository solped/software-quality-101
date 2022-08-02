package com.krungsri.workshop.tdd.string;


public class StringProcessorImpl implements StringProcessor {
    @Override
    public Integer countVowels(String message) throws EmptyStringException {
        if (message.isEmpty()) {
            throw new EmptyStringException();
        }
        int count = 0;
        String vowels = "aeiou";
        char[] chars = message.toCharArray();
        for (char aChar : chars) {
            boolean contains = vowels.contains(String.valueOf(aChar).toLowerCase());
            if (contains) {
                count++;
            }
        }
        return count;
    }
}
