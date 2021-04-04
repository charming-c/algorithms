package Example;

public class test3 {
    public static void main(String[] args){
        for (int i = 100; i<10000; i++){
            int m = i;
            int sum = 0;
            while (m != 0){
                sum += (m%10) * (m%10) *(m % 10);
                m = m / 10;
            }
            if(sum == i)
                System.out.print(" "+i);
        }
    }
}
