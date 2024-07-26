package com.rental.crm.controller;

import com.rental.crm.dto.Item;
import com.rental.crm.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item-controller")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @PostMapping("/add")
    public Boolean persist(@RequestBody Item item){
        service.persist(item);
        return true;
    }

    @GetMapping("/get-all")
    public List<Item> retrieve(){
        return service.retrieve();
    }

    @GetMapping("/get-by-id/{id}")
    public Item retrieveById(@PathVariable Long id){
        return service.retrieveById(id);
    }

    @GetMapping("/get-by-name/{name}")
    public Item retrieveByName(@PathVariable String name){
        return service.retrieveByName(name);
    }

    @PutMapping("/update")
    public Boolean updateItem(@RequestBody Item item){
        service.updateItem(item);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteItemById(@PathVariable Long id){
        service.deleteItem(id);
        return true;
    }
}
