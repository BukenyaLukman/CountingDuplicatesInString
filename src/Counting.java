import java.util.HashMap;
import java.util.Map;

public class Counting {

    public static void main(String[] args){
        Map<Character, Integer> management = countDuplicateCharacters("management");
        System.out.println(management);

        Map<String,Integer> duplicates = countDuplicateCharactersTwo("employment");
        System.out.println(duplicates);
    }

    public static Map<Character, Integer> countDuplicateCharacters(String str){
        Map<Character,Integer> result = new HashMap<>();

        // Can use the ForEachLoop for(char ch: str.toCharArray()) {...}
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            result.compute(ch, (k,v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public static Map<String, Integer> countDuplicateCharactersTwo(String str){
        Map<String, Integer> result =  new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if(Character.charCount(cp) == 2){
                // 2 means a surrogate Pair
                i++;
            }
            result.compute(ch, (k,v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }
}
