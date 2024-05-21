package com.example.springboothh.domain.Item.repository;

import com.example.springboothh.domain.Item.entity.Item;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
