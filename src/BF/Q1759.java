package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1759 {
    static int L,C;
    static PriorityQueue<String> answer;
    static List<Character> v; // 모음
    static List<Character> c; // 자음
    static int v_size, c_size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer = new PriorityQueue<>();
        v = new ArrayList<>();
        c = new ArrayList<>();

        String [] tmp_arr = br.readLine().split(" ");
        for(int i = 0; i < C; ++i)
        {
            char ch = tmp_arr[i].charAt(0);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') v.add(ch);
            else c.add(ch);
        }

        v_size = v.size();
        c_size = c.size();

        Collections.sort(v);
        Collections.sort(c);

        for(int i = 0 ; i < v_size; ++i)
        {
            char next = v.get(i);
            find(next+"",1,1,0,next,i+1,0);
        }
        for(int i = 0; i < c_size; ++i)
        {
            char next = c.get(i);
            find(next+"",1,0,1,next,0,i+1);
        }

        while(!answer.isEmpty()) System.out.println(answer.poll());

    }
    static void find(String str,int len,int v_cnt, int c_cnt,char last,int v_idx,int c_idx)
    {
        if(len == L)
        {
            if(c_cnt > 1 && v_cnt > 0) answer.add(str);
            return;
        }
        if(v_idx < v_size)
        {
            for(int i = v_idx; i < v_size; ++i)
            {
                char next_v = v.get(i);

                if(last < next_v) find(str+next_v,len+1,v_cnt+1,c_cnt,next_v,v_idx+1,c_idx);
            }
        }
        if(c_idx < c_size)
        {
            for(int i = c_idx; i < c_size; ++i)
            {
                char next_c = c.get(i);

                if(last < next_c) find(str+next_c,len+1,v_cnt,c_cnt+1,next_c,v_idx,c_idx+1);
            }
        }
    }
}
