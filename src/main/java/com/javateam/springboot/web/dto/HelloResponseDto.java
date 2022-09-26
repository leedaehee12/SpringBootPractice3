package com.javateam.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name,
                                             @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
    private final String name;
    private final int amount;
}
