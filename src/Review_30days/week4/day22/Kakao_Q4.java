package Review_30days.week4.day22;

public class Kakao_Q4 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int [] INFO;
    static int [] answer = new int[11];
    static boolean isPossible;
    public static void main(String[] args) {
        int n = 10;
        int [] info = {0,0,0,0,0,0,0,0,3,4,3}; //
        for(int i : solution(n,info)) System.out.print(i+" ");
    }
    static int[] solution(int n, int[] info) {
        N = n;
        INFO = info;
        comb(new int[11],0,0,0,0);
        if(!isPossible)
        {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        return answer;
    }
    static void comb(int [] res, int idx, int cnt,int apeach,int ryan)
    {
        if(idx == 11)
        {
            if(cnt < N) res[10] = N-cnt;
            if(apeach < ryan)
            {
                int score = ryan - apeach;
                if(max <= score)
                {
                    if(max == score)
                    {
                        if(!canChange(answer,res)) return;
                    }
                    isPossible = true;
                    System.arraycopy(res,0,answer,0,11);
                    max = score;
                }
            }
            return;
        }

        // 안쏘는경우
        int a_point = 0;
        res[idx] = 0;
        a_point = INFO[idx] > 0 ? 10-idx : 0; // 어피치가 한발이상 쐈으면 점수획득
        comb(res,idx+1,cnt,apeach+a_point,ryan);
        // 이기는경우
        int r_point = 10-idx; // 라이언 점수획득
        int tmp_cnt = INFO[idx]+1;
        if((cnt+tmp_cnt) <= N)
        {
            res[idx] = tmp_cnt;
            comb(res,idx+1,cnt+tmp_cnt,apeach,ryan+r_point);
        }
    }
    static boolean canChange(int [] fst, int [] sec)
    {
        for(int i = 10; i >= 0; --i)
        {
            if(fst[i] < sec[i]) return true;
            else if(fst[i] > sec[i]) return false;
        }
        return false;
    }
}
