// Time Complexity : O(n) where n is number of tokens
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * We can use a stack to keep track of most recent numbers and apply the operation for the sign that was found in the string and put back into the stack since the current operation will always have a "num1, num2, sign" format.
 * At the end, do a sum of all items from the stack to get the final result.
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (token.equals("-")) {
                int last = st.pop();
                int secondLast = st.pop();
                st.push(secondLast - last);
            } else if (token.equals("/")) {
                int last = st.pop();
                int secondLast = st.pop();
                st.push(secondLast / last);
            } else if (token.equals("*")) {
                st.push(st.pop() * st.pop());
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;
    }
}