
/*
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
       words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
 */

import java.util.ArrayList;
public class Word_Search2 {
    public static void main(String[] args) {
        char[][] grid={{'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}};
        String[] words={"oath","pea","eat","rain"};
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            list.add(wordSearch(grid,words[i]));
        }
    }
    static String wordSearch(char[][] grid,String word){
        String w="";
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(word.charAt(i) == grid[i][j]){
                    w=check(grid,i,j,word);
                }
            }
        }
        return w;
    }
    static String check(char[][] grid,int i,int j,String word){
        if(i <0 || i >=grid.length ){
            return "";
        }
        if(j < 0 || j>=grid[0].length){
            return "";
        }
        return "";
    }
}
