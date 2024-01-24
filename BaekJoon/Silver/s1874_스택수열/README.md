# 문제 못 푼 이유
- 문제 자체를 이해 못함
## 문제
- 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.<br>

## 해석  
- 수열 의 수가 8이면, 1~8까지 넣어서 8을 pop <br>
- 선입후출인 stack의 구조에 따라, 큰 수가 먼저 pop 되야 작은 수 pop 가능<br>
- 큰 수가 아직 stack에 있는데, 작은 수를 요구하면 NO를 출력

## 참고 사이트
[코드 참조 사이트](https://st-lab.tistory.com/182)

# idea
- stack 의 구조로, 더 큰 수가 아직 stack에 있는데, 작은 수만 pop 할 수 없다는 것을 주의
- `num` : 1~n의 수, `su` : pop 해야하는 수열의 수

1. 수열 수의 갯수, n을 for 으로 돌림 <br>
  ➡️ 수열 수 하나씩 기준으로 push와 pop을 수행
2. `num <= su` 조건이면 stack에 su까지 push<br>
  ➡️ 8을 pop 하기 위해 1~8을 stack에 넣음
3. else if 절로, `num > su`이면서 `stack.peek() != su`의 경우 <br>
  stack의 젤 위에 있는 수 (큰 수) 가 아니라, 그 아래에 있는 수 (작은 수) 의 pop을 요구하는 것이므로 <br>
  stack 구조 상 불가능, NO를 출력 및 프로그램 종료
4. 위의 두 if 절에서, '젤 위의 수 = 요구하는 수열의 수' 이도록 맞춰 놨으므로, pop <br>
  ➡️ 위에서 push 해서 젤 위에 su가 오도록 하거나, 스택의 구조를 어기는 경우를 제외시켰음

# 다른 코드
- [do it 강의](https://www.inflearn.com/course/두잇-알고리즘-코딩테스트-자바/dashboard) 참고
- `stack.pop();` 와 `sb.append("-\n");`를 두번 하는 구조이므로, 그 코드를 줄일 수 있는 다른 사이트를 참조해, 이 코드는 제출하지 않음


```java
for(int i=0; i<n; i++){  // while(n-- > 0) 으로 대체 가능
            su = Integer.parseInt(br.readLine());
            if(num <= su) {
                while (num <= su) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }

            else {
                int pop_n = stack.pop();
                if(pop_n > su) {
                    System.out.println("NO");
                    return;
                }
                else {
                    sb.append("-\n");
                }
            }

        }
```