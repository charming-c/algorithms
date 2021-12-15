package TestPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VolatileTest {
    static List<Integer> list = new ArrayList<>();
    static int len;
    static int ret[];
    public static int[] findEvenNumbers(int[] digits) {
        len = digits.length;
        ret = new int[len];
        Arrays.fill(ret,0);
        find(0,digits);
        int ans[] = new int[len];
        for(int i = 0; i<len; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public static void find(int num, int[] digits){
        if(num == 0){
            for(int i = 0; i<len; i++){
                if(digits[i] == 0) continue;
                else{
                    num = num * 10 + digits[i];
                    ret[i] = 1;
                    find(num,digits);
                }
                ret[i] = 0;
            }
        }
        else if(num > 0 && num < 10){
            for(int i = 0; i<len; i++){
                if(ret[i] == 1) continue;
                else{
                    num = num * 10 + digits[i];
                    ret[i] = 1;
                    find(num, digits);
                }
                ret[i] = 0;
            }
        }
        else if(num >= 10 && num < 100){
            for(int i = 0; i<len; i++){
                if(ret[i] == 1 || digits[i] % 2 == 1) continue;
                else{
                    num = num * 10 + digits[i];
                    list.add(num);
                }
            }
            return;
        }
        else{
            return;
        }
    }

    public static void main(String[] args) {
        int[] b = {2,1,3,0};
        int[] a = findEvenNumbers(b);
    }
}
