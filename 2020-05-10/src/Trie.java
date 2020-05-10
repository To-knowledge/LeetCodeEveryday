public class Trie {
    public static void main(String[] args) {
        String[] book = new String[]{"ljs","ljs","t","fdof","t","t","doidz","t","c","sc","zs","t","t","ljs","zmcsr","t","j","t","t","t","dzbg","t","t"};
        int i = new WordsFrequency(book).get("lc");
        System.out.println(i);
    }
}

class WordsFrequency {
    TrieNode dictionary = new TrieNode();
    public WordsFrequency(String[] book) {
        //创建字典树
        TrieNode tmp = null;
        for(int i = 0; i < book.length; i++){
            tmp = dictionary;
            for(int j = 0; j < book[i].length(); j++){
                if(tmp.son[book[i].charAt(j) - 'a'] == null)
                    tmp.son[book[i].charAt(j) - 'a'] = new TrieNode();
                tmp = tmp.son[book[i].charAt(j) - 'a'];
            }
            tmp.cnt++;
        }
    }

    public int get(String word) {
        TrieNode tmp = dictionary;
        //查找字典
        for(int i = 0; i < word.length(); i++){
            if(tmp == null) return 0;
            tmp = tmp.son[word.charAt(i)-'a'];
        }
        return tmp == null ? 0 : tmp.cnt;
    }
}

class TrieNode{
    int cnt;
    TrieNode[] son;
    //TrieNode[] son = new TrieNode[26];

    public TrieNode(){
        this.cnt = 0;
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */
