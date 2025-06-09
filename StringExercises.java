public class StringExercises {
    public static void main(String[] args){}
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
}
