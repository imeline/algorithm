package BaekJoon.Silver.s11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s11724_연결요소의개수 {
    static boolean[] isvisited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isvisited = new boolean[n+1]; //노드 인덱스는 1부터니까 맞춰줌
        graph = new ArrayList[n+1]; //노드 인덱스는 1부터니까 맞춰줌

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>(); // 노드마다 있는 인접노드들을 arraylist에 넣기 위함
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v); // u번 노드의 인접노드인 v를 u의 arraylist에 넣어줌
            graph[v].add(u); // u번과 v가 인접이라면 v에도 u가 인접이란걸 넣어줘야함
        }
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(!isvisited[i]){ // 하나의 DFS를 끝냈을 떄, 1~n까지 노드 중 안 방문한 노드가 있는지 확인
                cnt++; // 한 DFS가 있는데, 안 방문한 노드가 있다는 건, 그 노드를 시작으로 새로운 DFS 시작을 의미
                DFS(i); // 새로운 DFS 시작
            }
        }
        System.out.println(cnt);
    }
    private static void DFS(int v){
        if(isvisited[v]) return; // 인접노드인데 방문했던거면, 재귀나가서 다른 노드로 가기
        isvisited[v] = true; // 안 방문 노드라면, 방문으로 바꿔줌 -> 주 목적 -> 모든 DFS 갯수를 세기 위해 모든 노드를 돌아야하므로
        // BFS와 달리 접하는 순서대로 방문한거기 때문에 여기서 방문 체크해도 됨
        for(int i : graph[v]) DFS(i); // v 노드의 인접 노드들을 for문으로 돌림
        // a 노드에 인접한 노드가 b,c 라고 가정하면
        // for문으로 a의 인접노드인 b에 가서, 재귀에 의해 b의 이어진 노드 끝까지 갔다가, 이제 갈 노드 없으면 빠져나오면
        // 다음 반복 순서인 c로 가서, c의 이어진 노드 끝까지 감
        // 세로로 이어진 노드들을 다 방문 후, 가로로 이어진 노드로 감
    }
}
