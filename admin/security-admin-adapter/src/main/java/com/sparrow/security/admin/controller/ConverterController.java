package com.sparrow.security.admin.controller;

import com.sparrow.protocol.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message/converter")
public class ConverterController {
    @GetMapping("boolean")
    public Result<Boolean> testBoolean() {
        return new Result<>(true);
    }

    @GetMapping("/int")
    public Result<Integer> testInteger() {
        return  new Result<>(1);
    }

    @GetMapping("/long")
    public Integer testLong() {
        return 1;
    }

    @GetMapping("/float")
    public Float testFloat() {
        return 1F;
    }

    @GetMapping("/byte")
    public Byte testByte() {
        return 1;
    }
}
