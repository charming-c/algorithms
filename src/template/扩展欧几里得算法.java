package template;

public class 扩展欧几里得算法 {
        // 扩展欧几里德算法
        public static int exgcd(int n, int d, long[] a, long[] b) {
            if (d == 0) {
                a[0] = 1; b[0] = 0;
                return n;
            }
            int gcd = exgcd(d, n % d, b, a);
            b[0] -= n / d * a[0];
            return gcd;
        }

}
