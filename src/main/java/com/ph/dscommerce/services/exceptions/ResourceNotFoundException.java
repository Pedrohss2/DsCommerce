package com.ph.dscommerce.services.exceptions;

import jdk.jshell.Snippet;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
