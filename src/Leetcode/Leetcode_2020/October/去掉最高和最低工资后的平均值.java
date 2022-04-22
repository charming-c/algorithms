package Leetcode.Leetcode_2020.October;
//给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
//
//        请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
//
//        示例 1：
//
//        输入：salary = [4000,3000,1000,2000]
//        输出：2500.00000
//        解释：最低工资和最高工资分别是 1000 和 4000 。
//        去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500


public class 去掉最高和最低工资后的平均值 {
    public double average(int[] salary) {
        int max = 0, min = 0, count = 0;    //max，min分别存储最大和最小工资再salary[]数组的位置,非最大和最小工资位置的数加和存储置变量count中,初值置为0
        for(int i = 0; i < salary.length; i++)
        {
            if(salary[i] >= salary[max])    //找到最大工资位置
            {
                max = i;
            }
            if(salary[i] <= salary[min])    //找到最大工资位置
            {
                min = i;
            }
        }
        for(int i = 0; i < salary.length; i++)
        {
            if(i != max && i != min)        //对非最大和最小工资位置的数求和
            {
                count = count + salary[i];
            }
        }

        return count * 1.0 / (salary.length - 2);   //count为int型( * 1.0 变为double型)，为被除数；除数为salary[]数组长度减2（去除最大最小），得到double型平均工资
    }
}
