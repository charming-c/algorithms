package October;

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
