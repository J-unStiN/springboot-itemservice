package com.example.springboothh.domain.Item.dto.res;

import lombok.Builder;

@Builder
public record ItemUpdateResDto(
        Long id,
        String title,
        String content,
        int price,
        String username
) {
}
