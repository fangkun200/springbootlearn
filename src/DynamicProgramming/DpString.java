package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 动态规划-字符串相关
 **/
class DpString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abba"));
    }

    static class Solution {
        /**
         * 5. 最长回文子串
         * https://leetcode.cn/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=dynamic-programming
         **/
        public String longestPalindrome(String s) {
            int length = s.length();
            int[] dp = new int[length + 1];
            for (int i = 1; i < s.length(); i++) {

            }
            return "";
        }
    }


}
