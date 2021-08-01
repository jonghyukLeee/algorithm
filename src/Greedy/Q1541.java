package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1541 {
    static String exp;
    static ArrayList<Integer> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        al = new ArrayList<>();
        exp = br.readLine();
        StringTokenizer st;
        st = new StringTokenizer(exp,"-");

        while(st.hasMoreTokens())
        {
            String tmpStr = st.nextToken();

            if(tmpStr.contains("+"))
            {
                StringTokenizer tmpSt = new StringTokenizer(tmpStr,"+");
                int total = 0;
                while(tmpSt.hasMoreTokens())
                {
                    total += Integer.parseInt(tmpSt.nextToken());
                }
                al.add(total);
                continue;
            }
            al.add(Integer.parseInt(tmpStr));
        }

        int answer = al.get(0);
        for(int i = 1; i < al.size(); ++i)
        {
            answer -= al.get(i);
        }

        System.out.print(answer);
    }
}
