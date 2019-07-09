package com.lesson6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemDAO itemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public Item get(Long id){
        return itemDAO.get(id);
    }

    public Item save(Item item){
        return itemDAO.save(item);
    }

    public Item delete(Long id){
        return itemDAO.delete(id);
    }

    public Item update(Item item){
        return itemDAO.update(item);
    }

    public void deleteByName(String name){
        itemDAO.deleteByName(name);
    }
}
