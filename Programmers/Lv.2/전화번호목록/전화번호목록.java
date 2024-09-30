import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(String phone : phone_book) {
            set.add(phone);
        }
        
        for(String phone : phone_book) {
            // 접두어를 확인하는 문제이기 때문에, 완전히 자기 자신과 같은 경우는 비교하지 않음
            for(int i = 1; i < phone.length(); i++) {
                if(set.contains(phone.substring(0, i))) 
                    return false;
            }
        }
        return true;
    }
}
