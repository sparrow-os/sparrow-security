package com.sparrow.security.admin.boot.config;

import com.sparrow.spring.starter.advice.ControllerResponseAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.sparrow.security","com.sparrow.passport","com.sparrow.file"})
public class ContactControllerAdvice extends ControllerResponseAdvice {
}
