public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int cnt = 0; 
        for(int i = 1; i < words.length; i++) {
            if( !set.add(words[i]) || 
                  words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0) ) {
                cnt = i;
                break;
            }
        }
        if(cnt == 0) return new int[] {0,0};
        return new int[] { cnt % n + 1, cnt / n + 1};
}
