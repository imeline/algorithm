## 문제
[프로그래머스 - 베스트앨범](https://school.programmers.co.kr/learn/courses/30/lessons/42579) <br>
: 알고리즘 - 해시

## 문제 풀이
- 장르별 총 재생 횟수, 장르별 (고유번호, 재생횟수) 를 가지는 HashMap 두 개 생성
- 재생 횟수 순으로 장르를 정렬하고, 그 정렬된 장르에서 재생횟수 순으로 고유번호를 정렬 <br>
-> 1. 재생 횟수 많은 장르 / 2. 재생 횟수 많은 고유 번호 순으로 정렬 됨 
- `Collections.sort` 를 사용하기 위해 List 에 담았던 정렬된 고유 번호를 array 로 변환해 최종 리턴

## 주요 코드
1. `answer.stream().mapToInt(i -> i).toArray()` <br>
   : List -> Array 로 변경 <br>
-> `answer.stream()`: answer 컬렉션을 스트림으로 변환 <br>
-> `mapToInt(i -> i)`: 스트림의 각 요소를 정수로 매핑, 여기선 그대로 반환 <br>
-> `toArray()`: 스트림의 요소들을 배열로 변환 

2. `Collections.sort(map_keys, (s1, s2) -> map.get(s2) - map.get(s1))` <br>
    : 람다식 이용해 정렬

3. `List<Integer> answer = new ArrayList<>()` <br>
    : List 와 ArrayList 는 인터페이스와 클래스(구현체)의 차이 <br>
   ->  ArrayList 가 아닌 List 로 선언하는 이유는 다형성 때문 <br>
   ->  나중에 ArrayList 가 아닌 다른 클래스로 변경 가능
   
## 코드 개선
```java
if(!music.containsKey(genres[i])) {
   num.put(genres[i], plays[i]);
   HashMap<Integer, Integer> map = new HashMap<>();
   map.put(i, plays[i]);
   music.put(genres[i], map);
}
else {
    num.put(genres[i], num.get(genres[i]) + plays[i]);
    // music.put(genres[i], -) 해줄 필요없이, music.get 해서 그 값 바꿔주면 music에 반영된다.
    music.get(genres[i]).put(i, plays[i]);
}
```
⬇️
```java
genrePlayCount.put(genre[i], genrePlayCount.getOrDefault(genre[i], 0) + play[i]);
music.computeIfAbsent(genre[i], k -> new HashMap<>()).put(i, play[i]);
```
`getOrDefault()` 과 `computeIfAbsent()` 을 통해 코드의 중복을 제거하고 간결함 높임
