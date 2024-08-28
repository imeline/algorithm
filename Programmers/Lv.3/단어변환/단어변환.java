class Solution {
    static boolean[] visited; 
    static int answer;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length]; // words 안의 단어들을 사용했는지 여부
        answer = Integer.MAX_VALUE; // dfs 함수 안 cnt 와 min 비교를 위해 max

        dfs(begin, target, words, 0);  // 변환 수를 0개 부터 시작

        // target으로의 변환이 불가능한 경우 0을 반환
        return (answer == Integer.MAX_VALUE) ? 0 : answer; // 아무 성공한 변환 사이클이 없으면 초기값 그대로 일테니, 최종 0 리턴
    }

    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = Math.min(answer, cnt); // begin과 target이 같은 경우 중, 가장 작은 수를 최종 return 하기 위해 min 비교
            return;
        }
        // begin가 target이 같다면, 변환 성공이니 변환 횟수 리턴
        // 이 if절에 걸리는 일이 없다면 (begin가 target이 마지막 변환 후에도 다르면), 
        // cnt는 변환을 마치지 못한 수 = 실패의 수

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isConvertible(begin, words[i])) {
                visited[i] = true; // 해당 단어 사용. 문제에서 다시 사용하면 안된다는 말을 없지만, 이미 바꾸려는 단어는 바꿨으니 또 쓸일 없음
                dfs(words[i], target, words, cnt + 1); // begin이 word 단어로 변환, 변환 횟수 추가 // 다른 글자도 바꾸기 위해 dfs 계속 진행
                visited[i] = false; // for 문을 통해 다른 word 부터 시작했을때, 다시 변환 횟수를 세기 위해(모든 경우의 수를 보기 위해) 초기화
            }
        }
    }

    // 두 단어가 한 글자만 다르면 변환 가능
    public static boolean isConvertible(String word1, String word2) {
        int count = 0; // 몇 글자가 서로 다른지 카운트
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
}
