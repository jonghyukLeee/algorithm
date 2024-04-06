import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> map;
    static int removeNode;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        for(int i = 0; i < N; i++) map.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int rootNode = 0;
        for(int i = 0; i < N; i++)
        {
            int next = Integer.parseInt(st.nextToken());
            //루트노드
            if(next < 0)
            {
                rootNode = i;
                continue;
            }
            map.get(next).add(i);
        }

        removeNode = Integer.parseInt(br.readLine());
        if(rootNode != removeNode)
        {
            remove(rootNode);
            if(map.get(rootNode).isEmpty()) answer = 1;
            else count(rootNode);
        }
        System.out.print(answer);
    }
    static void remove(int node)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty())
        {
            int n = q.poll();
            List<Integer> parent = map.get(n);
            int size = parent.size();
            for(int i = 0; i < size; i++)
            {
                int next = parent.get(i);
                if(next == removeNode)
                {
                    parent.remove(i);
                    break;
                }
                q.add(next);
            }
        }
    }
    static void count(int node)
    {
        for(int next : map.get(node))
        {
            if(map.get(next).isEmpty()) answer++;
            else count(next);
        }
    }
}
