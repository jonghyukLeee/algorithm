package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6549 {
    static int [] map;
    static int [] tree;
    static int N;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            map = new int[N + 1];

            for(int i = 1; i <= N; ++i) map[i] = Integer.parseInt(st.nextToken());

            tree = new int[N * 4];
            setTree(1,N,1);

            answer = Long.MIN_VALUE;
            getMaxArea(1,N);

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
    static int setTree(int start, int end, int node)
    {
        if(start == end) return tree[node] = start; // 리프노드

        int mid = (start + end) / 2;
        int left = setTree(start,mid,node * 2);
        int right = setTree(mid + 1,end,(node * 2) + 1);

        return tree[node] = map[left] < map[right] ? left : right;
    }

    static int getMinIdx(int start,int end,int left, int right,int node)
    {
        if((left > end) || (right < start)) return -1;
        else if((start >= left) && (end <= right)) return tree[node];

        int mid = (start + end) / 2;
        int leftMin = getMinIdx(start,mid,left,right,node * 2);
        int rightMin = getMinIdx(mid+1,end,left,right,(node * 2) + 1);

        if(leftMin < 0) return rightMin;
        else if(rightMin < 0) return leftMin;
        return map[leftMin] < map[rightMin] ? leftMin : rightMin;
    }

    static void getMaxArea(int start, int end)
    {
        if(start > end) return;
        int idx = getMinIdx(1,N,start,end,1);
        answer = Math.max(answer,(long)map[idx] * ((end - start) + 1));

        getMaxArea(start,idx-1);
        getMaxArea(idx+1,end);
    }
}
