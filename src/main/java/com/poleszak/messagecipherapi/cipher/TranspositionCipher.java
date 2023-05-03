package com.poleszak.messagecipherapi.cipher;

import org.springframework.stereotype.Service;

@Service
public class TranspositionCipher {

    public String transposeColumns(String input) {
        StringBuilder transposed = new StringBuilder();
        int rowLength = (int) Math.ceil(Math.sqrt(input.length()));
        for (int i = 0; i < rowLength; i++) {
            for (int j = i; j < input.length(); j += rowLength) {
                transposed.append(input.charAt(j));
            }
        }
        return transposed.toString();
    }

    public String transposeColumnsBack(String input) {
        int rowLength = (int) Math.ceil(Math.sqrt(input.length()));
        char[] transposed = new char[input.length()];
        int index = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = i; j < input.length(); j += rowLength) {
                transposed[j] = input.charAt(index++);
            }
        }
        return new String(transposed);
    }
}