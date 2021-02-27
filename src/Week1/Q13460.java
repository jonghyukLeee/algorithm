package Week1;

import java.io.*;
import java.time.LocalDate;
import java.util.StringTokenizer;
class Location
{
    int x,y;
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q13460 {
    static Location loc [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        char [][] board;
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int ins_cnt = 0;
        board = new char[y][x];
        loc = new Location[3];
        for(int i = 0; i < y; ++i)
        {
            String s = br.readLine();
            for(int j = 0; j < x; ++j)
            {
                board[i][j] = s.charAt(j);
                if(ins_cnt > 2) continue;
                switch (board[i][j])
                {
                    case 'B' :
                    {
                        loc[0] = new Location(i,j);
                        ins_cnt++;
                        break;
                    }
                    case 'R' :
                    {
                        loc[1] = new Location(i,j);
                        ins_cnt++;
                        break;
                    }
                    case '0' :
                    {
                        loc[2] = new Location(i,j);
                        ins_cnt++;
                        break;
                    }
                    default: break;
                }
            }
        } //end

    }
}
