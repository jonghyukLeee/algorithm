package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q1941 {
    static char [] map;
    static ArrayList<String> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[25];
        int idxCnt = 0;
        for(int i = 0; i < 5; ++i)
        {
            String tmp = br.readLine();
            for(int j = 0; j < 5; ++j)
            {
                map[idxCnt++] = tmp.charAt(j);
            }
        }
        answer = new ArrayList<>();
        comb("",0);

        for(String str : answer)
        {

        }
    }
    static void comb(String str, int idx)
    {
        if(str.length() == 7)
        {
            Pattern pattern = Pattern.compile("[S]");
            Matcher matcher = pattern.matcher(str);
            int sCnt = 0;
            while(matcher.find()) sCnt++;
            if(sCnt > 3) answer.add(str);
            return;
        }
        if(idx == 25) return;
        comb(str+map[idx],idx+1);
        comb(str,idx+1);
    }
}
