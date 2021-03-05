package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2751 {
    static int quickSort(int [] arr,int left, int right)
    {
        int pv = (left+right)/2;
        while(left <= right)
        {
            while(arr[left] < arr[pv]) left++;
            while(arr[right] > arr[pv]) right++;

            if(left <= right)
            {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        return left;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int [] arr = new int[t];
        for(int i = 0; i < t; ++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(arr,0,arr.length-1);
    }
}
