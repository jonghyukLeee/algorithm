package Etc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Piece2
{
    int loc;
    boolean isDone;
    boolean onShortcut;

    public Piece2(int loc)
    {
        this.loc = loc;
    }
}
public class Q17825 {
    static int max_val = Integer.MIN_VALUE;
    static int [] dice;
    static Piece2 [] piece;
    static int [] shortcut;
    static int [] perm;
    static boolean [][] visited;
    static boolean isValid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dice = new int[10];
        piece = new Piece2[4];
        shortcut = new int[42];

        // 지름길
        shortcut[10] = 13;
        shortcut[13] = 16;
        shortcut[16] = 19;
        shortcut[19] = 25;
        shortcut[20] = 22;
        shortcut[22] = 24;
        shortcut[24] = 25;
        shortcut[25] = 31;
        shortcut[30] = 28;
        shortcut[31] = 35;
        shortcut[35] = 40;
        shortcut[28] = 27;
        shortcut[27] = 26;
        shortcut[26] = 25;
        shortcut[40] = 41;


        for(int i = 0; i < 10; ++i)
        {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        perm = new int[10];
        perm(0);
        System.out.print(max_val);
    }
    static void perm(int depth)
    {
        if(depth > 9)
        {
            max_val = Math.max(max_val,play());
            return;
        }

        for(int i = 0; i < 4; ++i)
        {
            perm[depth] = i;
            perm(depth+1);
        }
    }
    static int play()
    {
        int total = 0;
        visited = new boolean[2][42];
        isValid = true;
        for(int i = 0; i < 4; ++i) piece[i] = new Piece2(0);

        for(int i = 0; i < 10; ++i)
        {
            total += move(perm[i],dice[i]);
            if(!isValid) return 0;
        }

        return total;
    }
    static int move(int num,int val)
    {
        if(piece[num].isDone) return 0;
        int map = piece[num].onShortcut ? 1 : 0;
        visited[map][piece[num].loc] = false;

        if(map > 0) // 지름길 위라면
        {
            for(int i = 0; i < val; ++i)
            {
                piece[num].loc = shortcut[piece[num].loc];
                if(piece[num].loc > 40) break;
            }
        }
        else // onMap
        {
            piece[num].loc += 2 * val;
            if(piece[num].loc % 10 == 0 && piece[num].loc < 40)
            {
                map++;
                piece[num].onShortcut = true;
            }
        }
        if(piece[num].loc > 40)
        {
            piece[num].isDone = true;
            return 0;
        }
        if(visited[map][piece[num].loc])
        {
            isValid = false;
            return 0;
        }
        else
        {
            visited[map][piece[num].loc] = true;
        }
        if(piece[num].loc == 31) return 30;
        return piece[num].loc;
    }

}
