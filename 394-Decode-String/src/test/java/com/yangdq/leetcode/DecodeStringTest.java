package com.yangdq.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeStringTest {

    private DecodeString decodeString = new DecodeString();

    @Test
    @DisplayName("3[a]2[bc] -> aaabcbc")
    void testDecodeString1() {
        assertEquals("aaabcbc", decodeString.decodeString("3[a]2[bc]"));
    }

    @Test
    @DisplayName("3[a2[c]] -> accaccacc")
    void testDecodeString2() {
        assertEquals(decodeString.decodeString("3[a2[c]]"), "accaccacc");
    }

    @Test
    @DisplayName("2[abc]3[cd]ef -> abcabccdcdcdef")
    void testDecodeString3() {
        assertEquals(decodeString.decodeString("2[abc]3[cd]ef"), "abcabccdcdcdef");
    }

    @Test
    @DisplayName("3[z]2[2[y]pq4[2[jk]e1[f]]]ef -> zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef")
    void testDecodeString4() {
        assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef", decodeString.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
