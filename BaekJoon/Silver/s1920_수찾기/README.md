# 문제
[백준 1920번 - 수 찾기](https://www.acmicpc.net/problem/1920)

## 알고리즘 
- 이진탐색 <br>
-> 처음 접하는 개념이라 강의의 수도 코드 본 후 풀어 봄

# 문제 풀이
1. 데이터 배열 정렬 
2. 찾아야하는 수(타깃 데이터)의 갯수만큼 for문
3. start 값 <= end 값 까지 while
4. 중앙 인덱스 배정
5. 중앙 값 > 타깃 값 이면, end 인덱스 = 중간 인덱스 - 1
6. 중앙 값 < 타깃 값 이면, start 인덱스 = 중간 인덱스 + 1
7. 그 밖의 else는 중앙 값 = 타깃 값 을 뜻하므로, boolean변수 true 만들고 반복문 종료
8. boolean 변수에 따라 1, 0 중 출력

## 주의점
- 처음 `end` 를 `nums.length - 1` 말고 `m-1`을 줬더니, <br>
  ArrayIndexOutOfBounds 에러가 남

## 참고 강의
[Do it! 알고리즘 코딩테스트 with JAVA](https://www.inflearn.com/course/lecture?courseSlug=두잇-알고리즘-코딩테스트-자바&unitId=148354&tab=curriculum)

