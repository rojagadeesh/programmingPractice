package com.interview.strings;

/*Java program to find first non-repeating character
Example:

Input string: str = geeksforgeeks
1: Construct Map with Character and occurance count
....
['e'] = 4
['f'] = 1
['g'] = 2
['k'] = 2
??
2: Get the first character who's count is 1 ('f').

*/

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String charset = "geeks forgeeks";
        int idx = getNonRepeatingCharacter(charset);
        System.out.println(idx < 0 ? "Either all characters are repeating"
                : "First non-repating character: " + charset.charAt(idx));
    }

    private static int getNonRepeatingCharacter(String charset) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character c : charset.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        for (int i = 0; i < charset.length(); i++) {
            if (charMap.get(charset.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
