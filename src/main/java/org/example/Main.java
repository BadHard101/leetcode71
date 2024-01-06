package org.example;

import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static String simplifyPath(String path) {

        Stack<String> directories = new Stack<>();

        String[] elems = path.split("/");

        for (String elem : elems) {
            if (!elem.isEmpty() && !elem.isBlank() && !elem.equals(".")) {
                switch (elem) {
                    case "..": {
                        if (!directories.isEmpty()) directories.pop();
                        break;
                    }
                    default: {
                        directories.push(elem);
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        if (directories.isEmpty()) {
            result.append("/");
        } else {
            for (String dir : directories) {
                result.append("/").append(dir);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }
}