package com.example.springboothh.domain.Item.entity;


import com.example.springboothh.domain.Item.dto.req.ItemUpdateReqDto;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String username;

    public void updateItem(ItemUpdateReqDto itemUpdateReqDto) {
        this.title = itemUpdateReqDto.title();
        this.content = itemUpdateReqDto.content();
        this.price = itemUpdateReqDto.price();
        this.username = itemUpdateReqDto.username();
    }

}
