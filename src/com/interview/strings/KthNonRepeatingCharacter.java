package com.interview.strings;

import java.util.Arrays;

public class KthNonRepeatingCharacter {

    public static int MAX_CHAR = 256;

    // driver program
    public static void main (String[] args)
    {
        String str = "geeksforgeeks";
        int k = 3;
        int res = kthNonRepeating(str, k);

        System.out.println(res == -1 ? "There are less than k non-repeating characters" :
                "k'th non-repeating character is  " + str.charAt(res));
    }

    private static int kthNonRepeating(String str, int k) {
        int[] count = new int[MAX_CHAR];
        int[] index = new int[MAX_CHAR];
        int strLength = str.length();
        for (int i = 0; i<MAX_CHAR;i++) {
            count[i] = 0;
            index[i] = strLength;
        }

        for (int i = 0;i < strLength; i++) {
            char singlechar = str.charAt(i);
            ++count[singlechar];

            if(count[singlechar] == 1) {
                index[singlechar] = i;
            }
            if (count[singlechar]==2) {
                index[singlechar] = strLength;
            }
        }
        Arrays.sort(index);

        return index[k-1] != strLength ? index[k-1] : -1;
    }
}
