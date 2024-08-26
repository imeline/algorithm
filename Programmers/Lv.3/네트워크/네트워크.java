class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 초기화 값으로 false 가 들어감
        int network_cnt = 0;
        
        for(int i = 0; i < n; i++) { // n = computers.length = computers[x].length
            if(!visited[i]) { // 아직 싸이클이 생성되지 않는 노드 기준으로, DFS를 통해 새로운 사이클 생성
                dfs(i, visited, computers); // 한 싸이클 생성
                network_cnt++;
            }
        }
        return network_cnt;
    }
    
    private void dfs(int node, boolean[] visited, int[][] computers) {
        visited[node] = true; // 이번 차례 기준노드 방문함
        
        for(int j = 0; j < computers.length; j++) { // 기준노드랑 연결된 노드들 확인함
            // 아직 싸이클이 생성 안 된(방문 안 한) 노드 && 기준노드랑 연결된 노드 
            // !visited[node] 를 통해 기준 노드 자신도 if 절에 해당 안되게끔 함 -> for문 위의 코드에서 방문했음 처리를 했기 때문
            if(!visited[j] && computers[node][j] == 1) { 
                dfs(j, visited, computers); // 기준 노드랑 j 노드랑 연결하고, 또 연결할 노드 없는지 찾으러 감
                // 어떤 노드와 어떤 노드가 연결됐음을 기록하진 않지만
                // 방문 했다 처리를 통해, (방문 = 이미 연결된 싸이클이 있음) 을 표현
                // 싸이클이 형성되면 카운트를 하고, 싸이클이 없는 노드들을 검사해 새 싸이클을 형성하면서
                // 싸이클이 몇 개인지만 알면 될때 유용
            }
        }
    }
}
