package com.example.springboothh.domain.Item.controller;


import com.example.springboothh.domain.Item.dto.req.ItemCreateReqDto;
import com.example.springboothh.domain.Item.dto.req.ItemUpdateReqDto;
import com.example.springboothh.domain.Item.dto.res.ItemCreateResDto;
import com.example.springboothh.domain.Item.dto.res.ItemDeleteResDto;
import com.example.springboothh.domain.Item.dto.res.ItemReadResDto;
import com.example.springboothh.domain.Item.dto.res.ItemUpdateResDto;
import com.example.springboothh.domain.Item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    /* 판매 게시글 작성 */
    @PostMapping("/post")
    public ResponseEntity<?> createItem(@RequestBody ItemCreateReqDto itemCreateReqDto) {
        ItemCreateResDto dto = itemService.createItem(itemCreateReqDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dto);
    }


    /* 판매 게시글 전체 리스트 조회 */
    @GetMapping("/post")
    public ResponseEntity<?> getListItem() {
        List<ItemReadResDto> dto = itemService.getListItem();

        return ResponseEntity.status(HttpStatus.OK)
                .body(dto);
    }

    /* 판매 게시글 수정 */
    @PutMapping("/post/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody ItemUpdateReqDto itemUpdateReqDto) {
        ItemUpdateResDto dto = itemService.updateItem(id, itemUpdateReqDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(dto);
    }


    /* 판매 게시글 삭제 */
    @DeleteMapping("post/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        ItemDeleteResDto dto = ItemDeleteResDto.builder().msg("삭제완료").build();

        return ResponseEntity.status(HttpStatus.OK)
                .body(dto);
    }



}
