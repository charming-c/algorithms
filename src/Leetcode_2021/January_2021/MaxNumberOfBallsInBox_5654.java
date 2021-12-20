package Leetcode_2021.January_2021;

import java.util.Arrays;

public class MaxNumberOfBallsInBox_5654 {

    public int countBalls(int lowLimit, int highLimit) {
        int[] stage = new int[100];
        Arrays.fill(stage,0);
        for(int i = lowLimit; i<= highLimit; i++){
            int temp = i;
            int save = 0;
            while(temp != 0){
                save += temp % 10;
                temp = temp / 10;
            }
            stage[save] += 1;
        }
        int max = 0;
        for(int i = 0; i<stage.length; i++){
            if(stage[i] > stage[max]){
                max = i;
            }
        }
        return stage[max];
    }
}
