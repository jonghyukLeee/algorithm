import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        
        loop: for (String phone: phone_book) {
            int length = phone.length();
            for (int i = 1; i < length; i++) {
                if (set.contains(phone.substring(0, i))) {
                    answer = false;
                    break loop;
                }
            }
        }
        return answer;
    }
}