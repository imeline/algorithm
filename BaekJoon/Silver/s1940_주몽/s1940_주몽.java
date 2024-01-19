package s1940_주몽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(arr);
        int start = 0, end = n-1, count = 0, sum;
        while(start < end){
            sum = arr[start] + arr[end];
            if(sum > m) end--;
            else if(sum == m) {
                count++;
                start++;
                end--;
            }
            else {
                start++;
            }
        }
        System.out.println(count);
    }
}