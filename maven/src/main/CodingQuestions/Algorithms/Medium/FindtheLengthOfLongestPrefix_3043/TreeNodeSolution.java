package main.CodingQuestions.Algorithms.Medium.FindtheLengthOfLongestPrefix_3043;

public class TreeNodeSolution {
    public static void main(String[] args) {
        int[] arr1 = {123, 456, 789};
        int[] arr2 = {1234, 4567, 7890};
        TreeNodeSolution obj = new TreeNodeSolution();
        System.out.println(obj.longestCommonPrefix(arr1, arr2));
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[10];
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode head = new TrieNode();
        for (int num : arr1) {
            String numS = Integer.toString(num);
            TrieNode node = head;
            for (int i = 0; i < numS.length(); i++) {
                int index = numS.charAt(i) - '0';
                TrieNode next = node.children[index] == null ? new TrieNode() : node.children[index];
                node.children[index] = next;
                node = next;
            }
        }

        int max = 0;
        for (int num : arr2) {
            String numS = Integer.toString(num);
            TrieNode node = head;
            for (int i = 0; i < numS.length(); i++) {
                int index = numS.charAt(i) - '0';
                TrieNode next = node.children[index];
                if (next == null) {
                    break;
                }
                node = next;
                max = Math.max(max, i + 1);
            }

        }
        return max;
    }
}
