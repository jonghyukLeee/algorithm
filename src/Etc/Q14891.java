package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14891 {
    static HashMap<Integer,Integer> command;
    static List<Boolean> [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp_str;
        map = new LinkedList[5];
        for(int i = 0; i < 5; ++i) map[i] = new LinkedList<>();

        boolean tmp_bool;
        for(int i = 1; i < 5; ++i)
        {
            tmp_str = br.readLine();

            for(int j = 0; j < 8; ++j)
            {
                tmp_bool = tmp_str.charAt(j)-'0' > 0;
                map[i].add(tmp_bool);
            }
        }

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int num,dir;

        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());
            command = new HashMap<>();
            command.put(num,dir);
            check(num,dir);
            for(int key : command.keySet())
            {
                rotate(key,command.get(key));
            }
        }

        int tmp_num = 1;
        int res = 0;
        for(int i = 1; i < 5; ++i)
        {
            if(map[i].get(0)) res+= tmp_num;
            tmp_num *= 2;
        }

        System.out.print(res);
    }
    static void check(int num, int dir)
    {
        if(num-1 > 0 && !command.containsKey(num-1)) // 왼쪽
        {
            if(map[num-1].get(2) != map[num].get(6))
            {
                command.put(num-1,dir*-1);
                check(num-1,dir*-1);
            }
        }
        if(num+1 < 5 && !command.containsKey(num+1)) // 오른쪽
        {
            if(map[num+1].get(6) != map[num].get(2))
            {
                command.put(num+1,dir*-1);
                check(num+1,dir*-1);
            }
        }
    }
    static void rotate(int num, int dir)
    {
        if(dir == 1) map[num].add(0,map[num].remove(7));

        else map[num].add(map[num].remove(0));
    }
}
