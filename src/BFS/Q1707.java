package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Line
{
    int start, end;

    public Line(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}
public class Q1707 {
    static ArrayList<Line> vertex;
    static final int NONE = 0;
    static final int WHITE = 1;
    static final int BLACK = 2;
    static String answer;
    static int [] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int endCnt = 0; endCnt < t; ++endCnt)
        {
            answer = "YES";
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            colors = new int[v+1];
            vertex = new ArrayList<>();

            for(int i = 1; i < e+1; ++i)
            {
                st = new StringTokenizer(br.readLine());
                int fst = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());

                vertex.add(new Line(fst,sec));
            }

            vertex.sort(new Comparator<Line>() {
                @Override
                public int compare(Line o1, Line o2) {
                    return o1.start - o2.start;
                }
            });

            loop : for(Line vert : vertex)
            {
                int start = vert.start;
                int end = vert.end;

                switch(colors[start])
                {
                    case NONE :
                    {
                        if(colors[end] == NONE)
                        {
                            colors[start] = WHITE;
                            colors[end] = BLACK;
                            break;
                        }
                        else
                        {
                            colors[start] = getAnotherColor(colors[end]);
                        }
                        break;
                    }
                    default :
                    {
                        if(colors[end] == NONE)
                        {
                            colors[end] = getAnotherColor(colors[start]);
                            break;
                        }
                        else
                        {
                            if(colors[start] == colors[end])
                            {
                                answer = "NO";
                                break loop;
                            }
                        }
                        break;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
    static int getAnotherColor(int v)
    {
        return colors[v] == WHITE ? BLACK : WHITE;
    }
}
