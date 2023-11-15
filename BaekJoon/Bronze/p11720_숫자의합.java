import java.util.Scanner;

public class p11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String st = sc.next();
        char[] cNum = st.toCharArray();
        long sum = 0;
        for(int i=0; i<num; i++){
            sum += cNum[i] -'0';
        }
        System.out.println(sum);
    }
}