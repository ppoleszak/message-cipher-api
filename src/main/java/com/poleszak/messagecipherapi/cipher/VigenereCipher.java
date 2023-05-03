package com.poleszak.messagecipherapi.cipher;

import org.springframework.stereotype.Service;

@Service
public class VigenereCipher {

    private final String key = "MySecretKeyKeyHoHoKeyThisIsKey";

    public String vigenereEncrypt(String msg) {
        StringBuilder encrypted = new StringBuilder();
        int keyIndex = 0;

        for (char c : msg.toCharArray()) {
            if (c == ' ') {
                encrypted.append(c);
                continue;
            }

            int keyShift = Character.toUpperCase(key.charAt(keyIndex)) - 'A';
            char shiftedChar = (char) (((c - 'A' + keyShift) % 26) + 'A');
            encrypted.append(shiftedChar);
            keyIndex = (keyIndex + 1) % key.length();
        }

        return encrypted.toString();
    }

    public String vigenereDecrypt(String msg) {
        StringBuilder decrypted = new StringBuilder();
        int keyIndex = 0;

        for (char c : msg.toCharArray()) {
            if (c == ' ') {
                decrypted.append(c);
                continue;
            }

            int keyShift = Character.toUpperCase(key.charAt(keyIndex)) - 'A';
            char shiftedChar = (char) (((c - 'A' - keyShift + 26) % 26) + 'A');
            decrypted.append(shiftedChar);
            keyIndex = (keyIndex + 1) % key.length();
        }

        return decrypted.toString();
    }
}