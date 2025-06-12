public class StringExercises {
    public static void main(String[] args){
        isAnagram("Jaime", "Carlos");
    }
    /*
     * Write a program to search for a given character in a string. If the character is found,
     * print the index/position where it first appears in the string. If the character is not found, print -1.
     */
    public int searchCharacter(String s, char ch) {
        return s.indexOf(ch);
    }
    /*
     * Given a string s, a character c and an integer position pos, the task is to insert the character c into
     * the string s at the specified position pos.
     */
    static String insertChar(StringBuilder sb, char c, int pos) {
        return sb.insert(pos, c).toString();
    }
    /*
     * Given a string s, the task is to check if it is a binary string or not. A binary string is a string which
     * only contains the characters '0' and '1'.
     */
    boolean isBinary(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0' || s.charAt(i)!='1')return false;
        }
        return true;
    }
    /*
     * Given a sentence having lowercase characters, the task is to convert it to Camel Case. In Camel Case, words are joined without spaces,
     *  the first word keeps its original case, and each subsequent word starts with an uppercase letter.
     */
    public String convertToCamelCase(String s) {
        String[] words=s.split(" ");
        StringBuilder camelCase = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) continue;
            if (i == 0) {
                camelCase.append(word);
            } else {
                camelCase.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    camelCase.append(word.substring(1));
                }
            }
        }
        return camelCase.toString();
    }
    //Given two strings the task is to check whether the two given strings are anagrams of each other or not
    /*
     *  I came up with the idea of using two arrays with 26 slots each to act as a storage for the alphabet.
     * Then, we iterate through each string and, as letters appear, we increment the corresponding position in the
     * array. Finally, we compare the two arrays to see if they are equal.
     *
     * Another idea that comes to mind is to use a single array. As we iterate through the first string, we increment
     * the corresponding positions, and as we iterate through the second string, we decrement them. In the end, if all
     * positions in the array are zero, then the strings are anagrams.
     */
    public static boolean isAnagram(String s1,String s2){
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        int[] abc=new int[26];
        for(char i='a';i<='z';i++){
            if(s1.indexOf(i)!=-1)abc[i-'a']++;
            if(s2.indexOf(i)!=-1)abc[i-'a']--;
        }
        for (int count : abc) {
            if (count != 0) return false;
        }
        return true;
    }
       //Given a string S, the task is to find the length of the longest substring between any pair of occurrences of same charactersAdd commentMore actions
    /*
     * What comes to mind at first is to use the two-pointer strategy — a start and an end — such that start moves from the first index
     * to the right, and end moves from the end to the left. When we find the first match, it means we have found the longest matching
     * substring.
     * 
     * Welcome, user. To solve this exercise, we need to understand the KMP algorithm. First, we must discuss the LPS table, which is
     * constructed based on the prefixes and suffixes found in the text (txt). Once the LPS table is built, the rest of the algorithm is
     * relatively straightforward. We use two pointers: one for the pattern (i) and one for the text (j). The pointer i is ahead of j. When
     * characters match, we move both pointers to the right. However, when there is a mismatch, we refer to the LPS table: we move the pattern
     * pointer to the index indicated by the LPS value at the mismatch position and evaluate again. If there is still no match and we are already
     * at index 0 in the LPS, we shift the i pointer one step to the right and repeat the process.
     */
    public static int[] tableLPS(String pattern){
        int i=1;
        int len=0;
        int[] lps=new int[pattern.length()];
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static void KPMAlgorithm(String txt,String pattern){
        int i=0;
        int j=0;
        int[] lps=tableLPS(pattern);
        if(txt.charAt(i)==pattern.charAt(j)){
            i++;
            j++;
        }
        if(j==pattern.length()){
            System.out.println("I found the pattern");
            j=lps[j-1];
        }else if(i<txt.length() && txt.charAt(i)!=pattern.charAt(j)){
            if(j!=0){
                j=lps[j-1];
            }else{
                i++;
            }
        }
    }
}
