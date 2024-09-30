## 문제
[프로그래머스 - 전화번호 목록](https://school.programmers.co.kr/learn/courses/30/lessons/42577) <br>
: 알고리즘 - 해시

## 문제 풀이
- HashSet 에 값들을 담아서 `set.contains` 함수를 이용해 다른 값들이 접두어인지 확인

## 코드 개선
- 해시 사용을 위해 기존 코드(전화번호목록.java)를 작성하였지만, 성능상 좋은 코드는 아님

### 더 좋은 코드 예시
```java
class Solution {
    public boolean solution(String[] phoneBook) {
       // 마지막 요소는 아래 for을 통해 앞의 값들과 다 비교했을테니 할 필요 X
       for(int i = 0; i < phoneBook.length - 1; i++) { 
            for(int j = i + 1; j < phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) return false;
                if(phoneBook[j].startsWith(phoneBook[i])) return false;
            }
        }
        return true;
    }
}
```
- `({String1}).startsWith({String2})` : String1 이 String2 로 시작하는지 확인
