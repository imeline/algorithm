package BaekJoon.Silver.s1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int tarket = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = nums.length - 1;
            boolean find = false;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] > tarket) end = mid - 1;
                else if (nums[mid] < tarket) start = mid + 1;
                else {
                    find = true;
                    break;
                }
            }
            if (find) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
