package stringbuilder;

import stringconcat.stringconcat.Title;

public class Palindrome {
    private StringBuilder palidrom = new StringBuilder();

    public boolean isPalindrome(String sentenceOrWord) {
        if (sentenceOrWord == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        if (sentenceOrWord.trim().endsWith(".")) {
            sentenceOrWord = sentenceOrWord.replace(".", "");
        }
        if (sentenceOrWord.trim().endsWith("?")) {
            sentenceOrWord = sentenceOrWord.replace("?", "");
        }
        if (sentenceOrWord.trim().endsWith("!")) {
            sentenceOrWord = sentenceOrWord.replace("!", "");
        }
        if (sentenceOrWord.trim().contains("-")) {
            sentenceOrWord = sentenceOrWord.replace("-", "");
        }

        sentenceOrWord = sentenceOrWord.trim().replace(" ", "").toLowerCase();
        System.out.println(sentenceOrWord);
        palidrom.append(sentenceOrWord);
        if (palidrom.toString().equalsIgnoreCase(palidrom.reverse().toString())) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome2(String text) {                                 // Solution
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        text = text.trim();

        StringBuilder sb = new StringBuilder(text);
        return text.equalsIgnoreCase(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome("alma"));
        System.out.println(new Palindrome().isPalindrome("görög"));
        System.out.println(new Palindrome().isPalindrome("   A kultúra rút luka"));
        System.out.println(new Palindrome().isPalindrome("Aludna ma a mandula!"));
        System.out.println(new Palindrome().isPalindrome("Nem palidróma!"));
        System.out.println(new Palindrome().isPalindrome("Eledelemet emeled-e le?   "));
    }
}
