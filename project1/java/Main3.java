package java;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        
        
        long[] different = new long[n + 1];
        
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long x = scanner.nextLong();
            
            different[l] += x;
            if (r + 1 <= n) {
                different[r + 1] -= x;
            }
        }
        
        long sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sum += different[i];
            sb.append(sum);
            sb.append(" ");
        }
        
        System.out.println(sb.toString());
    }
}