import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0, y = 0, nx = 0, ny = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < dirs.length(); i++) {
            switch(dirs.charAt(i)) {
                case 'U':
                    ny = y + 1;
                    break;
                case 'D':
                    ny = y - 1;
                    break;
                case 'R':
                    nx = x + 1;
                    break;
                case 'L':
                    nx = x - 1;
                    break;
            }
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                // 기존 값으로 되돌리기
                nx = x;
                ny = y;
                continue;
            }
            // 조건에서 방향을 고려하지 않으므로, A -> B 와 B -> A 모두 추가 필요
            set.add(x + "" + y + "" + nx + "" + ny);
            set.add(nx + "" + ny + "" + x + "" + y);
            // 이동 반영해주기 
            x = nx;
            y = ny;
        }
        // A -> B 와 B -> A 모두 add 했으니, /2 해주기
        return set.size() / 2; 
    }
}
