## 문제
[프로그래머스 - 짝지어 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12973) <br>
-> 알고리즘 : 스택

## 문제 풀이
- 앞의 문자와 같은 문자인지 확인하기 위해 stack 을 이용 <br>
  -> (stack 의 top) = (앞의 문자)

## 코드 개선
- 전
```java
if(stack.isEmpty()) 
    stack.push(c);
else {
    if(stack.peek() == c) 
        stack.pop();
    else stack.push(c);
}
```
- 후
```java
if(!stack.isEmpty() && stack.peek() == c) 
    stack.pop();
else 
    stack.push(c);
```

-> 스택이 비어있지 않고, 스택의 마지막 문자와 현재 문자가 동일할 경우 만 pop <br>
   그렇지 않으면 push 로, 두 if 절을 합치면서 코드의 가독성을 높임
