package Review_30days.week4.day23;

import java.util.ArrayList;
import java.util.List;


//못풀었음
public class Kakao_Q5 {
    static int max = 1;
    static List<List<Integer>> map;
    static boolean [] visited;
    static int [] INFO;
    public static void main(String[] args) {
        int [] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int [][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.print(solution(info,edges));
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

        visited = new boolean[info_size];

        dfs(0,0,0,new boolean[info_size]);
        answer = max;
        return answer;
    }
    static void dfs(int cur, int sheep, int wolf, boolean... visited)
    {

    }
}
