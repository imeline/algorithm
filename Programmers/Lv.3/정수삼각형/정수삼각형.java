import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) { // 루트노드 제외하고, 1부터 시작
            // 가장 왼쪽
            triangle[i][0] += triangle[i-1][0];
            // 가장 오른쪽
            triangle[i][i] += triangle[i-1][i-1];
            // 중간
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}
