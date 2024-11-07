class Solution {
    public int solution(int[] cookie) {
        int maxCookies = 0;  // 최대 쿠키 합 초기화

        // 중간 위치를 기준으로 왼쪽과 오른쪽 구간을 나누기
        for (int mid = 0; mid < cookie.length - 1; mid++) {
            int leftSum = cookie[mid];      // 왼쪽 구간 합 초기화
            int rightSum = cookie[mid + 1]; // 오른쪽 구간 합 초기화
            int left = mid;                 // 왼쪽 포인터 초기화
            int right = mid + 1;            // 오른쪽 포인터 초기화

            // 왼쪽과 오른쪽 구간 합이 같을 때 최대 쿠키 개수 갱신
            while (true) {
                if (leftSum == rightSum) {
                    maxCookies = Math.max(maxCookies, leftSum); // 최대값 갱신
                }
                
                // 두 포인터를 이동하며 구간 합 조정
                if (leftSum <= rightSum && left > 0) {
                    leftSum += cookie[--left]; // 왼쪽으로 확장
                } else if (rightSum < leftSum && right < cookie.length - 1) {
                    rightSum += cookie[++right]; // 오른쪽으로 확장
                } else {
                    break; // 더 이상 확장할 수 없으면 종료
                }
            }
        }

        return maxCookies; // 최대 쿠키 개수 반환
    }
}