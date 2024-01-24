package s1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class s1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int su;  // 수열 수
        StringBuilder sb = new StringBuilder();  // +,- 쓰기
        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for(int i=0; i<n; i++){  // while(n-- > 0) 으로 대체 가능
            su = Integer.parseInt(br.readLine());
            if(num <= su) { // 밑의 push에서 num++ 로 인해, push를 8까지해도 num은 9가 되버리므로, < 가 아니라 <=
                while (num <= su) { // 자연수 가 수열 수보다 작을 경우에 같을 때까지, stack에 push
                    stack.push(num++);
                    sb.append("+\n");
                }
            }
            // 여기는 위의 if 절의 else 이므로 'num > su' 이므로, su가 이미 stack에 있다는 뜻
            // 근데 stack의 젤 위의 수가 su 가 아니면, 지금 찾는 su 위에 su 보다 큰 수의 num이 들어있다는 것
            // 그 num을 pop 해야, 지금 su를 pop 할 수 있는데, 지금 su를 위해 num을 pop 해버리면
            // 내가 원하는 수열과 다른 수열이 나열되고, 뒤에 num을 찾아 pop해야 할 때 그 num이 없음
            // 그래서 NO 를 출력
            // 백준 문제의 '1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다' 의 부분에서
            // 수열에 1~n 까지의 수가 순서만 섞였을 뿐 다 있다는 것 가정하여 문제를 품
            // -> 지금 pop 되는 su보다 큰 num이 전에 pop 된 적 없다면, 무조건 뒤에 pop을 요구한다는 것(새로운 su로 나온다)을 전제
            else if(stack.peek() != su) {
                System.out.println("NO");
                return;
            }
            // '자연수 = 수열 수' (-> if절 후의 경우도 포함) 경우이거나,
            // '자연수 > 수열 수' (== stack에 이미 수열 수 들어가 있음) 일때
            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}