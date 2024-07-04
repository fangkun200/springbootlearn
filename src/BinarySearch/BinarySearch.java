package BinarySearch;

/**
 * 二分查找
 * https://leetcode.cn/problems/triangle/?envType=study-plan-v2&envId=dynamic-programming
 **/
public class BinarySearch {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {2, 5};
        int target = 2;
        System.out.println(solution.search(nums, target));
    }
}

class Solution2 {
    /**
     * 704. 二分查找
     * https://leetcode.cn/problems/binary-search/?envType=study-plan-v2&envId=binary-search
     **/
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 1 && nums[0] == target) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        int middle = length / 2;
        int result = -1;
        while (left <= right) {
            if (nums[middle] == target) {
                result = middle;
                break;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            middle = (right + left) / 2;
        }
        return result;
    }
}