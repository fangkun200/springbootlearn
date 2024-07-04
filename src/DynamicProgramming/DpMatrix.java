package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 动态规划-矩阵相关
 *
 **/
class DpMatrix {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr1 = new int[][]{{2, 2, 3}, {3, 3, 4}};
        System.out.println(solution.minPathSum(arr1));
        int[][] arr2 = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(arr2));
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> colors1 = Stream.of(2).collect(toList());
        List<Integer> colors2 = Stream.of(3, 4).collect(toList());
        List<Integer> colors3 = Stream.of(6, 5, 7).collect(toList());
        List<Integer> colors4 = Stream.of(4, 1, 8, 3).collect(toList());
        list.add(colors1);
        list.add(colors2);
        list.add(colors3);
        list.add(colors4);
        System.out.println(solution.minimumTotal(list));
        System.out.println(solution.minimumTotal2(list));
        char[][] arr3 = new char[][]{{'0', '0', '0', '1'}, {'1', '1', '0', '0'}, {'1', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}};
        System.out.println(solution.maximalSquare(arr3));
    }

    static class Solution {
        /**
         * 221. 最大正方形
         * https://leetcode.cn/problems/maximal-square/?envType=study-plan-v2&envId=dynamic-programming
         **/
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            int maxValue = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1;
                        if (i > 0 && j > 0 && dp[i - 1][j - 1] > 0 && i >= dp[i - 1][j - 1] && j >= dp[i - 1][j - 1]) {
                            int ins = 0;
                            for (int k = 1; k <= dp[i - 1][j - 1]; k++) {
                                if (matrix[i - k][j] == '0' || matrix[i][j - k] == '0') {
                                    break;
                                }
                                ins++;
                            }
                            dp[i][j] = ins + 1;
                        }
                        maxValue = Math.max(maxValue, dp[i][j]);
                    }
                }
            }
            return maxValue * maxValue;
        }

        /**
         * 931. 下降路径最小和
         * https://leetcode.cn/problems/minimum-falling-path-sum/?envType=study-plan-v2&envId=dynamic-programming
         **/
        public int minFallingPathSum(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    int minValue = matrix[i + 1][j];
                    if (j > 0) {
                        minValue = Math.min(minValue, matrix[i + 1][j - 1]);
                    }
                    if (j < n - 1) {
                        minValue = Math.min(minValue, matrix[i + 1][j + 1]);
                    }
                    matrix[i][j] += minValue;
                }
            }
            int result = matrix[0][0];
            for (int i = 1; i < n; i++) {
                result = Math.min(result, matrix[0][i]);
            }
            return result;
        }

        /**
         * 120. 三角形最小路径和1
         * https://leetcode.cn/problems/triangle/?envType=study-plan-v2&envId=dynamic-programming
         **/
        public int minimumTotal(List<List<Integer>> triangle) {
            int length = triangle.size();
            int[][] array = new int[length][length];
            array[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < triangle.size(); i++) {
                array[i][0] = array[i - 1][0] + triangle.get(i).get(0);
                for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                    array[i][j] = Math.min(array[i - 1][j], array[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                array[i][i] = array[i - 1][i - 1] + triangle.get(i).get(i);
            }
            int minValue = array[length - 1][0];
            for (int i = 1; i < length; i++) {
                if (minValue > array[length - 1][i]) {
                    minValue = array[length - 1][i];
                }
            }
            return minValue;
        }

        public int minimumTotal2(List<List<Integer>> triangle) {
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    int minValue = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                    triangle.get(i).set(j, minValue);
                }
            }
            return triangle.get(0).get(0);
        }

        /**
         * 63. 不同路径 II
         * https://leetcode.cn/problems/unique-paths-ii/?envType=study-plan-v2&envId=dynamic-programming
         **/
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;
            int[][] dp = new int[row][col];
            for (int i = 0; i < row; i++) {
                if (obstacleGrid[i][0] == 0) {
                    dp[i][0] = 1;
                } else {
                    break;
                }
            }
            for (int i = 0; i < col; i++) {
                if (obstacleGrid[0][i] == 0) {
                    dp[0][i] = 1;
                } else {
                    break;
                }
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
            return dp[row - 1][col - 1];
        }

        /**
         * 64. 最小路径和
         * https://leetcode.cn/problems/minimum-path-sum/
         **/
        public int minPathSum(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int[][] dp = new int[row][col];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < row; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }
            for (int j = 1; j < col; j++) {
                dp[0][j] = grid[0][j] + dp[0][j - 1];
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[row - 1][col - 1];
        }

        /**
         * 62. 不同路径
         * https://leetcode.cn/problems/unique-paths/
         **/
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }


}
