import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Long answer = 0L;
        Map<Long, Long> torqueMap = new HashMap<>();
        Map<Long, Long> weightCount = new HashMap<>(); // 각 무게의 등장 횟수를 추적

        for (long weight : weights) {
            // 무게의 등장 횟수를 업데이트
            weightCount.put(weight, weightCount.getOrDefault(weight, 0L) + 1);
            Long[] torques = {weight * 2, weight * 3, weight * 4};
                for (Long torque : torques) {
                    torqueMap.put(torque, torqueMap.getOrDefault(torque, 0L) + 1);
                }
        }

        // 토크값에 따른 짝꿍의 수를 계산합니다.
        for (Long count : torqueMap.values()) {
            if (count > 1) {
                answer += (Long) count * (count - 1) / 2;
            }
        }


        // 중복으로 들어간 값들 계산
        Long minus = 0L;
        for (Long count : weightCount.values()) {
            if(count > 1){
                minus+= ((Long) count * (count - 1) / 2)*2;
            }
        }

        return answer - minus;
    }
}