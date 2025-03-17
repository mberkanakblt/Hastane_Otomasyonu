package com.mehmetberkan.hastane_otomasyonu.exception;
import lombok.Getter;

@Getter
public class HastaneException extends RuntimeException {
    private ErrorType errorType;
    public HastaneException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

}
