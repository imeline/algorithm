package BaekJoon.Gold.g11404_플로이드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class g11404_플로이드 {
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[][] short_distance = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {  // 배열 초기화
			for (int j = 1; j <= N; j++) {
				// 이어지지 않은 노드들 거리는 무제한으로 대입
				if (i != j)
					short_distance[i][j] = INF;
				// 배열 생성 시 0이 값으로 생성되었으니, i == j 시 0으로 값을 따로 넣어주지 않음
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			// 같은 출발, 도착 노드 사이의 거리가 다시 입력값으로 들어왔을 때를 대비해, min
			short_distance[a][b] = Math.min(short_distance[a][b], distance);
		}
		for (int k = 1; k <= N; k++) { // 경유지
			for (int i = 1; i <= N; i++) { // 시작 노드
				for (int j = 1; j <= N; j++) { // 도착 노드
					// 두 경로가 모두 무한대가 아닐 때만 갱신을 고려
					if (short_distance[i][k] != INF && short_distance[k][j] != INF) {
						short_distance[i][j] = Math.min(short_distance[i][j],
							short_distance[i][k] + short_distance[k][j]);
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (short_distance[i][j] == INF)
					bw.write("0 ");
				else
					bw.write(short_distance[i][j] + " ");
			}
			bw.newLine();
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
