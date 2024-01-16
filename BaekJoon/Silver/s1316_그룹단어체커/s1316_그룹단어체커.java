package s1316_그룹단어체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// idea
// 1) 인접문자 제거 (abbbaac -> abac)
// 2) 중복문자가 들어가지 않는 set을 이용해 중복 문자 확인

public class s1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line_num = Integer.parseInt(br.readLine());
        String[] st_arr;
        Set<String> set;
        int count = 0;
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<line_num; i++){
            st_arr = br.readLine().split(""); // 한글자씩 arr에
            list.add(st_arr[0]);
            for(int j=1; j<st_arr.length; j++){ // 인접 문자열 제외하고 list에 넣기
                if(!st_arr[j].equals(st_arr[j-1])) list.add(st_arr[j]);
            }
            set = new HashSet<>(list);
            if(list.size() == set.size()) count++; // 중복 문자열 없으면, count
            list.clear();
        }
        br.close();
        System.out.println(count);
    }
}
