import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s2941_크로아티아알파벳 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        bf.close();

        String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(String st : croatia) {
            if(input.contains(st)) {
                input = input.replace(st, ".");
            }
        }

        System.out.println(input.length());

    }
}

// 더 좋은 코드
// for(String st : croatia) {
//     input = input.replace(st, "A");
// }