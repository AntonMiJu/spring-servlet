package com.lesson6;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ItemDAO {
    private static final String deleteByName = "DELETE * FROM ITEM WHERE NAME LIKE ?";

    @PersistenceContext
    private EntityManager entityManager;

    public Item get(Long id) {
        return entityManager.find(Item.class, id);
    }

    public Item save(Item item) {
        entityManager.persist(item);
        return item;
    }

    public Item delete(Long id) {
        Item item = entityManager.find(Item.class, id);
        entityManager.detach(item);
        return item;
    }

    public Item update(Item item) {
        entityManager.merge(item);
        return item;
    }

    public void deleteByName(String name) {
        entityManager.createNativeQuery(deleteByName)
                .setParameter(1, "'%" + name + "%'");
    }
}
