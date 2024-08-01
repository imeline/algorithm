package BaekJoon.Gold.g1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g1717_집합의표현 {
	static int N, M;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N+1];

		for(int i=0; i<N+1; i++) parent[i] = i;

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 두 집합을 합해라
			if(command == 0) union(a,b);
			// 같은 집합에 속했는지 확인하고 결과 출력
			else {
				if (find(a) == find(b)) System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

	public static int find(int x) {
		if (x == parent[x]) return x;

		return parent[x] = find(parent[x]); // 부모의 부모를 찾음
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if(x < y) parent[y] = x;
			else parent[x] = y;
		}
	}
}
