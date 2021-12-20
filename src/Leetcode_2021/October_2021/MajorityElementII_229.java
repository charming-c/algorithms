package Leetcode_2021.October_2021;

//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
//         
//
//        Example 1:
//
//        Input: nums = [3,2,3]
//        Output: [3]
//        Example 2:
//
//        Input: nums = [1]
//        Output: [1]
//        Example 3:
//
//        Input: nums = [1,2]
//        Output: [1,2]


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII_229 {

    // 愚蠢的哈希表法
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : map.keySet()) {
            if (map.get(x) > len / 3) {
                list.add(x);
            }
        }

        return list;
    }


    // 摩尔投票法，yyds
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int element1 = 0;
            int element2 = 0;
            int vote1 = 0;
            int vote2 = 0;

            for (int num : nums) {
                if (vote1 > 0 && num == element1) { //如果该元素为第一个元素，则计数加1
                    vote1++;
                } else if (vote2 > 0 && num == element2) { //如果该元素为第二个元素，则计数加1
                    vote2++;
                } else if (vote1 == 0) { // 选择第一个元素
                    element1 = num;
                    vote1++;
                } else if (vote2 == 0) { // 选择第二个元素
                    element2 = num;
                    vote2++;
                } else { //如果三个元素均不相同，则相互抵消1次
                    vote1--;
                    vote2--;
                }
            }

            int cnt1 = 0;
            int cnt2 = 0;
            for (int num : nums) {
                if (vote1 > 0 && num == element1) {
                    cnt1++;
                }
                if (vote2 > 0 && num == element2) {
                    cnt2++;
                }
            }
            // 检测元素出现的次数是否满足要求
            List<Integer> ans = new ArrayList<>();
            if (vote1 > 0 && cnt1 > nums.length / 3) {
                ans.add(element1);
            }
            if (vote2 > 0 && cnt2 > nums.length / 3) {
                ans.add(element2);
            }

            return ans;
        }
    }

}
