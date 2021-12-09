package First.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2750 {
    static int [] bubble(int [] arr)
    {
        int tmp = 0;
        for(int i = 0; i < arr.length; ++i)
        {
            for(int j = i+1; j < arr.length; ++j)
            {
                if(i == j) continue;
                if(arr[i] > arr[j])
                {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int [] arr = new int[t];
        for(int i = 0; i < t; ++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i : bubble(arr))
        {
            System.out.println(i);
        }
    }
}
