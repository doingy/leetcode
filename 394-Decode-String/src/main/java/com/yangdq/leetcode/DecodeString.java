package com.yangdq.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        ptr = 0;
        src = s;
        return recursive();
    }

    private int ptr;

    // 堆栈方法实现
    private String stack(String s) {
        Stack<String> stack = new Stack<>();

        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digit = getDigit(s);
                stack.push(digit);
            } else if (Character.isLetter(cur) || cur == '[') {
                stack.push(String.valueOf(s.charAt(ptr++)));
            } else { // ]
                ++ptr;

                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peek())) {
                    sub.add(stack.pop());
                }
                Collections.reverse(sub);
                // "[" 出栈
                stack.pop();

                int count = Integer.parseInt(stack.pop());
                String tmp = getString(sub).repeat(count);
                stack.push(tmp);
            }
        }

        return getString(stack);
    }

    private String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr++));
        }
        return sb.toString();
    }

    private String getString(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s :
                list) {
            sb.append(s);
        }
        return sb.toString();
    }

    private String getString(Stack<String> stack) {
        ArrayList<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        Collections.reverse(list);

        return String.join("", list);
    }

    private String src;

    // 递归
    private String recursive() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }

        char cur = src.charAt(ptr);
        String ret = "";
        if (Character.isDigit(cur)) {
            // String -> Digit [ String ] String
            // 解析 数字
            String count = getDigit(src);
            // 过滤左括号
            ++ptr;
            // 解析字符串
            String str = recursive();
            // 过滤右括号
            ++ptr;
            ret += str.repeat(Integer.parseInt(count));
        } else if (Character.isLetter(cur)) {
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + recursive();
    }

}
