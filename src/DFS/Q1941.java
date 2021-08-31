package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Team
{
    String alpha,num;

    public Team(String alpha,String num)
    {
        this.alpha = alpha;
        this.num = num;
    }

}
public class Q1941 {
    static char [] map;
    static int [] move = {-1,-5,5,1};
    static boolean [] isVis;
    static ArrayList<Team> answer;
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
        comb(new Team("",""),0);
        int answerCnt = 0;
        for(Team t : answer)
        {
            if(isLinked(t)) answerCnt++;
        }
        System.out.print(answerCnt);
    }
    static void comb(Team tmp, int idx)
    {
        if(tmp.alpha.length() == 7)
        {
            Pattern pattern = Pattern.compile("[S]");
            Matcher matcher = pattern.matcher(tmp.alpha);
            int sCnt = 0;
            while(matcher.find()) sCnt++;
            if(sCnt > 3) answer.add(new Team(tmp.alpha,tmp.num));
            return;
        }
        if(idx == 25) return;

        comb(new Team(tmp.alpha+map[idx],tmp.num+idx+" "),idx+1);
        comb(new Team(tmp.alpha,tmp.num),idx+1);
    }
    static boolean isLinked(Team team)
    {
        boolean [] check = new boolean[25];
        isVis = new boolean[25];
        String [] numbers = team.num.split(" ");
        for(String s : numbers)
        {
            check[Integer.parseInt(s)] = true;
        }

        Queue<String> q = new LinkedList<>();
        q.add(numbers[0]);
        isVis[Integer.parseInt(numbers[0])] = true;

        int cnt = 0;
        while(!q.isEmpty())
        {
            String tmp = q.poll();
            int cur = Integer.parseInt(tmp);
            int end = cur % 5;
            cnt++;
            for(int i = 0; i < 4; ++i)
            {
                if(end == 4)
                {
                    if(i == 3) continue;
                }
                else if(end == 0)
                {
                    if(i == 0) continue;
                }
                int m = cur + move[i];
                if(!isValid(m) || isVis[m] || !check[m]) continue;
                isVis[m] = true;
                q.add(m+"");
            }
        }
        return cnt == 7;
    }
    static boolean isValid(int x)
    {
        return x >= 0 && x < 25;
    }
}
