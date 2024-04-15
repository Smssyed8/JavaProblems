package org.javaproblems.problems.palindrome;
import java.util.regex.Pattern;
/**
 * Problem Statement:
 * Given a string, write a Java method to determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * Example:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Solution Approach:
 * To solve this problem, we can use a two-pointer approach.
 * We iterate through the string from both ends, ignoring non-alphanumeric characters,
 * and compare characters. If they match, we continue; otherwise, we return false.
 * We continue this process until the two pointers meet in the middle of the string.
 */
public class GivenStringIsPalindromeOrNotOnlyAlphanumeric {
    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return true;

        int left = 0, right = s.length() - 1;

        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            if (leftChar != rightChar)
                return false;

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is '" + s + "' a palindrome? " + isPalindrome(s));
    }

    // can also use below method for regex check
    public static boolean isAlphanumericASCII(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    // or
    public static boolean isAlphanumericRegex(char c) {
        return Pattern.matches("[a-zA-Z0-9]", String.valueOf(c));
    }
}
