## 문제
[프로그래머스 - 신고 결과 받기](https://school.programmers.co.kr/learn/courses/30/lessons/92334) <br>
: 알고리즘 - 해시

## 문제 풀이
- [신고된 자 - 신고한 유저 목록] map 만들어서,<br>
  신고 k번이 넘어 정지된 자들을 선별하고,<br>
  그 정지된 자들을 신고한 유저 목록에 이메일 count + 1,<br>
  이름 순으로 정답 배열 생성

- 해시 문제는 함수를 아는 것이 중요
  - **HashMap**
    - put(), get()
    - containsKey() : key 중 있는지 확인
    - keySet() : 키 목록
    - getOrDefault(key, 없으면 가져올 value)
    - putIfAbsent(key, 없으면 넣을 value)
  - **HashSet**
    - add(), `for(key : set)` 처럼 for-each 문으로 키 뽑아 씀
   

## 코드
```java
public int[] solution(String[] id_list, String[] report, int k) {
        // 신고된 유저 - 신고한 유저 목록
        HashMap<String, HashSet<String>> reportedBy = new HashMap<>();
        // 메일을 받는 횟수를 저장할 Map
        HashMap<String, Integer> mailCount = new HashMap<>();
        // [신고자 - 신고된 자들] 구조로 map 을 만들었다면, for(이용자) {for(정지자) contain함수} 로 n x n 인데
        // [신고된 자들 - 신고자] 구조로 하면 for(정지자) 로 n 만 하면 된다.
        // 동일한 유저에 대한 신고 횟수는 1회로 처리해야해서 Set 사용
  
        // reportedBy map 생성
        for (String r : report) {
            String[] ids = r.split(" ");
            String reporter = ids[0];
            String reported = ids[1];
            
            reportedBy.putIfAbsent(reported, new HashSet<>());
            reportedBy.get(reported).add(reporter);
        }
        
        // mailCount map 생성
        for (Map.Entry<String, HashSet<String>> entry : reportedBy.entrySet()) {
            HashSet<String> reporters = entry.getValue();
            if (reporters.size() >= k) { // 정지 조건을 충족할 경우
                for (String reporter : reporters) {
                    mailCount.put(reporter, mailCount.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        
        // 결과 배열 생성 (id_list 이름 순서에 맞춰 메일 횟수 할당)
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
```
