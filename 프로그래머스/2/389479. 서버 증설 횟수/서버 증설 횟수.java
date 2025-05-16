import java.util.*;

class Server {
    int time, count;
    
    public Server(int time, int count) {
        this.time = time;
        this.count = count;
    }
}
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int serverCount = 0;
        
        Queue<Server> q = new LinkedList<>();
        
        for (int i = 0;i < 24; i++) {
            if (!q.isEmpty() && (q.peek().time + k == i)) {
                Server server = q.poll();
                serverCount -= server.count;
            }
            int playerCount = players[i];
            int n = playerCount / m;
            
            // 증설이 필요한 경우
            if (n > serverCount) {
                int diff = n - serverCount;
                serverCount += diff;
                q.add(new Server(i, diff));
                answer += diff;
            }
        }
        return answer;
    }
}