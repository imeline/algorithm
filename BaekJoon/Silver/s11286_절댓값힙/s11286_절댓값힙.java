package BaekJoon.Silver.s11286_절댓값힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class s11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs) return o1 - o2;
            return first_abs - second_abs; // 선행으로 있던 값이 더 크면, 양수이므로 자리 바뀜
        });

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(q.isEmpty()) sb.append("0\n");
                else sb.append(q.poll()).append("\n");
            }
            else q.add(input);
        }
        System.out.println(sb);
    }
}
