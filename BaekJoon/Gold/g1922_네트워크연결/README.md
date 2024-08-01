## 문제

[백준 1922번 - 네트워크 연결](https://www.acmicpc.net/problem/1922) <br>
-> 알고리즘 : MST(최소 신장 트리) 중 크루스칼 알고리즘 (그래프)

## 문제 풀이

- 단순 크루스칼 알고리즘 사용 ([정리글 참조](https://velog.io/@imeline/%EA%B7%B8%EB%9E%98%ED%94%84))

## 알게 된 것

1. 이차원 배열 정렬 <br>
   `Arrays.sort(arr, Comparator.comparingInt(a -> a[2]));` <br>
   -> index 2 배열 기준으로 오름차순