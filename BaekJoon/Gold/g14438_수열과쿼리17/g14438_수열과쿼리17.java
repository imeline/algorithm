package BaekJoon.Gold.g14438_수열과쿼리17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class g14438_수열과쿼리17 {
	static int[] tree;
	static int leaf_start_idx;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = (int)Math.ceil(Math.log(N) / Math.log(2)); // 2^K >= N, 리프노드의 깊이, 트리 높이 - 1
		// 완전 이진 트리라도, 포화 이진 트리 size 구해서 뒤에 남은 idx를 사용하지 않음
		int tree_size = 1 << (K + 1); // K+1 은 트리 높이, 2^트리높이 는 포화 트리의 전체 노드 수
		tree = new int[tree_size];
		leaf_start_idx = 1 << K;

		// 트리 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = leaf_start_idx; i < leaf_start_idx + N; i++) { // 리프노드만 순회
			tree[i] = Integer.parseInt(st.nextToken());
		}
		// 포화 이진 트리가 아니고 완전 이진 트리일 때를 대비
		for (int i = leaf_start_idx + N; i < tree_size; i++) {
			tree[i] = INF;
		}
		for (int i = leaf_start_idx - 1; i > 0; i--) { // 리프노드 제외, 상위 부모 노드들만 순회
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (query == 1)
				updateTree(x, y);
			else
				bw.write(getMin(x, y) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	// 질의 값 구하기
	static int getMin(int start, int end) {
		start += leaf_start_idx - 1; // 리프노드 idx 로 변경
		end += leaf_start_idx - 1; // 리프노드 idx 로 변경
		int start_min = INF, end_min = INF;
		while (start <= end) {
			if (start % 2 == 1) {
				start_min = Math.min(tree[start], start_min);
				start++;
				// start 가 짝수라면 +1을 하던 안하던 같은 수가 나오기 때문에 할 필요 X
				// ex) 8 일 경우 8/2 = 4 , (8+1)/2 = 4
			}
			if (end % 2 == 0) {
				end_min = Math.min(tree[end], end_min);
				end--;
				// end 가 홀수라면 -1을 하던 안하던 같은 수가 나오기 때문에 할 필요 X
				// ex) 9 일 경우 9/2 = 4, (9-1)/2 = 4 -> 안 바뀜
				// ex) 8 일 경우 8/2 = 4, (8-1)/2 = 3 -> 바뀜
			}

			start /= 2;
			end /= 2;
		}
		return Math.min(start_min, end_min);
	}

	// 트리 업데이트
	static void updateTree(int update_idx, int update_value) {
		update_idx += leaf_start_idx - 1; // 리프 노드 idx로 바꿔주기
		tree[update_idx] = update_value;
		for (int i = update_idx / 2; i > 0; i /= 2) {
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
		}
	}
}
