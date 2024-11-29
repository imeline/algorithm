public int solution(int n, int[] stations, int w) {
        int now = 1; // 현재 위치
        int s_idx = 0; // stations 인덱스
        int answer = 0; // 새 기지국 개수
        
        while(now <= n) {
            // 새 기지국 설치 시, stations[s_idx] 보다 왼쪽에 설치 됐으므로, stations[s_idx] 보다 최대 전파 인덱스가 작음
            // now >= stations[s_idx] - w 하면, stations[s_idx] - w <= now <= stations[s_idx] + w 한거나 마찬가지
            // 기존 기지국의 전파 범위 내
            if(s_idx < stations.length && now >= stations[s_idx] - w) {
                s_idx++;
                now = stations[s_idx] + w + 1;
            }
            else { // 기존 기지국의 전파가 닿지 않는 곳 - 기존 기지국의 전파 범위 왼쪽, 오른쪽 부분
                answer++;
                now += w * 2 + 1;
            }
        }     
        return answer;
}
