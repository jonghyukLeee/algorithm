package Review_30days.week4.day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node
{
    int num,sheep,wolf;

    public Node(int num, int sheep, int wolf)
    {
        this.num = num;
        this.sheep = sheep;
        this.wolf = wolf;
    }
}
public class Kakao_Q5 {
    static int max = 1;
    static List<List<Integer>> map;
    static boolean [] empty;
    static int [] visited;
    static int [] INFO;
    public static void main(String[] args) {
        int [] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int [][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
    }
    static int solution(int[] info, int[][] edges) {
        int answer = 0;
        INFO = info;
        map = new ArrayList<>();
        int info_size = info.length;
        for(int i = 0; i < info_size; ++i) map.add(new ArrayList<>());

        for(int [] i : edges)
        {
            int fst = i[0];
            int sec = i[1];

            map.get(fst).add(sec);
            map.get(sec).add(fst);
        }

        empty = new boolean[info_size];
        visited = new int[info_size]; // 양/늑대
        //0번노드 초기화
        empty[0] = true;
        visited[0] = 1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,1,0));

        while(!q.isEmpty())
        {
            Node cur = q.poll();
            int sheep = cur.sheep;
            int wolf = cur.wolf;
            if(sheep > max) max = sheep;

            for(int next : map.get(cur.num))
            {
                if(!empty[next]) // 첫 방문일경우
                {
                    if(INFO[next] == 0) sheep++;
                    else wolf++;
                    if(sheep - wolf <= 0) continue; // 늑대와 같거나 작아지면 다른노드 탐색
                }
                int diff = sheep - wolf;
                if(visited[next] < diff) // 보다 많은 양을 데리고 왔는지 체크
                {
                    visited[next]= diff;
                    empty[next] = true;
                    q.add(new Node(next,sheep,wolf));
                }
            }
        }
        return answer;
    }
}
