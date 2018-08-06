package algorithm;
public class Trie
{
    private class TrieNode
    {
        HashMap<Character,TrieNode> children;
        boolean endOfWord;
        public TrieNode()
        {
            children = new HashMap<Character,TrieNode>();
            endOfWord = false;
        }
    }
    private final TrieNode root;
    public Trie()
    {
        root = new TrieNode();
    }
    public void insert(String word)
    {
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++)
        {
            char x = word.charAt(i);
            TrieNode node = null;
            if(curr.children.containsKey(x)==false)
            {
                node = new TrieNode();
                curr.children.put(x,node);
            }
            else
            {
                node = curr.children.get(x);
            }
            curr = node;
        }
        curr.endOfWord = true;
    }
    public boolean search(String word)
    {
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            TrieNode node = curr.children.get(ch);
            if(node==null)
            {
                return false;
            }
            curr = node;
        }
        return curr.endOfWord;
    }
}