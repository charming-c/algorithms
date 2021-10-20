package October_2021;

public class WaysToMakeAFairArray_1664 {

    // 笨比解法，直接超时
    public static int waysToMakeFair(int[] nums) {
        int ans = 0;
        int length = nums.length;
        int[][] ret = new int[length][2];

        if(length == 1) return ans;

        ret[0][0] = 0;
        ret[0][1] = 0;
        ret[1][0] = nums[0];
        ret[1][1] = 0;

        for(int i = 2; i<length;i++){
            if( i%2 == 0 ){
                ret[i][0] = ret[i-1][0];
                ret[i][1] = ret[i-1][1] + nums[i-1];
            }
            else{
                ret[i][0] = ret[i-1][0] + nums[i-1];
                ret[i][1] = ret[i-1][1];
            }
        }

        for(int i = 0; i<length; i++){
            int oddSum = 0;
            int evenSum = 0;
            for(int j = i+1; j<length; j++){
                if((j-1) % 2 == 0){
                    evenSum += nums[j];
                }
                else{
                    oddSum += nums[j];
                }
            }

            if(oddSum+ret[i][1] == evenSum+ret[i][0]){
                ans++;
            }
        }
        return ans;
    }


    // 高手解法
    class Solution {
        public int waysToMakeFair(int[] nums) {

            int n = nums.length;
            int sumOdd = 0;//奇数下标元素和
            int sumEven = 0;//偶数下标元素和
            for(int i=0;i<nums.length;i++){
                if(i%2==0){//偶数
                    sumEven+=nums[i];
                }else{//奇数
                    sumOdd+=nums[i];
                }
            }

            int count = 0;

            for(int i=n-1;i>=0;i--){
                if((i)%2==0){//偶数下标
                    sumEven-=nums[i];
                    if(sumEven==sumOdd) count++;
                    sumOdd+=nums[i];
                }else{
                    sumOdd-=nums[i];
                    if(sumOdd==sumEven) count++;
                    sumEven+=nums[i];
                }
            }

            return count++;
        }
    }


}
