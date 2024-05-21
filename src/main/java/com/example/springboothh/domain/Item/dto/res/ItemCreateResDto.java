package com.example.springboothh.domain.Item.dto.res;

import lombok.Builder;

@Builder
public record ItemCreateResDto(
        Long id,
        String username,
        String title,
        String content,
        int price
) {
}
