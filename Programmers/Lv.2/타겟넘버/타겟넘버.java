class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int index, int result) {
        // numbers.length 가 5일 때, index 는 0부터 시작했기 때문에 4가 마지막이지만
        // index 가 5일때 이 if 절에 오면 바로 return 되고 아래 코드가 실행안되기 때문에
        // index 가 4일 때까지만 count 수가 바뀌고 모든 과정이 실행됨 
        // 그러니 index + 1 == numbers.length 가 아니라 그냥 index 이다
        if (index == numbers.length) {
            return result == target ? 1 : 0;
        }
        
        int plus = dfs(numbers, target, index + 1, result + numbers[index]);
        int minus = dfs(numbers, target, index + 1, result - numbers[index]);

        // 두 가지 경로를 통해 구해진 target 도달 경우의 수를 전체 더 합침
        return plus + minus;
    }
}
