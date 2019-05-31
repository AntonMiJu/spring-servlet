package com.lesson3.homework.dao;

import com.lesson3.homework.entity.Storage;

import java.util.List;

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
