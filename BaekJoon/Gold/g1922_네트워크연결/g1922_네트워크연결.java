package BaekJoon.Gold.g1922_네트워크연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class g1922_네트워크연결 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 노드 수
		st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken()); // 간선 수
		int[][] edges = new int[E][3];
		parent = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				edges[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < E; i++) {
			if (find(edges[i][0]) != find(edges[i][1])) {
				union(find(edges[i][0]), find(edges[i][1]));
				sum += edges[i][2];
				// 전체 노드의 개수와 에지의 개수가 같으면, 사이클을 그리게 되므로 그 전에 break
				if (++cnt == V - 1)
					break;
			}
		}

		System.out.println(sum);
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y)
				parent[y] = x;
			else
				parent[x] = y;
		}
	}
}
