package extend;

public class test2 {

    public static void main(String[] args){
//        for (int i =101; i<=200; i++){
//            if(isPrime(i)){
//                System.out.print(i+" ");
//            }
//        }
        int m = 10;
        for(int i = 0; i<m; i++){
            System.out.println(i+" "+m);
            m--;
            break;
        }
    }

    public static boolean isPrime(int n){
        for(int i = 2; i<=n/2; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
