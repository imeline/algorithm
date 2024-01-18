package s1337_올바른배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s1337_올바른배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(arr);
        int start, end, answer = 4; // 연속된 수가 아예 없을 떄, 필요한 수의 갯수는 4개(아무 수 1개에 연속된 수 4개 붙이면 되니까)
        for(int i = 0; i < n; i++) {
            start = i;
            end = n-1;
            while(start < end){
                if(arr[end] - arr[start] >= 5) end--;
                else {
                    answer = Math.min(answer, 4 - (end-start));
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
