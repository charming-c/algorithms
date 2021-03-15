package extend;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args){
        System.out.println("please input your grade:");
        Scanner scanner = new Scanner(System.in);
        int grade = scanner.nextInt();
        if(grade < 90){
            if(grade < 60)
                System.out.println("C");
            else System.out.println("B");
        }
        else System.out.println("A");
    }
}
