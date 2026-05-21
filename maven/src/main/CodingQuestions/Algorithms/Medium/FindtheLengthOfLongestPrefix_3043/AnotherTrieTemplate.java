package main.CodingQuestions.Algorithms.Medium.FindtheLengthOfLongestPrefix_3043;

public class AnotherTrieTemplate {

    public static void main(String[] args) {
        Trie trie = new AnotherTrieTemplate().new Trie();
        // Test case 1: Insert and search for 'cat', 'car', 'dog'
        trie.insert("cat");
        trie.insert("car");
        trie.insert("dog");
        System.out.println(trie.search("cat")); // true
        System.out.println(trie.search("car")); // true
        System.out.println(trie.search("dog")); // true
        System.out.println(trie.search("ca"));  // false
        System.out.println(trie.search("bat")); // false
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
        char value = 0; // Store the character for debug/visualization
    }

    class Trie {
        TrieNode root = new TrieNode();

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                    node.children[idx].value = c;
                }
                node = node.children[idx];
            }
            node.isEndOfWord = true;
        }

        // Search for a word in the Trie
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return node.isEndOfWord;
        }

        // Print the Trie structure for visualization
        public void printTrie() {
            printTrieHelper(root, "");
        }

        private void printTrieHelper(TrieNode node, String prefix) {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    char c = (char) (i + 'a');
                    System.out.println(prefix + c + (node.children[i].isEndOfWord ? " (end)" : ""));
                    printTrieHelper(node.children[i], prefix + c);
                }
            }
        }
    }
}
