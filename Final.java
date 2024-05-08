import java.util.*;


public class Final {
    // Problem 1
    // This would be the provided graph, simulate the graph input as a field
    private static int[][] graph;

    // Helper function to determine if person a knows person b.
    private static boolean knows(int a, int b) {
        return graph[a][b] == 1;
    }

    // Function to find the celebrity
    public static int findCelebrity(int n) {
        int candidate = 0;
        
        // First pass to find the candidate
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // Second pass to confirm the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }

        return candidate;
    }

    // Problem 2
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize dummy node to simplify edge cases like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast ahead by n+1 steps to ensure slow points to the previous node of target node
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        // Return the head of the modified list
        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Problem 3
    public static void reverseWords(char[] s) {
        // Reverse the entire array
        reverse(s, 0, s.length - 1);
        
        // Reverse each word
        int start = 0;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    }
    
    private static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    // Problem 4
    // check the independent file


    public static void main(String[] args) {
        //Test for problem 1
        //test 1 for problem 1
        graph = new int[][]{{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(findCelebrity(3));  // Expected Output: 1 

        //test 2 for problem 1
        graph = new int[][]{{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(findCelebrity(3)); // Expected Output: -1

        //Test for problem 2
        //test 1 for problem 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        head = removeNthFromEnd(head, 2);
        printList(head); // Expected Output: 1 -> 2 -> 3 -> 5

        //test 2 for problem 2
        head = new ListNode(1);
        head = removeNthFromEnd(head, 1);
        printList(head); // Expected Output: null
        
        //test 3 for problem 3
        head = new ListNode(1);
        head.next = new ListNode(2);
        head = removeNthFromEnd(head, 1);
        printList(head); // Expected Output: 1


        //Test for problem 3
        //test 1 for problem 3
        char[] s1 = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s1);
        System.out.println(s1);  // Expected Output: "blue is sky the"
        //test 2 for problem 3
        char[] s2 = {'a'};
        reverseWords(s2);
        System.out.println(s2);  // Expected Output: "a"


    }
    

}
