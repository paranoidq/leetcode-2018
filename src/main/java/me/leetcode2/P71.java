package me.leetcode2;

import me.leetcode1.P7;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P71 {

    public static String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return path;
        }
        LinkedList<String> list = new LinkedList<>();
        String[] splits = path.split("/");
        for (String el : splits) {
            if (!el.isEmpty()
                && !el.equals("..")
                && !el.equals(".")) {
                list.addLast(el);
            } else if (el.equals("..")) {
                if (list.isEmpty()) {

                } else {
                    list.removeLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String el : list) {
            sb.append(el).append("/");
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));
    }
}
