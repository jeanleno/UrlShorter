package com.jlheidemann.urlshorter.util;

import java.util.Random;

/**
 *
 * @author jeanl
 */
public class UrlKeyGenerator {

    private static char BASE62_ALPHABET[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 
     * @return 
     */
    public String generateKey() {
        Random rand = new Random();
        int keyLength = rand.nextInt(31) + 5;
        String key = "";
        for (int i = 0; i <= keyLength; i++) {
            key += BASE62_ALPHABET[rand.nextInt(62)];
        }
        return key;
    }
}
