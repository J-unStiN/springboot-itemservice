package com.example.springboothh.domain.Item.dto.req;

import lombok.Builder;

@Builder
public record ItemUpdateReqDto(
        String username,
        String title,
        String content,
        int price
) {
}
