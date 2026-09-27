class Solution {
    public String reverseParentheses(String s) {

        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Find matching brackets
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else if (s.charAt(i) == ')') {
                int open = stack.pop();

                pair[open] = i;
                pair[i] = open;
            }
        }

        StringBuilder ans = new StringBuilder();
        int dir = 1;

        for (int i = 0; i < n; i += dir) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == ')') {
                i = pair[i];       // jump to matching bracket
                dir = -dir;        // change direction
            } 
            else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
