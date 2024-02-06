package BaekJoon.Silver.s2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class s2178_미로탐색 {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    // dx,dy를 같이 사용해서, 같은 인덱스 일때인 (1,0)=오른쪽, (0,1)=위쪽, (-1,0)=왼쪽, (0,-1)=아래쪽 으로 사용
    private static int[][] A;
    // [][]은 노드의 좌표, 들어가는 값은 1 또는 0으로 그 쪽으로 갈 수 있나 없나 확인을 위한 값
    private static boolean[][] visited;
    // 이차원 배열에 담긴 노드들의 방문 체크를 할 것이므로, 예를 들어 [1][1] 노드는 방문했다 안했다를 표현
    private static int N, M; // 함수에서 써야해서 static으로 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            A[i] = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
//          // 또 다른 방법
//            for(int j=0; j<M; j++){
//                A[i][j] = line.charAt(j) - '0';
//                // Integer.parseInt(line.substring(j,j+1)) 도 가능
//            }
        }
        visited[0][0] = true;
        BFS(0,0);

        System.out.println(A[N-1][M-1]);
        // 문제에서 (N,M)까지의 거리를 구하라고 했으니, A 배열값에 그 점까지의 거리값을 넣어놨으니 그걸 출력
    }
    private static void BFS(int i, int j){ // static 변수들 써야하니 static으로 선언
        Queue<int[]> q = new LinkedList<>(); // 좌표인 x,y 두 개를 담을 것이니 타입을 배열로 선언
        q.add(new int[] {i, j}); // 초기값 (0,0) 담기, main 함수에서 해도 되는데 큐가 BFS 함수에서 선언되서 여기서 함

        while (!q.isEmpty()){ // 큐가 빌 때 까지
            int now[] = q.poll(); // 꺼낸건 지금 방문한 노드라는 의미, =현재 노드
            // 이제 방문한 노드의 인접 노드들을 큐에 추가하러 감
            for(int k=0; k<4; k++){ // 현재 노드의 상하좌우(4개)를 봐야하므로 4까지 반복
                int x = now[0] + dx[k]; // now[0]은 현재노드의 x좌표
                int y = now[1] + dy[k]; // now[1]은 현재노드의 y좌표
                // 현재 노드의 x,y에 -1,0,1 중 하나를 더해, 상하좌우 중 한 노드의 좌표를 변수 x,y에 담음
                // for문에 의해 현재노드의 상하좌우 노드의 좌표가 다 한번씩 순서대로 담김
                if(x>=0 && y>=0 && x<N && y<M) // 상하좌우 배열이 배열을 벗어나지 않는 좌표인지 확인
                    if(A[x][y]!=0 && !visited[x][y]) { // 갈수 있는 좌표인지, 방문 안했던 좌표인지 확인
                        // 이제 갈 수 있는 좌표만 이쪽으로 옴
                        visited[x][y] = true; // 큐에 담은 노드 또 안 딤기 위해서 여기서 true로 해줘야 함
                        A[x][y] = A[now[0]][now[1]] + 1; // 현재 노드의 깊이보다 +1한 값을 담아줌
                        q.add(new int[] {x,y}); // 인접노드니까 담아 줌
                        // 모든 인접 노드를 다 담으면 for 문이 끝나고
                        // 다시 while문으로 가서 큐에 담은 걸 꺼내서 현재 노드가 됨
                        // 큐가 빌 때까지 = 더 이상 나아갈 인접노드가 없을때까지 반복
                    }



            }
        }
    }
}
