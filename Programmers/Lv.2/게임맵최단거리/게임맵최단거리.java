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
