package Example;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args){
        System.out.println("please input a integer:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.print(number+"= ");
        getPrime(number);
    }
    public static void getPrime(int number){
        int k = 2;

        while (number != k){
            while (number % k == 0) {
                System.out.print(k+"*");
                number = number / k;
            }
            k++;
        }
        if(number == k) {
            System.out.print(k);
            return;
        }
    }
}
