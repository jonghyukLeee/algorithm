package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Age
{
    int x,y,age;

    public Age(int x, int y, int age)
    {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}
public class Q16235 {
    static int N,M,K;
    static int [][] map;
    static List<Integer> food;
    static PriorityQueue<Age> trees;
    static int [] dx = {-1,-1,-1,0,1,1,1,0};
    static int [] dy = {-1,0,1,1,1,0,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        food = new ArrayList<>();
        trees = new PriorityQueue<>(new Comparator<Age>()
        {
            @Override
            public int compare(Age o1, Age o2)
            {
                return o1.age - o2.age;
            }
        });


        for(int i = 1; i <= N; ++i) // 초깃값 5
        {
            Arrays.fill(map[i],5);
        }

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
            {
                food.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            trees.add(new Age(x,y,age));
        }

        while(K-- > 0)
        {
            if(trees.isEmpty()) break;
            newYear();
        }
        System.out.print(trees.size());
    }
    static void newYear()
    {
        List<Age> tmp_trees = new ArrayList<>();
        List<Age> dead_trees = new ArrayList<>();

        while(!trees.isEmpty()) tmp_trees.add(trees.poll());

        for(Age tree : tmp_trees) // 봄
        {
            if(tree.age <= map[tree.x][tree.y])
            {
                map[tree.x][tree.y] -= tree.age;
                trees.add(new Age(tree.x,tree.y,tree.age+1));
            }
            else dead_trees.add(tree);
        }


        for(Age tree : dead_trees) // 여름
        {
            map[tree.x][tree.y] += tree.age / 2;
        }

        List<Age> tmp = new ArrayList<>();
        for(Age tree : trees) // 가을
        {
            if((tree.age % 5) == 0)
            {
                for(int idx = 0; idx < 8; ++idx)
                {
                    int mx = tree.x + dx[idx];
                    int my = tree.y + dy[idx];

                    if(!isValid(mx,my)) continue;
                    tmp.add(new Age(mx,my,1));
                }
            }
        }
        if(tmp.size() > 0)
        {
            trees.addAll(tmp);
        }

        int tmp_idx = 0;
        for(int i = 1; i <= N; ++i)
        {
            for(int j = 1; j <= N; ++j)
            {
                map[i][j] += food.get(tmp_idx++);
            }
        }

    }
    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x <= N && y <= N;
    }
}
