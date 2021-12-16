package Basic.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2529 {
    static boolean [] visited;
    static char [] form;
    static int N;
    static List<String> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        form = br.readLine().replaceAll(" ","").toCharArray();
        res = new ArrayList<>();
        //max

        visited = new boolean[10];
        for(int i = 0; i < 10; ++i)
        {
            visited[i] = true;
            getNum(i+"",1,0,i);
            visited[i] = false;
        }
        Collections.sort(res);
        System.out.printf("%s\n%s",res.get(res.size()-1),res.get(0));
    }
    static void getNum(String str,int len, int idx,int before)
    {
        if(len == N+1)
        {
            res.add(str);
            return;
        }

        for(int i = 0; i < 10; ++i)
        {
            if(!visited[i] && isValid(before,i,form[idx]))
            {
                visited[i] = true;
                getNum(str+i,len+1,idx+1,i);
                visited[i] = false;
            }
        }
    }
    static boolean isValid(int x, int y, char c)
    {
        if(c == '>')
        {
            return x > y;
        }
        else return x < y;
    }
}
