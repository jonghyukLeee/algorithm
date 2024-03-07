import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class MineralCount {
    int diamond;
    int iron;
    int stone;

    public MineralCount(int diamond, int iron, int stone) {
        this.diamond = diamond;
        this.iron = iron;
        this.stone = stone;
    }

    public void addCount(String mineral) {
        switch (mineral) {
            case "diamond": {
                this.diamond++;
                break;
            }
            case "iron": {
                this.iron++;
                break;
            }
            case "stone": {
                this.stone++;
                break;
            }
        }
    }

    public int dig(int[][] point, int pickax) {
        int diamondPoint = this.diamond * point[pickax][0];
        int ironPoint = this.iron * point[pickax][1];
        int stonePoint = this.stone * point[pickax][2];

        return diamondPoint + ironPoint + stonePoint;
    }
}

class Solution {
    static int[][] point = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
    };
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        // 다이아 0, 철 1, 돌 2
        Queue<Integer> picksQueue = new LinkedList<>();

        int totalPickax = 0;
        for (int i = 0; i < 3; i++) {
            int amount = picks[i];
            totalPickax += amount;
            for (int j = 0; j < amount; j++) {
                picksQueue.add(i);
            }
        }

        PriorityQueue<MineralCount> pq = new PriorityQueue<>(new Comparator<MineralCount>() {
            @Override
            public int compare(MineralCount o1, MineralCount o2) {
                if (o1.diamond == o2.diamond) {
                    if (o1.iron == o2.iron) {
                        return o2.stone - o1.stone;
                    }
                    return o2.iron - o1.iron;
                }
                return o2.diamond - o1.diamond;
            }
        });

        MineralCount mineralCount = new MineralCount(0, 0, 0);
        int tmpAddCount = 0;
        int mineralGroupCount = 0;
        for (String mineral: minerals) {
            if (mineralGroupCount == totalPickax) break;
            
            mineralCount.addCount(mineral);
            tmpAddCount++;
            if (tmpAddCount == 5) {
                pq.add(mineralCount);
                mineralGroupCount++;
                mineralCount = new MineralCount(0, 0, 0);
                tmpAddCount = 0;
            }
        }

        if (tmpAddCount > 0) {
            pq.add(mineralCount);
        }

        while (!pq.isEmpty() && !picksQueue.isEmpty()) {
            MineralCount mineralGroup = pq.poll();
            int pickax = picksQueue.poll();
            answer += mineralGroup.dig(point, pickax);
        }

        return answer;
    }
}