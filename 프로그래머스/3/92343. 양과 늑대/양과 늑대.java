import java.util.*;

class Solution {
    int maxSheep = 0;
    public int solution(int[] info, int[][] edges) {
        // 트리 구조를 만들기 위해 인접 리스트 생성
        List<Integer>[] tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 정보를 통해 트리 구성
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree[parent].add(child);
        }

        // DFS 탐색 시작 (0번 노드에서 시작)
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        dfs(0, 0, 0, nextNodes, info, tree);

        return maxSheep;
    }
    private void dfs(int node, int sheep, int wolf, List<Integer> nextNodes, int[] info, List<Integer>[] tree) {
        // 현재 노드가 양인지 늑대인지에 따라 카운트 증가
        if (info[node] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        // 늑대 수가 양 수 이상이면 더 이상 진행 불가
        if (wolf >= sheep) {
            return;
        }

        // 최대 양 수 업데이트
        maxSheep = Math.max(maxSheep, sheep);

        // 다음 탐색할 노드 리스트 생성
        List<Integer> newNextNodes = new ArrayList<>(nextNodes);
        newNextNodes.remove(Integer.valueOf(node)); // 현재 노드는 제거
        newNextNodes.addAll(tree[node]); // 현재 노드의 자식 노드 추가

        // 다음 노드들에 대해 DFS 호출
        for (int nextNode : newNextNodes) {
            dfs(nextNode, sheep, wolf, newNextNodes, info, tree);
        }
    }
}