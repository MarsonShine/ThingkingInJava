package net.mindview.util;

import javafx.scene.control.TreeSortMode;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 一个读写文件成字符串的静态函数，处理数组文件
 */
public class TextFile extends ArrayList<String> {
    // 读文件成一个字符串
    private static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(fileName).getAbsoluteFile())
            );
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    // 调用方法生成一个文件
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //读文件，通过增则表达式分开
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        // 增则表达式方法split()的第一个参数经常leaves空字符串
        if (get(0).equals("")) remove(0);
    }

    //寻常的行读取方法
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter pr = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (String item : this)
                    pr.println(item);
            } finally {
                pr.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //简单的例子
    public static void main(String[] args) {
        Path path = Paths.get("Book/", "src", "net", "mindview", "util", "TextFile.java");
        String file = read(path.toString());
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        //分解(breaking into)成唯一的单词集合列表
        TreeSet<String> words = new TreeSet<>(new TextFile("TextFile.java", "\\W+"));
        //显示单词的容量(capitalized)
        System.out.println(words.headSet("a"));
    }
}
