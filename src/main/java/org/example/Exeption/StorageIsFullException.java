package org.example.Exeption;

public class StorageIsFullException extends RuntimeException {
    public StorageIsFullException(String message) {
        super(message);
    }
}
