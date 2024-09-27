## 문제
[프로그래머스 - 게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844) <br>
: 알고리즘 - BFS

## 문제 풀이
- 단순 BFS 문제
  - BFS : 최단 경로를 찾아야 하거나 가중치가 없는 문제
  - DFS : 모든 경로를 탐색하거나 백트래킹을 해야 하는 문제
 
## 코드 개선

### 개선점
- `visited[][]` 를 사용하여 방문 여부를 확인했지만, `maps[][]` 로 방문함에 따라 지나온 거리를 계산한다면, <br>
`maps[][] == 1` 을 확인함으로써, 방문 여부 확인과 동시에 막힌 길인지 확인 가능 <br>
(지나온 길이면 거리가 더해져서 1보다 큰 수 일 것)

- 그리고 마지막 도착지 여부를 while 문 중간에 확인하는 코드를 추가함으로서, <br>
도착지에 도달한 후 필요없는 코드가 더 진행되지 않도록 함.

### 이전 코드
```java
import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        int[][] visited = new int[n][m];
       
        bfs(maps, visited);
        
        return visited[n - 1][m - 1] == 0 ? -1 : visited[n - 1][m - 1];
    }
    
    private void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = 1;
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];
                
                if(nX >= 0 && nX < n && nY >= 0 && nY < m) {
                    // 지나가지 않은 길이고, 벽이 아닐 때
                    if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                        visited[nX][nY] = visited[x][y] + 1;
                        q.add(new int[]{nX, nY});
                    }
                }
            }
        }
    }
}
```
⬇️
### 개선 코드 
```java
import java.util.*;

class Solution {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    private int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
       
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        maps[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            // 도착 지점에 도달하면 거리 반환
            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }
            
            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];

                // maps[nX][nY] 이 방문한 노드 였으면, 1이 아닌 더 큰 수이기 때문에 따로 검사하지 않고
                // maps[nX][nY] == 1 을 통해 방문한 노드인지, 벽이 아닌지 동시에 검사
                if (nX >= 0 && nX < n && nY >= 0 && nY < m && maps[nX][nY] == 1) {
                    maps[nX][nY] = maps[x][y] + 1;
                    q.add(new int[]{nX, nY});
                }
            }
        }
        
        return -1; // 도착할 수 없을 때
    }
}
```
