package Etc.pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Q1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return 1;
                else if(o1.length() < o2.length()) return -1;
                return o1.compareTo(o2);
            }
        });
        for(int i = 0; i < N; i++)
        {
            set.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for(String s : set)
        {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
