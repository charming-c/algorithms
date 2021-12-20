package Leetcode_2021.February_2021;

//中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
//
//        例如：
//
//        [2,3,4]，中位数是 3
//        [2,3]，中位数是 (2 + 3) / 2 = 2.5
//        给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
//        你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
//
//         
//
//        示例：
//
//        给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
//
//        窗口位置                      中位数
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7      1
//        1 [3  -1  -3] 5  3  6  7      -1
//        1  3 [-1  -3  5] 3  6  7      -1
//        1  3  -1 [-3  5  3] 6  7       3
//        1  3  -1  -3 [5  3  6] 7       5
//        1  3  -1  -3  5 [3  6  7]      6
//         因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。

import java.util.*;

public class SlidingWindowMedian_480 {

    // 通过了测试用例了，结果超出时间限制
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] ans = new double[len - k + 1];
        int i = 0;
        while(i + k <= len){
            int[] window = Arrays.copyOfRange(nums, i,k + i);
            Arrays.sort(window);
            if(k % 2 == 1){
                ans[i] = window[k / 2];
            }
            else{
                ans[i] =(double)window[k / 2]/2 + (double)window[k / 2 - 1]/2;
            }
            i++;
        }
        return ans;
    }

    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            DualHeap dh = new DualHeap(k);
            for (int i = 0; i < k; ++i) {
                dh.insert(nums[i]);
            }
            double[] ans = new double[nums.length - k + 1];
            ans[0] = dh.getMedian();
            for (int i = k; i < nums.length; ++i) {
                dh.insert(nums[i]);
                dh.erase(nums[i - k]);
                ans[i - k + 1] = dh.getMedian();
            }
            return ans;
        }
    }

    class DualHeap {
        // 大根堆，维护较小的一半元素
        private PriorityQueue<Integer> small;
        // 小根堆，维护较大的一半元素
        private PriorityQueue<Integer> large;
        // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
        private Map<Integer, Integer> delayed;

        private int k;
        // small 和 large 当前包含的元素个数，需要扣除被「延迟删除」的元素
        private int smallSize, largeSize;

        public DualHeap(int k) {
            this.small = new PriorityQueue<Integer>(new Comparator<Integer>() {
                public int compare(Integer num1, Integer num2) {
                    return num2.compareTo(num1);
                }
            });
            this.large = new PriorityQueue<Integer>(new Comparator<Integer>() {
                public int compare(Integer num1, Integer num2) {
                    return num1.compareTo(num2);
                }
            });
            this.delayed = new HashMap<Integer, Integer>();
            this.k = k;
            this.smallSize = 0;
            this.largeSize = 0;
        }

        public double getMedian() {
            return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
        }

        public void insert(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                ++smallSize;
            } else {
                large.offer(num);
                ++largeSize;
            }
            makeBalance();
        }

        public void erase(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            if (num <= small.peek()) {
                --smallSize;
                if (num == small.peek()) {
                    prune(small);
                }
            } else {
                --largeSize;
                if (num == large.peek()) {
                    prune(large);
                }
            }
            makeBalance();
        }

        // 不断地弹出 heap 的堆顶元素，并且更新哈希表
        private void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (delayed.containsKey(num)) {
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) {
                        delayed.remove(num);
                    }
                    heap.poll();
                } else {
                    break;
                }
            }
        }

        // 调整 small 和 large 中的元素个数，使得二者的元素个数满足要求
        private void makeBalance() {
            if (smallSize > largeSize + 1) {
                // small 比 large 元素多 2 个
                large.offer(small.poll());
                --smallSize;
                ++largeSize;
                // small 堆顶元素被移除，需要进行 prune
                prune(small);
            } else if (smallSize < largeSize) {
                // large 比 small 元素多 1 个
                small.offer(large.poll());
                ++smallSize;
                --largeSize;
                // large 堆顶元素被移除，需要进行 prune
                prune(large);
            }
        }
    }

}

