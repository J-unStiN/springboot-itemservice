package com.example.springboothh.domain.Item.service;

import com.example.springboothh.domain.Item.dto.req.ItemCreateReqDto;
import com.example.springboothh.domain.Item.dto.req.ItemUpdateReqDto;
import com.example.springboothh.domain.Item.dto.res.ItemCreateResDto;
import com.example.springboothh.domain.Item.dto.res.ItemDeleteResDto;
import com.example.springboothh.domain.Item.dto.res.ItemReadResDto;
import com.example.springboothh.domain.Item.dto.res.ItemUpdateResDto;
import com.example.springboothh.domain.Item.entity.Item;
import com.example.springboothh.domain.Item.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    @Transactional
    public ItemCreateResDto createItem(ItemCreateReqDto itemCreateReqDto) {

        Item createItem = Item.builder()
                .username(itemCreateReqDto.username())
                .title(itemCreateReqDto.title())
                .content(itemCreateReqDto.content())
                .price(itemCreateReqDto.price())
                .build();

        Item save = itemRepository.save(createItem);

        return ItemCreateResDto.builder()
                .id(save.getId())
                .username(save.getUsername())
                .title(save.getTitle())
                .content(save.getContent())
                .price(save.getPrice())
                .build();
    }


    public List<ItemReadResDto> getListItem() {
        List<ItemReadResDto> itemList = itemRepository.findAll().stream()
                .map(ItemReadResDto::of)
                .toList();

        return itemList;
    }

    @Transactional
    public ItemUpdateResDto updateItem(Long itemId, ItemUpdateReqDto itemUpdateReqDto) {
        Item findItem = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시물은 없습니다. 다시 확인해주세요."));

        findItem.updateItem(itemUpdateReqDto);

        return ItemUpdateResDto.builder()
                .id(findItem.getId())
                .title(findItem.getTitle())
                .content(findItem.getContent())
                .price(findItem.getPrice())
                .username(findItem.getUsername())
                .build();
    }

    @Transactional
    public void deleteItem(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("없는 게시글 입니다. 다시 확인해주세요."));

        itemRepository.delete(item);
    }

}
