package Review_30days.week3.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Emo
{
    int chat,clip,time;

    public Emo(int chat,int clip, int time)
    {
        this.chat = chat;
        this.clip = clip;
        this.time = time;
    }
}
public class Q14226 {
    static int S;
    static Queue<Emo> q;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        q = new LinkedList<>();
        visited = new boolean[2000][2000];
        q.add(new Emo(1,0,0));
        visited[1][0] = true;
        int answer = 0;
        while(!q.isEmpty())
        {
            Emo cur = q.poll();
            if(cur.chat < 1) continue;
            if(cur.chat == S)
            {
                answer = cur.time;
                break;
            }

            for(int i = 0; i < 3; ++i)
            {
                Emo tmp = run(i,cur);
                if(tmp.chat + tmp.clip >= 2000) continue;
                if(!visited[tmp.chat][tmp.clip])
                {
                    visited[tmp.chat][tmp.clip] = true;
                    q.add(tmp);
                }
            }
        }
        System.out.print(answer);
    }
    static Emo run(int flag, Emo cur)
    {
        if(flag == 0) return new Emo(cur.chat,cur.chat,cur.time+1);
        else if(flag == 1) return new Emo(cur.chat+cur.clip,cur.clip,cur.time+1);
        else return new Emo(cur.chat-1,cur.clip,cur.time+1);
    }
}
