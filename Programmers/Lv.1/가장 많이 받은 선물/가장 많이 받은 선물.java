public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap<>(); // 이름, 인덱스
        int f_len = friends.length;
        int[][] gift = new int[f_len][f_len + 1]; // 주고받은 선물 기록을 나타낼 표 
        // +1 은 선물 지수를 계산할 곳
        
        for(int i = 0; i < f_len; i++) {
            map.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++) {
            String[] who = gifts[i].split(" ");
            int a = map.get(who[0]); // 선물 준 애의 인덱스
            int b = map.get(who[1]); // 선물 받은 애의 인덱스
            
            gift[a][b]++; // 주고받은 선물 기록
            gift[a][f_len]++; // 선물 지수 + 1
            gift[b][f_len]--; // 선물 지수 - 1
        }
        
        int max = 0;
        for (int i = 0; i < f_len; i++) {
           int cnt = 0;
           for (int j = 0; j < f_len; j++) {
               if(i == j) continue;
               if (gift[i][j] > gift[j][i]) cnt++;
               else if (gift[i][j] == gift[j][i] && gift[i][f_len] > gift[j][f_len]) cnt++; 
           }
           max = Math.max(cnt, max);
        }
        return max;
    }
