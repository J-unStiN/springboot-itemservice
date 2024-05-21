package com.example.springboothh.domain.Item.dto.res;

import com.example.springboothh.domain.Item.entity.Item;
import lombok.Builder;

@Builder
public record ItemReadResDto(
        Long id,
        String username,
        String title,
        int price
) {

    public static ItemReadResDto of(Item item) {

        return ItemReadResDto.builder()
                .id(item.getId())
                .title(item.getTitle())
                .username(item.getUsername())
                .price(item.getPrice())
                .build();
    }

}
