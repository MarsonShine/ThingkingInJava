package exercise.io;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * 使用TextFile和Map<Character,Integer>创建一个程序，来统计在一个文件总统计不同的字符
 * 如果在文件字符“a”出现了12次，那么在Map中的Charecter关联的就是“a”，Integer就是“12”
 */
public class E17_CharactersInfo {
    public static void main(String[] args) {
        Map<Character, Integer> charsStat = new HashMap<>();
        for (var word : new TextFile("E17_CharactersInfo.java", "\\W+"))
            for (var i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                Integer freq = charsStat.get(ch);
                charsStat.put(ch, freq == null ? 1 : freq + 1);
            }
        List<Character> keys = Arrays.asList(charsStat.keySet().toArray(new Character[0]));
        Collections.sort(keys);
        for (Character key : keys)
            System.out.println(key + "=>" + charsStat.get(key));
    }
}
