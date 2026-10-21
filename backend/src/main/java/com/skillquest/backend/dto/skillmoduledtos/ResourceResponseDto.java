package com.skillquest.backend.dto.skillmoduledtos;

public record ResourceResponseDto(
    Long id,
    String title,
    String url,
    boolean isFree
) {}
