package com.mehmetberkan.hastane_otomasyonu.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorType {


    BADREQUEST(4002, "Girilen parametereler hatalıdır.",BAD_REQUEST),
    SIFREHATASI(4003, "Girişlen şifreler bir biri ile uyuşumamaktadır.",BAD_REQUEST),
    EMAIL_SIFRE_HATASI(4004, "Kullanıcı adı ya da şifre hatalısır", BAD_REQUEST),
    RANDEVU_NOTFOUND(2001, "Id si verilen ürün bulunamadı", INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(4999, "Geçersiz token bilgisi", FORBIDDEN),
    INTERNAL_SERVER(5000, "Sunucuda beklenmeyen bir hata",INTERNAL_SERVER_ERROR);

    int code;
    String message;
    HttpStatus httpStatus;
}
