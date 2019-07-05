package com.lesson5.homework;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ItemDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Item save(Item item){
        entityManager.persist(item);
        return item;
    }

    public Item delete(Long id){
        Item item = entityManager.find(Item.class, id);
        entityManager.detach(item);
        return item;
    }

    public Item update(Item item){
        entityManager.merge(item);
        return item;
    }
}
