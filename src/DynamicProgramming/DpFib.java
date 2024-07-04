package DynamicProgramming;


/**
 * 动态规划-斐波那契相关
 **/
class DpFib {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(10));
        System.out.println(solution.fib(2));
        System.out.println(solution.tribonacci(5));
        int[] arr1 = new int[]{5, 15};
        System.out.println(solution.minCostClimbingStairs(arr1));
        int[] arr2 = new int[]{2, 1, 1, 2};
        System.out.println(solution.rob(arr2));
        int[] arr3 = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println(solution.deleteAndEarn(arr3));
    }

    static class Solution {
        /**
         * 740. 删除并获得点数
         * https://leetcode.cn/problems/delete-and-earn/
         **/
        public int deleteAndEarn(int[] nums) {
            int length = nums.length;
            if (length == 0) {
                return nums[0];
            }
            int max = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            int arr[] = new int[max + 1];
            for (int i = 0; i < nums.length; i++) {
                arr[nums[i]] += nums[i];
            }
            int dp[] = new int[max + 1];
            dp[0] = arr[0];
            dp[1] = Math.max(arr[0], arr[1]);
            for (int i = 2; i < max + 1; i++) {
                dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[max];
        }

        /**
         * 70. 爬楼梯
         * https://leetcode.cn/problems/climbing-stairs/
         **/
        public int climbStairs(int n) {
            int dp[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (i <= 3) {
                    dp[i] = i;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
            return dp[n];
        }

        /**
         * 509. 斐波那契数
         * https://leetcode.cn/problems/fibonacci-number/
         **/
        public int fib(int n) {
            int dp[] = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i <= 1) {
                    dp[i] = i;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
            return dp[n];
        }

        /**
         * 1137. 第 N 个泰波那契数
         * https://leetcode.cn/problems/n-th-tribonacci-number/
         **/
        public int tribonacci(int n) {
            int dp[] = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i <= 1) {
                    dp[i] = i;
                } else if (i == 2) {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
            }
            return dp[n];
        }

        /**
         * 746. 使用最小花费爬楼梯
         * https://leetcode.cn/problems/min-cost-climbing-stairs/
         **/
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int dp[] = new int[n + 1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
            }
            return dp[n];
        }

        /**
         * 198. 打家劫舍
         * https://leetcode.cn/problems/house-robber/
         **/
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            int dp[] = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[n - 1];
        }
    }
}


