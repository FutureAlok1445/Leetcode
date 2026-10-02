import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        generate("", n * 2, result);

        return result;
    }

    public void generate(String str, int length, List<String> result) {

        // String complete ho gayi
        if (str.length() == length) {

            if (valid(str)) {
                result.add(str);
            }

            return;
        }

        // '(' add karo
        generate(str + "(", length, result);

        // ')' add karo
        generate(str + ")", length, result);
    }

    public boolean valid(String s) {

        int count = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                count++;
            } else {
                count--;
            }

            // ')' pehle aa gaya
            if (count < 0) {
                return false;
            }
        }

        // Equal number of '(' and ')'
        return count == 0;
    }
}