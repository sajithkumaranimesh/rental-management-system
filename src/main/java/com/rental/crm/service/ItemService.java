package com.rental.crm.service;

import com.rental.crm.dto.Item;

import java.util.List;

public interface ItemService {
    void persist(Item item);

    List<Item> retrieve();

    Item retrieveById(Long id);

    Item retrieveByName(String name);

    void updateItem(Item item);

    void deleteItem(Long id);
}
