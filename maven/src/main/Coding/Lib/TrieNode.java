package main.Coding.Lib;

public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrieNode{");
        sb.append("isEndOfWord=").append(isEndOfWord);
        sb.append(", children=[");
        for (int i = 0; i < 26; i++) {
            if (children[i] != null) {
                sb.append((char)('a' + i)).append(',');
            }
        }
        if (sb.charAt(sb.length() - 1) == ',') sb.deleteCharAt(sb.length() - 1);
        sb.append("]}");
        return sb.toString();
    }
}
