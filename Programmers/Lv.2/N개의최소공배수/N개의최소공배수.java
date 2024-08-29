class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
         // 세 수의 최소공배수 = (두 수의 최소공배수)와 (나머지 한 수)의 최소공배수 
        for(int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);   
        }      
        return answer;
    }
  
    private int gcd(int a, int b) { // 최대 공약수
        if (a > b)
            return (a % b == 0) ? b : gcd(b, a % b);
        else
            return (b % a == 0) ? a : gcd(a, b % a);
    }
    
    private int lcm(int a, int b) { // 최소 공배수
        return a * b / gcd(a, b); 
    }
}
