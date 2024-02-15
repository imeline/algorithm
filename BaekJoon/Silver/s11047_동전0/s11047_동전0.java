package BaekJoon.Silver.s11047_동전0;

import java.util.Scanner;

public class s11047_동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tarket = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (tarket >= coins[i]) {
                cnt += tarket / coins[i];
                tarket %= coins[i];
            }
        }
        System.out.println(cnt);
    }
}
