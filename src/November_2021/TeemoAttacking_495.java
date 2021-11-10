package November_2021;

//在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄。他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
//
//        当提莫攻击艾希，艾希的中毒状态正好持续 duration 秒。
//
//        正式地讲，提莫在 t 发起发起攻击意味着艾希在时间区间 [t, t + duration - 1]（含 t 和 t + duration - 1）处于中毒状态。如果提莫在中毒影响结束 前 再次攻击，中毒状态计时器将会 重置 ，在新的攻击之后，中毒影响将会在 duration 秒后结束。
//
//        给你一个 非递减 的整数数组 timeSeries ，其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，以及一个表示中毒持续时间的整数 duration 。
//
//        返回艾希处于中毒状态的 总 秒数。
//
//         
//        示例 1：
//
//        输入：timeSeries = [1,4], duration = 2
//        输出：4
//        解释：提莫攻击对艾希的影响如下：
//        - 第 1 秒，提莫攻击艾希并使其立即中毒。中毒状态会维持 2 秒，即第 1 秒和第 2 秒。
//        - 第 4 秒，提莫再次攻击艾希，艾希中毒状态又持续 2 秒，即第 4 秒和第 5 秒。
//        艾希在第 1、2、4、5 秒处于中毒状态，所以总中毒秒数是 4 。

public class TeemoAttacking_495 {
    // 都不想算自己写的，感觉最近写的题都是在做无用功，要么简单的一下写出来了，要么完全不会，没有在提升，很烦
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        int len = timeSeries.length;
        for(int i = 0; i<len; i++){
            if(i == 0){
                sum += duration;
                timeSeries[i] += duration;
            }
            else{
                timeSeries[i] += duration;
                if(timeSeries[i] >= timeSeries[i-1]){
                    sum += duration;
                }
                else{
                    sum += timeSeries[i] - timeSeries[i-1];
                }
            }
        }
        return sum;
    }
}
