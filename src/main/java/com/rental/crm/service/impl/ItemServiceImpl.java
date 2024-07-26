package com.rental.crm.service.impl;

import com.rental.crm.dto.Item;
import com.rental.crm.entity.ItemEntity;
import com.rental.crm.repository.ItemRepositoty;
import com.rental.crm.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepositoty repositoty;

    @Override
    public void persist(Item item) {
        ItemEntity itemEntity = new ModelMapper().map(item, ItemEntity.class);
        repositoty.save(itemEntity);
    }

    @Override
    public List<Item> retrieve() {

        List<Item> itemList = new ArrayList<>();

        for (ItemEntity itemEntity : repositoty.findAll()) {
            itemList.add(new ModelMapper().map(itemEntity, Item.class));
        }
        return itemList;
    }

    @Override
    public Item retrieveById(Long id) {
        Optional<ItemEntity> itemEntity = repositoty.findById(id);
        return new ModelMapper().map(itemEntity, Item.class);
    }

    @Override
    public Item retrieveByName(String name) {
        ItemEntity itemEntity = repositoty.findByName(name);
        return new ModelMapper().map(itemEntity, Item.class);
    }

    @Override
    public void updateItem(Item item) {
        if (repositoty.findById(item.getId()).isPresent()){
            repositoty.save(new ModelMapper().map(item, ItemEntity.class));
        }
    }

    @Override
    public void deleteItem(Long id) {
        if (repositoty.findById(id).isPresent()){
            repositoty.deleteById(id);
        }
    }


}
