# idea
1. 인접문자 제거 (abbbaac -> abac)
2. 중복문자가 들어가지 않는 set을 이용해 중복 문자 확인

# 알게 된 거
1. set 은 add 시, 같은 요소가 먼저 들어 있을 경우 추가되지 않고 넘어감
2. 한글자씩 arr에 넣으려면, `arr = {문자열}.split("")`
3. `Set<String> set = new HashSet<>(list);` 로 list를 set 에 넣고,
`list.size() == set.size())` 처럼 비교하면,
list 에 중복 요소 있는지 확인 가능
