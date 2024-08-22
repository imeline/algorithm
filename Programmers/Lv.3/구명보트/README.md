## 문제
[프로그래머스 - 구명보트](https://school.programmers.co.kr/learn/courses/30/lessons/42885) <br>
: 알고리즘 - 탐욕법(Greedy)

## 문제 풀이
- 가장 무거운 사람을 먼저 태우는 식으로 해서, 가장 무거운 사람과 가장 가벼운 사람의 합이 limit 를 넘는다면 <br>
가장 무거운 사람은 다른 누구와도 보트를 같이 탈 수 없는 것이기에 혼자 타게 함
- 위의 과정을 반복

## 코드 개선

1.
```java
int min = 0, boat = 0;
for(int max = people.length - 1; min <= max; max--)
```
⬇️

```java
int min = 0, max = people.length - 1, boat = 0;
for(; min <= max; max--)
```

- 좀 더 max에 대한 정의가 명확하게 보이므로, for에서 선언하지 않고 min 과 같이 먼저 선언함
<br>

---

2.
```java
if(people[min] + people[max] <= limit) min++;
boat++; 
}
return boat;
```
⬇️

```java
if (people[min] + people[max] <= limit) min++;
}
return people.length - i;
```

- 가벼운 사람이 ++ 된 경우는 가벼운 사람과 무거운 사람이 같이 탄 경우이므로, <br>
2개의 보트를 쓸 경우를 1개로 줄인 것이므로, `전체 사람 수(다 1명씩 탄 경우) - 같이 탄 경우` 를 하면 전체 사용 보트 수
<br>
-> 이렇게 코드를 개선하면 변수도 더 사용 안하고 연산도 줄지만, 처음 코드가 가독성이 더 낫다고 판단하여 반영하진 않음 
