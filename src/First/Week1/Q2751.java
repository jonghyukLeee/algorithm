package First.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2751 {
    static void quickSort(int [] arr,int left, int right)
    {
        for(int i : arr)
        {
            System.out.printf("%d ",i);
        }
        System.out.println();
        int part = partition(arr,left,right);
        if(left < part-1)
        {
            quickSort(arr,left,part-1);
        }
        if(part < right)
        {
            quickSort(arr,part,right);
        }
    }
    static int partition(int [] arr, int left, int right)
    {
        int pv = arr[(left+right)/2];
        while(left <= right)
        {
            while(arr[left]< pv) left++;
            while(arr[right] > pv) right--;
            if(left <= right)
            {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
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
        quickSort(arr,0,t-1);
        for(int i : arr)
        {
            System.out.printf("%d ",i);
        }
    }
}
