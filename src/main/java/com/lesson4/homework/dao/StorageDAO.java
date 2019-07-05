package com.lesson4.homework.dao;

import com.lesson4.homework.entity.Storage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StorageDAO extends GeneralDAO<Storage> {
    private static final String delete = "DELETE FROM STORAGES WHERE ID = ?";
    private static final String getAll = "SELECT * FROM STORAGES";

    public StorageDAO() {
        setDelete(delete);
        setGetAll(getAll);
        setParameterOfClass(Storage.class);
    }

    @Override
    public Storage save(Storage storage) {
        return super.save(storage);
    }

    @Override
    public Storage update(Storage storage) {
        return super.update(storage);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public Storage findById(long id) {
        return super.findById(id);
    }

    @Override
    public List<Storage> getAll() {
        return super.getAll();
    }
}
