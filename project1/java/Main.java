
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int maxLen = 0, temp;
        for(int j = 0;j < m;j++){
            temp = maxWay(arr, 0, j, n, m)+1;
            if(temp > maxLen){
                maxLen = temp;
            }
        }
        System.out.println(maxLen);
    }
    static int maxWay(int[][] arr, int i, int j, int n, int m){

        if(i == n-1) return 0;
        int check = 0;
        
        int maxLen = 0, temp;
        if(i < n-1 && j > 0 && arr[i+1][j-1] > arr[i][j]){
            temp = maxWay(arr, i+1, j-1, n, m)+1;
            if(temp > maxLen) maxLen = temp;
        }else{
            check++;
        }
        if(i < n-1 && j < m-1 && arr[i+1][j+1] > arr[i][j]){
            temp = maxWay(arr, i+1, j+1, n, m)+1;
            if(temp > maxLen) maxLen = temp;
        }else{
            check++;
        }

        if(i < n-1 && arr[i+1][j] > arr[i][j]){
            temp = maxWay(arr, i+1, j, n, m)+1;
            if(temp > maxLen) maxLen = temp;
        }else{
            check++;
        }
        if(check == 3) return 0;
        return maxLen;

    }

}


