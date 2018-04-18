package ms.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String> {
    //读文件成单个字符串
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()
            ));
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

    //写文件
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

    //读一个文件，通过增则表达式分割
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        //正则表达式split（）通常会留下一个空字符串在第一位
        if (get(0).equals("")) remove(0);
    }
}
