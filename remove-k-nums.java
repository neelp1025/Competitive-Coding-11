// Time Complexity : O(n) where n is number of digits
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Starting from left to right, we add the numbers to the end of the linked list if numbers are in increasing order.
 * If the current number is smaller than last number in the list, we keep taking the bigger element out till we have removed k bigger elements. If it is bigger, we add it to the list.
 * After adding all elements to the list, remove total k elements from the end if they are already not removed.
 * Once left with n-k numbers, we can create the final number by reading the numbers from starting of the list. We can ignore the leading zeros.
 */
class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> chars = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            while (!chars.isEmpty() && k > 0 && chars.peekLast() > num.charAt(i)) {
                chars.removeLast();
                k--;
            }

            chars.addLast(num.charAt(i));
        }

        for (int i = 0; i < k; i++) {
            chars.removeLast();
        }

        boolean leadingZero = true;
        StringBuilder res = new StringBuilder();
        while (!chars.isEmpty()) {
            if (leadingZero && chars.getFirst() == '0') {
                chars.pollFirst();
                continue;
            }

            leadingZero = false;
            res.append(chars.pollFirst());
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}