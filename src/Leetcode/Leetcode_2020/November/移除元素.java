package Leetcode.Leetcode_2020.November;

//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
//        不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
//        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//
//         
//
//        示例 1:
//
//        给定 nums = [3,2,2,3], val = 3,
//
//        函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
//
//        你不需要考虑数组中超出新长度后面的元素。
//        示例 2:
//
//        给定 nums = [0,1,2,2,3,0,4,2], val = 2,
//
//        函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
//
//        注意这五个元素可为任意顺序。
//
//        你不需要考虑数组中超出新长度后面的元素。

public class 移除元素 {

//    自己写的垃圾算法
    public int removeElement(int[] nums, int val) {
        int end = nums.length-1;
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0; i<end; i++){
            while(end>=0 &&nums[end] == val){
                end--;
            }
            if(end<0){
                break;
            }
            while(i<end&&nums[i] != val){
                i++;
            }
            if(i>=end) break;
            nums[i] = nums[end--];
        }
        if(end<0 || nums[end] != val)
            return end+1;
        else return end;
    }

    /*
    * 下面请欣赏官方题解
    */

    //用了一次遍历，用了两个指针
    //快指针：用于遍历数组，
    //慢指针用于抓去不是目标的元素
    //当快指针递进时，只有当快指针没有到val时，讲快指针的值给到慢指针，因为无论如何快指针要么在前，要么和慢指针同步，
    //一次遍历以后，慢指针就能覆盖到所有快指针遍历到的不是val的值
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }



    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            //当元素的值为val时，将末尾的值换到前面来，并将长度减少1，
            //不用担心换来的值是否为val，因为i没变，迭代时任然从原来的位置开始
            //而元素的值不为val时，仍然继续后移
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
