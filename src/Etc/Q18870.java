package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q18870 {
    static int [] map,cMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        map = new int[n];
        cMap = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; ++i)
        {
            map[i] = Integer.parseInt(st.nextToken());
        }
        cMap = map.clone();
        Arrays.sort(cMap);

        int idx = 0;
        for(int i = 0; i < cMap.length; ++i)
        {
            if(!hm.containsKey(cMap[i])) hm.put(cMap[i],idx++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : map)
        {
            sb.append(hm.get(i)).append(" ");
        }
        System.out.print(sb.toString());

    }

}
