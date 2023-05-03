package com.poleszak.messagecipherapi.controller;

import com.poleszak.messagecipherapi.service.CipherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cipher")
@RequiredArgsConstructor
public class CipherController {

    private final CipherService cipherService;

    @PostMapping("/encrypt")
    public ResponseEntity<String> encrypt(@RequestBody CipherRequest cipherRequest) {
        return ResponseEntity.ok().body(cipherService.encryptMessage(cipherRequest.message()));
    }

    @PostMapping("/decrypt")
    public ResponseEntity<String> decrypt(@RequestBody CipherRequest cipherRequest) {
        return ResponseEntity.ok().body(cipherService.decryptMessage(cipherRequest.message()));
    }
}