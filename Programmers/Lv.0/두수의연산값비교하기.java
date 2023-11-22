public class 두수의연산값비교하기 {
    public int solution(int a, int b) {
        String strA_B =  Integer.toString(a) + Integer.toString(b);
        int a_b = Integer.parseInt(strA_B);

        return (a_b >= 2*a*b) ? a_b : 2*a*b;
    }
    // 더 좋은 풀이
    // int a_b = Integer.parseInt(a + "" + b);
    // return Math.max(a_b, 2*a*b);
}
