import ms.util.TextFile;

import static ms.util.Println.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class E16_Vowels {
    private final static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'i', 'A', 'E', 'O', 'U', 'I'));

    public static void main(String[] args) {
        HashSet<String> processWords = new HashSet<>();
        int fileVowels = 0;
        int wordVowels;
        for (String word :
                new TextFile("E16_Vowels.java", "\\W+")) {
            wordVowels = 0;
            for (char letter : word.toCharArray()) {
                if (vowels.contains(letter))
                    wordVowels++;
                if (!processWords.contains(word)) {
                    processWords.add(word);
                    print((word + " has " + wordVowels + " vowel(s)"));
                }
                fileVowels += wordVowels;
            }
            print("Total number of vowels in file: " + fileVowels);
        }
    }
}
