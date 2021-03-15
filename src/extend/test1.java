package extend;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args){
        System.out.println("please enter the number of month:");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int num[] = new int[month];
        num[0] = 2;
        num[1] = 2;
        for(int i = 2; i<month; i++){
            num[i] = num[i-1] + num[i-2];
        }
        for(int i = 0; i<month; i++)
        System.out.println("第"+i+1+"个月兔子的数量是："+ num[i]);
    }
}
