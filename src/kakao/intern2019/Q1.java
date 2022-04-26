package kakao.intern2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1 {
    static List<Stack<Integer>> map;
    static Stack<Integer> basket;
    static int size;
    public static void main(String[] args) {
        int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [] moves = {1,5,3,5,1,2,1,4};
        System.out.print(solution(board,moves));
    }
    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        size = board.length;
        map = new ArrayList<>();
        basket = new Stack<>();

        for(int i = 0; i < size; i++)
        {
            map.add(new Stack<>());
            for(int j = size-1; j >= 0; j--)
            {
                if(board[j][i] > 0) map.get(i).push(board[j][i]);
            }
        }

        for(int i : moves)
        {
            if(!map.get(i-1).isEmpty())
            {
                int next = map.get(i-1).pop();
                if(!basket.isEmpty() && basket.peek() == next)
                {
                    basket.pop();
                    answer += 2;
                }
                else basket.push(next);
            }
        }
        return answer;
    }
}
