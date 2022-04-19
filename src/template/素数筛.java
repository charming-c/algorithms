package template;

public class 素数筛 {
    static int N = 100010;
    static int[] primes = new int[N];   // 前面所有质数
    static int cnt = 0;                 // 质数个数
    static boolean st[] = new boolean[N];   // 是否被筛
    static int[] minp = new int[N];     // 某个数的最小质因数

    public static void getPrimes(int n) {
        for(int i = 2; i<=n; i++) {
            if(!st[i]) {
                primes[cnt++] = i;
                minp[i] = i;
            }

            for(int j = 0; primes[j] * i <= n; j++) {
                int t = primes[j] * i;
                st[t] = true;
                minp[t] = primes[j];
                if(i % primes[j] == 0) break;
            }
        }
    }
}
