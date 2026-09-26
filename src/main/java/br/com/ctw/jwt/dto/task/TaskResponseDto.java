package br.com.ctw.jwt.dto.task;

public record TaskResponseDto (

        Long id,
        String title,
        String description,
        Boolean completed,
        String username
){}
