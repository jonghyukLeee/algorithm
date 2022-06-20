package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Town
{
    int next,weight;

    public Town(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}
public class Q1238 {
    static int N,M,X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<Town>> list,reverseList;
        list = new ArrayList<>();
        reverseList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Town(end,weight));
            reverseList.get(end).add(new Town(start,weight));
        }

        int [] go = search(list);
        int [] back = search(reverseList);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, go[i] + back[i]);
        }

        System.out.print(answer);
    }
    //다익
    static int [] search(List<List<Town>> list) {
        Queue<Town> pq = new PriorityQueue<>(new Comparator<Town>() {
            @Override
            public int compare(Town t1, Town t2) {
                return t1.weight - t2.weight;
            }
        });
        int [] arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[X] = 0;
        boolean [] isVisited = new boolean[N + 1];
        pq.add(new Town(X,0));
        while (!pq.isEmpty()) {
            Town cur = pq.poll();
            if(!isVisited[cur.next]) {
                isVisited[cur.next] = true;

                for (Town town : list.get(cur.next)) {
                    if(!isVisited[town.next] && (arr[town.next] > arr[cur.next] + town.weight)) {
                        arr[town.next] = arr[cur.next] + town.weight;
                        pq.add(new Town(town.next,arr[town.next]));
                    }
                }
            }
        }
        return arr;
    }
}
