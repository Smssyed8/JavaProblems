package org.javaproblems.problems.palindrome;

/**
 * Problem Statement:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Example:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Solution Approach:
 * We can solve this problem using a stack data structure. We iterate through the characters of the string.
 * Whenever we encounter an opening bracket, we push it onto the stack. When we encounter a closing bracket,
 * we check if the stack is empty or if the top of the stack contains the corresponding opening bracket.
 * If it does, we pop the top element from the stack.
 * If at the end the stack is empty, it means all brackets are matched properly.
 */

import java.util.Stack;
//ValidParenthesis
public class OpenCloseBracetMatch {
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return true;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println("Is '" + s + "' valid? " + isValid(s));
    }
}

