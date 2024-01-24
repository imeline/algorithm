package s2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class s2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }

        while(q.size() > 1){
            q.remove();
            int tmp = q.poll();
            q.add(tmp);
        }
        System.out.println(q.peek());
    }
}
