package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Piece
{
    int x,y,dir;

    public Piece(int x, int y, int dir)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
public class Q17837 {
    static int N,K;
    static int [][] map;
    static Piece [] piece;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0}; //우 좌 상 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        piece = new Piece[K];

        for(int i = 0; i < N; ++i) // 0흰 1빨 2파
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < K; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken())-1;
            piece[i] = new Piece(x,y,dir);
        }
    }
}
