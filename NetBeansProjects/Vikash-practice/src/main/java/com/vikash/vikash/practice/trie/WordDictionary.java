package com.vikash.vikash.practice.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
     static class Node {
        Node[] children = new Node[26]; // Array for 26 lowercase letters
        boolean eow = false; // Marks the end of a word

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node(); // Initialize root node
    }

    // Adds a word to the Trie
    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a'; // Get array index (0 to 25)
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node(); // Create node if missing
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // Mark the end of the word
    }

    // Searches for a word in the Trie
    public boolean search(String word) {
        return dfsSearch(word, root, 0);
    }

    // DFS search helper
    private boolean dfsSearch(String word, Node curr, int index) {
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') { // Wildcard handling
                for (Node child : curr.children) {
                    if (child != null && dfsSearch(word, child, i + 1)) {
                        return true;
                    }
                }
                return false; // No match found for '.'
            } else {
                int idx = ch - 'a';
                if (curr.children[idx] == null) return false; // If path doesn't exist
                curr = curr.children[idx];
            }
        }
        return curr.eow; // Return true if it's a valid word
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map=new HashMap<>();
        map.putIfAbsent(1,2);
        //map.putIfAbsent(1,4);
       Object val= map.putIfAbsent(1, 4);
        System.out.println(val);
        System.out.println(map.get(1));
    }
}
