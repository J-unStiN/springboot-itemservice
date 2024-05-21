package com.example.springboothh.domain.common;


import com.example.springboothh.domain.Item.dto.res.ItemDeleteResDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        ResponseEntity responseEntity = null;
        ItemDeleteResDto dto = ItemDeleteResDto.builder().msg(e.getMessage()).build();

        if(e instanceof EntityNotFoundException){
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(dto);
        }

        return responseEntity;
    }

}
