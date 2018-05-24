package com.newnil.snowyowl.littlesnowyowl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HeroNotFoundException extends Exception {
}
