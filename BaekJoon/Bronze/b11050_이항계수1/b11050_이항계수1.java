package BaekJoon.Bronze.b11050_이항계수1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11050_이항계수1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) { // 초기화
			for (int j = 0; j <= N; j++) {
				arr[i][1] = i;
				arr[i][0] = 1;
				arr[i][i] = 1;
			}
		}

		for (int i = 3; i <= N; i++) { // 0,1,2 는 초기화된 수들이 자리
			for (int j = 2; j < i; j++) { // arr[i][i] 는 초기화 했으므로, 그 전까지
				arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			}
		}

		System.out.println(arr[N][K]);
	}
}
