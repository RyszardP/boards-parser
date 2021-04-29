package io.ryszardp.service;

import io.ryszardp.beans.Item;
import io.ryszardp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemDataService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void getAllItems(){
        List<Item> items = itemRepository.findAllByAge("Items");
    }



}
