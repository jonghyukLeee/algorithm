package BF;

public class Q4673 {
    static boolean [] notSelfNum;
    public static void main(String[] args) {
        notSelfNum = new boolean[10001];

        for(int i = 1; i <= 10000; i++)
        {
            int res = getNum(i);
            if(res <= 10000) notSelfNum[res] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++)
        {
            if(!notSelfNum[i]) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    static int getNum(int n)
    {
        int res = n;

        while(n != 0)
        {
            res += (n % 10);
            n = n / 10;
        }
        return res;
    }
}
