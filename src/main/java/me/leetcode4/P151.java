package me.leetcode4;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P151 {


    public String reverseWords(String s) {
        s = s.trim();
        if (s.indexOf(' ') == -1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                if (!word.toString().isEmpty()) {
                    sb.append(word.reverse());
                    sb.append(" ");
                }
                word = new StringBuilder();
            } else {
                word.append(s.charAt(i));
            }
            i--;
        }
        if (!word.toString().isEmpty()) {
            sb.append(word.reverse());
        }
        sb.trimToSize();
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "abc cds    ";
        System.out.println(new P151().reverseWords(s));
    }
}
