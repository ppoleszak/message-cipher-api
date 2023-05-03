package com.poleszak.messagecipherapi.service;

import com.poleszak.messagecipherapi.cipher.TranspositionCipher;
import com.poleszak.messagecipherapi.cipher.VigenereCipher;
import org.springframework.stereotype.Service;

@Service
public class CipherService {

    private final TranspositionCipher transpositionCipher;
    private final VigenereCipher vigenereCipher;


    public CipherService(TranspositionCipher transpositionCipher, VigenereCipher vigenereCipher) {
        this.transpositionCipher = transpositionCipher;
        this.vigenereCipher = vigenereCipher;
    }

    public String encryptMessage(String msg) {
        msg = msg.replaceAll("[^A-Za-z ]+", "").toUpperCase();
        String vigenereEncrypted = vigenereCipher.vigenereEncrypt(msg);
        return transpositionCipher.transposeColumns(vigenereEncrypted);
    }

    public String decryptMessage(String cipher) {
        String transposeColumnDecrypt = transpositionCipher.transposeColumnsBack(cipher);
        return vigenereCipher.vigenereDecrypt(transposeColumnDecrypt);
    }
}