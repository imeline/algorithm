import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]); // 나간 지점 기준으로 정렬
        int camera = routes[0][1]; // 가장 처음의 나간 지점에 카메라 설치
        int answer = 1; // 위에서 하나 설치했으니, 1개부터 시작
        
        for(int i = 1; i < routes.length; i++) { // routes[0][1] 의 카메라 설치로, routes[0][0] 은 고려할 필요 없으니, 1부터 시작
            if(camera < routes[i][0]) { // 어떠한 차의 진입 시점 전에 카메라가 있었다 = 그 차가 만나는 카메라가 없다 -> 설치해줌 (진입시점이 아닌 나가는 시점에)
                answer++;
                camera = routes[i][1];
            }
        }
        return answer;
    }
}
