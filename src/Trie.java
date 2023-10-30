import java.util.ArrayList;
import java.util.Arrays;

class Trie {
    boolean isLeaf;
    int[] child = new int[26];
    Trie[] childList;

    public Trie() {
        isLeaf = false;
        Arrays.fill(child, 0);
        childList = new Trie[26];
        for(int i = 0; i<26; i++) {
            childList[i] = null;
        }
    }

    // 每次把下一层次搞定
    public void insert(String word) {
        if(word == null || word.equals("")) return;
        char res = word.charAt(0);
        int index = res - 'a';
        child[index] = 1;
        if(childList[index] == null) {
            childList[index] = new Trie();
        }
        if(word.substring(1).equals("")) childList[index].isLeaf = true;
        else {
            if(!childList[index].isLeaf)
                childList[index].isLeaf = false;
            childList[index].insert(word.substring(1));
        }
    }

    public boolean search(String word) {
        if(word == null) return true;
        if(word.equals("")) {
            return isLeaf;
        }
        char res = word.charAt(0);
        int index = res - 'a';

        if(childList[index] == null) {
            return false;
        }
        else return childList[index].search(word.substring(1));
    }

    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.equals("")) return true;
        char res = prefix.charAt(0);
        int index = res - 'a';
        if(childList[index] == null) {
            return false;
        }
        else return childList[index].startsWith(prefix.substring(1));
    }
}