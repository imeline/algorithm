# idea
1. 확인하고픈 문자를 하나씩 배열 요소로 넣기
2. for문으로 배열 요소 하나씩 `{문자열}.contains()`로 문자열에 있는지 확인 
3. 있다고 확인되면 replace로 .으로 변경
4. `{문자열}.length`로 문자 갯수 확인

# 더 좋은 코드
```java
for(String st : croatia) {
     input = input.replace(st, "A");
 }
```
`contains()`로 확인하는 과정 없이, 
바로 `replace()`로 바꿔도 됨 
-> replace 가 확인과 변경 작업을 동시에 해주기 때문