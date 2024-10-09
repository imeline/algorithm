## 문제
[프로그래머스 - 방문 길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994) <br>
: 알고리즘 - 배열, HashSet

## 문제 풀이
- 한번 지나온 길 다시 체크하지 않기 <br>
-> HashSet 의 중복 값 제거 특성을 이용해 String 으로 저장 <br>
-> `(x,y) -> (nx,ny)` 로 이동했다면, `x + "" + y + "" + nx + "" + ny` 로 저장

### 주의점
- 이동의 방향성을 고려하지 않는 문제이니, <br>
  `(x,y) -> (nx,ny)` 로 이동했다면, `(nx,ny) -> (x,y)` 의 이동도 set 에 더해주기
- 또한 마지막 최종 개수를 return 할 때, 위에서 2개씩 더했으므로 **나누기 2 해주기**


## 코드
```java
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
```

### HashMap 을 사용한 코드
```java
class Solution {
  public int solution(String dirs) {
    HashMap<Character, int[]> location = new HashMap<>();
    location.put('U', new int[]{0, 1});
    location.put('D', new int[]{0, -1});
    location.put('L', new int[]{-1, 0});
    location.put('R', new int[]{1, 0});
    int x = 5, y = 5;
    Hashset<String〉 answer = new Hashset<>();

    for (int i = 0; i < dirs. length(); i++) {
      int[] offset = location.get(dirs.charAt(i));
      int nx = x + offset[0];
      int ny = y + offset[1];

      if(nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                nx = x;
                ny = y;
                continue;
      }
      answer.add(x + "" +y + "" + nx + "" + ny);
      answer.add(nx + "" + ny + "" + x + "" + y);

      x = nx;
      y = ny;
    }

    return answer.size() / 2;
  }
}
```
