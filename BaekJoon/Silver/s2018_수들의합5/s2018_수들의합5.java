package s2018_수들의합5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class s2018_수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int sum = 0, count = 0, end = 1;  //start와 end 모두 1부터 시작

        for(int start=1; start<=target; start++){
            while ((sum < target) && (end <= target)){
                sum += end;
                end++;
            }
            if(sum == target) count++;
            sum -= start;
        }
        System.out.println(count);
    }
}
