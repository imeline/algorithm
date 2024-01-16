package s11478_서로다른부분문자열의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// arrayList 사용 시 시간초과 -> Set 이용하니 해결
// if(arrayList.contains()를 이용해 중복확인을 하는게, 생각보다 시간이 많이 걸리는듯
public class s11478_서로다른부분문자열의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Set<String> sub_string = new HashSet<>();

        for(int i = 0; i<input.length(); i++) {
            for(int j = i+1; j<=input.length(); j++) {
                sub_string.add(input.substring(i, j));
            }
        }
        System.out.println(sub_string.size());
    }
}
