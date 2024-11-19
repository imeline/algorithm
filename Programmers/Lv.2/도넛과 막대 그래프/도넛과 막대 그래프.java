public int[] solution(int[][] edges) {
        HashMap<Integer, Integer> out = new HashMap<>();
        HashMap<Integer, Integer> in = new HashMap<>();
        
        for(int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], out.getOrDefault(edge[1], 0) + 1);
        }
        
        int[] answer = new int[4];
        
        for(int node : out.keySet()) {
            if(out.get(node) >= 2) {
                if(!in.containsKey(node)) answer[0] = node;
                else answer[3]++;
            }
        }
        
        for(int node : in.keySet()) {
            if(!out.containsKey(node)) answer[2]++;
        }
        
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
}
