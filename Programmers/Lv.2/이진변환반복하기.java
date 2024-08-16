class Solution {
    public int[] solution(String s) {
        int change_cnt = 0, zero_cnt = 0;
        
        while(!s.equals("1")) {
            change_cnt++;
            int prior_length = s.length();
            int now_length = s.replace("0", "").length();
            zero_cnt += prior_length - now_length;
            s = String.valueOf(Integer.toBinaryString(now_length));
        }
        
        return new int[] {change_cnt, zero_cnt};
    }
}
