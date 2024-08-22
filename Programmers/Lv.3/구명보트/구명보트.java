import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int min = 0, max = people.length - 1, boat = 0;
        // for 문 조건, min <= max 에 = 도 포함인 이유는
        // 마지막 한 명 남았을때도 boat++ 해야하므로 
        // if, else 절 아무거나 걸려도 상관 없이 boat++ 이 되니 for문을 돌림
        for(; min <= max; max--) { 
            if(people[min] + people[max] <= limit) min++; // 둘이 탄 경우. else 일 경우는 무거운 사람 혼자 탐
            boat++; // 둘이 타거나 혼자 타는 거 상관없이, boat는 한 개 사용
        }
        
        return boat;
    }
}
