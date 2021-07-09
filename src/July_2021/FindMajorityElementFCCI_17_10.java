package July_2021;

//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
//
//         
//
//        示例 1：
//
//        输入：[1,2,5,9,5,9,5,5,5]
//        输出：5
//        示例 2：
//
//        输入：[3,2]
//        输出：-1
//        示例 3：
//
//        输入：[2,2,1,1,1,2,2]
//        输出：2

public class FindMajorityElementFCCI_17_10 {

    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;

        for(int num : nums){
            if(count == 0)
                major = num;
            if(major == num) count++;
            else count--;
        }

        count = 0;
        for(int num : nums){
            if(num == major) count++;
        }

        if(count > nums.length/2)
            return major;
        else return -1;
    }

}
