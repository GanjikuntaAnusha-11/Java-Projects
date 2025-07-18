import java.util.*;
import java.util.regex.*;
public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();     
        System.out.println("Word Count of given text: "+wordCount(userInput));
        System.out.println("Line Count of given text: "+lineCount(userInput));        
        System.out.println("Character Count of given text: "+characterCount(userInput));
        System.out.println("Sentence Count of given text: "+sentenceCount(userInput));
        System.out.println("Letter frequency of given text:\n"+letterFrequency(userInput));
        sc.close();
    }
    public static long wordCount(String s) {
        long count = 0L;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ' ') {
                count++;
            }
        }
        return count+1; 
    }
    public static long lineCount(String s) {
        long lineCount = 0L;
        if(s.isEmpty()) {
            lineCount = 0l;
        }
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i) == '\n') {
                lineCount++;
            }
        }
        return lineCount;
    }
    public static long characterCount(String s) {
        long characterCount = 0L;
        characterCount = s.length();
        return characterCount;
    }
    public static long sentenceCount(String s) {
        long sentenceCount = 0L;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?') {
                sentenceCount++;
            }
        }
        return sentenceCount;
    }
    public static Map<Character, Integer> letterFrequency(String s) {
        Map<Character, Integer> letterMap = new HashMap<>();
        Pattern pattern = Pattern.compile("^[!@#$%^&*()??<>,.]");
        for(int i=0;i<s.length();i++) {
            Matcher match = pattern.matcher(Character.toString(s.charAt(i)));
            boolean found = match.find();
            if(!found && s.charAt(i) != ' '){
            letterMap.put(Character.toLowerCase(s.charAt(i)), letterMap.getOrDefault(Character.toLowerCase(s.charAt(i)), 0)+1);
            }
        }
        return letterMap;
    }
}