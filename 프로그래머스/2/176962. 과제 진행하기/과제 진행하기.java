import java.util.*;
class Task {
    String sub;
    int start;
    int req;
    
    public Task(String sub, int start, int req) {
        this.sub = sub;
        this.start = start;
        this.req = req;
    }
}
class Solution {
    static Stack<Task> remainingTask;
    static Queue<String> result;
    public String[] solution(String[][] plans) {
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.start - o2.start;
            }
        });
        
        for (String[] plan: plans) {
            String sub = plan[0];
            int start = stringToMinute(plan[1]);
            int req = Integer.parseInt(plan[2]);
            
            pq.add(new Task(sub, start, req));
        }
        
        remainingTask = new Stack<>();
        result = new LinkedList<>();
        
        while (!pq.isEmpty()) {
            Task cur = pq.poll();
            
            if (pq.isEmpty()) {
                result.add(cur.sub);
                break;
            } else {
                int nextStartTime = pq.peek().start;
                int givenTime = nextStartTime - cur.start;
                
                // 주어진 시간에 현재 과제를 끝낼 수 없는 경우
                if (cur.req > givenTime) {
                    remainingTask.push(new Task(cur.sub, cur.start, cur.req - givenTime));
                } else {
                    result.add(cur.sub);
                    work(givenTime - cur.req);
                }
            }
        }
        
        while (!remainingTask.isEmpty()) {
            result.add(remainingTask.pop().sub);
        }
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.poll();
        }
        return answer;
    }
    
    static int stringToMinute(String str) {
        String[] split = str.split(":");
        
        return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
    }
    
    static void work(int givenTime) {
        while (givenTime > 0 && !remainingTask.isEmpty()) {
            Task next = remainingTask.pop();
            if (givenTime >= next.req) {
                result.add(next.sub);
                givenTime -= next.req;
            } else {
                remainingTask.push(new Task(next.sub, next.start, next.req - givenTime));
                givenTime = 0;
            }
        }
    }
}