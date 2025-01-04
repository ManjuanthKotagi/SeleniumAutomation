import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


public class Program {

    @Test()
    public void programTest() {
        String str = "Manjunath";
        char characters[] = str.toCharArray();
        int size = characters.length;
        Set<Character> uniqueCharacters = new LinkedHashSet<>();

        for(Character ch : characters) {
            uniqueCharacters.add(ch);
        }

        StringBuilder uniqueCharacterString = new StringBuilder(uniqueCharacters.toString());

        System.out.println("Unique Characters is " + uniqueCharacterString);
    }
}
