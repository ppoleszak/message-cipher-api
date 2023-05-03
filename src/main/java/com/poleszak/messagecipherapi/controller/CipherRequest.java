package com.poleszak.messagecipherapi.controller;

import org.springframework.lang.NonNull;

public record CipherRequest(@NonNull String message) {
}