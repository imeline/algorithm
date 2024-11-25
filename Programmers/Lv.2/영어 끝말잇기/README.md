## 문제
[프로그래머스 - 영어 끝말잇기](https://school.programmers.co.kr/learn/courses/30/lessons/12981) <br>
: 알고리즘 - 해시

## 문제 풀이
- HashSet 에 string 을 add 해 중복 값 확인
- **`HashSet.add()` 는 중복 값이 add 시도되면, <br>
  그 값을 추가하지 않고 `false` 를 리턴하는 것을 이용해 풀이**
- (다른 풀이) `HashSet.size() != i + 1` 같이 중복 값이 add 시도 됐으면, <br>
  그 값이 추가되지 않았을 것이기 때문에 <br>
  `그 수가 더해진 차례`와 `size` 가 다를 것이므로, 그것으로 확인 가능

## 코드
```java
public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int cnt = 0; 
        for(int i = 1; i < words.length; i++) {
            if( !set.add(words[i]) || 
                  words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0) ) {
                cnt = i;
                break;
            }
        }
        if(cnt == 0) return new int[] {0,0};
        return new int[] { cnt % n + 1, cnt / n + 1};
    }
```
