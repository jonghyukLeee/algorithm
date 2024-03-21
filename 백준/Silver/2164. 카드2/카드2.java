import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        int n = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        while(cnt <= n)
        {
            q.add(cnt++);
        }

        while(q.size() != 1)
        {
           q.poll();
           q.add(q.poll());
        }
        System.out.print(q.peek());
        br.close();
    }
}
