package com.jose.unittesting.business;

import com.jose.unittesting.data.ItemRepository;
import com.jose.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem(){
        return new Item(1,"Ball",10,100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items=itemRepository.findAll();
        items.forEach(item -> {
            item.setValue( item.getValue() * item.getQuantity() );
        });
        return items;
    }

}
