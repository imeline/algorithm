import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {                
        // List 와 ArrayList 는 인터페이스와 클래스(구현체)의 차이
        // ArrayList 가 아닌 List 로 선언하는 이유는 다형성 때문
        // -> 나중에 ArrayList 가 아닌 다른 클래스로 변경 가능 
        List<Integer> answer = new ArrayList<>(); // 최종 정답 배열
        HashMap<String, Integer> num = new HashMap<>(); // 장르별 총 재생 횟수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르별 (고유번호, 재생횟수)
        
        // -- 해시 맵 생성 --
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            num.put(genre, num.getOrDefault(genre, 0) + play);
            // computeIfAbsent() : 기존 genre 키가 있으면 그 값(해시맵) 리턴, 없으면 새로운 해시맵 생성
            // 그 후 리턴된 해시맵에 put(i, play) 해줌
            music.computeIfAbsent(genre, k -> new HashMap<>()).put(i, play);
        }
        
        // -- 정렬 --
        List<String> num_keys = new ArrayList(num.keySet());
        // num 내림차순 정렬
        Collections.sort(num_keys, (s1, s2) -> num.get(s2) - num.get(s1));
        // 재생 횟수로 정렬된 장르 이름을 가지고, music 해시 맵을 또 정렬해 답 구하기
        for(String num_key : num_keys) {
            // music 에서 for문을 통해 재생 횟수 순으로 장르를 키로 가진 값을 받을 해시 맵
            HashMap<Integer, Integer> map = music.get(num_key);
            List<Integer> map_keys = new ArrayList(map.keySet());
            // map(music의 값에 해당하는 해시맵의 키들 = 고유번호) 내림차순 정렬
            Collections.sort(map_keys, (s1, s2) -> map.get(s2) - map.get(s1));
            answer.add(map_keys.get(0));
            // 문제에서 한 장르 당 2개까지 답으로 제출하랬음
            if(map.size() > 1) answer.add(map_keys.get(1));
        }
        // List -> Array 로 변경
        // `answer.stream()`: answer 컬렉션을 스트림으로 변환
        // `mapToInt(i -> i)`: 스트림의 각 요소를 정수로 매핑, 여기선 그대로 반환
        // `toArray()`: 스트림의 요소들을 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
