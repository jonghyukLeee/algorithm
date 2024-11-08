import java.util.HashMap;
import java.util.Map;

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode cur = root;

        for (char c: word.toCharArray()) {
            if (!cur.child.containsKey(c)) {
                cur.child.put(c, new TrieNode());
            }

            cur = cur.child.get(c);
            cur.count++;
        }
    }

    int calc(String word) {
        int result = 0;
        TrieNode cur = root;

        for (char c: word.toCharArray()) {
            cur = cur.child.get(c);
            result++;

            if (cur.count == 1) break;
        }

        return result;
    }
}
class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
    int count;
}

class Solution {
    public int solution(String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }

        int answer = 0;
        for (String word: words) {
            answer += trie.calc(word);
        }

        return answer;
    }
}