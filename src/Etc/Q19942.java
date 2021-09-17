package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q19942 {
    static int [][] map;
    static int [] values;
    static int min = Integer.MAX_VALUE;
    static HashMap<Integer,ArrayList<String>> hm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        values = new int[4];
        int valuesIdx = 0;
        while(st.hasMoreTokens())
        {
            values[valuesIdx++] = Integer.parseInt(st.nextToken());
        }

        map = new int[n+1][5];
        hm = new HashMap<>();
        for(int i = 1; i <= n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb;
        for(int i = 1; i < 1 << n; ++i)
        {
            sb = new StringBuilder();
            for(int j = 0; j < n; ++j)
            {
                if((i & 1 << j) > 0)
                {
                    sb.append(j+1+" ");
                }
            }
            sum(sb.toString());
        }
        if(hm.isEmpty())
        {
            System.out.print("-1");
            return;
        }
        for(Integer key : hm.keySet())
        {
            if(key == min)
            {
                ArrayList<String> tmpAl = hm.get(key);
                Collections.sort(tmpAl);
                System.out.printf("%d\n%s",key,tmpAl.get(0));
                break;
            }
        }
    }
    static void sum(String selections)
    {
        StringTokenizer st = new StringTokenizer(selections);
        int [] curVal = new int[5];
        int idx = 0;
        while(st.hasMoreTokens())
        {
            int cur = Integer.parseInt(st.nextToken());
            idx = 0;
            for(int v : map[cur])
            {
                curVal[idx++] += v;
            }
        }
        int price = isOK(curVal);
        if(price == -1) return;
        hm.putIfAbsent(price,new ArrayList<>());
        ArrayList<String> tmp = hm.get(price);
        tmp.add(selections);
        hm.put(price,tmp);
        if(price < min) min = price;
    }
    static int isOK(int [] getArr)
    {
        for(int i = 0; i < values.length; ++i)
        {
            if(getArr[i] < values[i]) return -1;
        }
        return getArr[4];
    }
}
