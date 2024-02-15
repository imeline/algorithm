package BaekJoon.Silver.s1541_잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;  // 제일 초기 값인지 판별하기 위함. 초기값은 빼지면 안되기 때문

        String[] sub = br.readLine().split("-");

        for (int i = 0; i < sub.length; i++) {
            int temp = 0;
            String[] add = sub[i].split("\\+");

            for (int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }

            if (sum == Integer.MAX_VALUE) sum = temp;  // 초기값 넣기
            else sum -= temp;  // 초기값이 아닌 괄호의 합들 빼주기
        }
        System.out.println(sum);
    }
}
