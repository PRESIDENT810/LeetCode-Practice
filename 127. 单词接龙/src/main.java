import java.util.*;

class main {
    public static void main(String args[]){
        String beginWord = "hot";
        String endWord = "dog";
        List<String> list = new LinkedList<>();
        String[] arr = {"hot","dog","cog","pot","dot"};
        Collections.addAll(list, arr);
        int res = new Solution127().ladderLength(beginWord, endWord, list);
        System.out.print(res);
    }
}

class Node{
    String word;
    List<Node> connected;
    int level = 1;
    Node(String word){
        this.word = word;
        this.connected = new LinkedList<>();
    }
}

class Solution127 {
    int res = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean start_in_list = false;
        boolean end_in_list = false;
        for (String word: wordList) {
            if (word.equals(start_in_list)) start_in_list = true;
            if (word.equals(endWord)) end_in_list = true;
        }
        if (!end_in_list) return 0;
        if (!start_in_list) wordList.add(beginWord);
        wordList.add(endWord);
        Map<String, Node> map = new HashMap<>();
        makeGraph(wordList, map);
        int res = BFS(beginWord, endWord, map);
        return res;
    }

    public int BFS(String beginWord, String endWord, Map<String, Node> map){
        Node beginNode = map.get(beginWord);
        Node endNode = map.get(endWord);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(beginNode);
        Set<Node> visited = new HashSet<>();
        while (!queue.isEmpty()){
            Node crtNode = queue.poll();
            for (Node node: crtNode.connected){
                if (node == endNode) return crtNode.level+1;
                if (visited.contains(node)) continue;
                if (node.level == 1 || node.level > crtNode.level+1) node.level = crtNode.level+1;
                queue.offer((node));
            }
            visited.add(crtNode);
        }
        return 0;
    }

    public Map<String, Node> makeGraph(List<String> wordList, Map<String, Node> map){
        for (String word: wordList){
            Node word_node = new Node(word);
            // iterate each word in the map
            for (String compareWord: map.keySet()){
                if (getDistance(compareWord, word) == 1){
                    // connect these two
                    Node compareWord_node = map.get(compareWord);
                    compareWord_node.connected.add(word_node);
                    word_node.connected.add(compareWord_node);
                }
            }
            map.put(word, word_node);
        }
        return map;
    }

    public int getDistance(String word1, String word2){
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        if (arr1.length != arr2.length) return -1;
        int cnt = 0;
        for (int i=0; i<word1.length(); i++){
            if (arr1[i] != arr2[i]) cnt++;
        }
        return cnt;
    }
}
