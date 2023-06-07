package com.teachsync.TeachSync;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("tt")
    String demi(){
        return "hello";
    }
}
