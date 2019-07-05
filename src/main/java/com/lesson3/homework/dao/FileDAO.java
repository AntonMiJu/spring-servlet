package com.lesson3.homework.dao;

import com.lesson3.homework.entity.File;
import com.lesson3.homework.entity.Storage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileDAO extends GeneralDAO<File> {
    private Session session = null;

    private static final String delete = "DELETE FROM FILES WHERE ID = ?";
    private static final String getAll = "SELECT * FROM FILES";
    private static final String findFileByStorage = "SELECT * FROM FILES WHERE STORAGE_ID = ?";

    public FileDAO() {
        setDelete(delete);
        setGetAll(getAll);
        setParameterOfClass(File.class);
    }

    public List<File> findFileByStorage(Storage storage){
        try(Session session = getSession()) {
            NativeQuery query = session.createNativeQuery(findFileByStorage);
            query.addEntity(File.class);
            query.setParameter(1,storage.getId());

            return (List<File>) query.list();
        } catch (HibernateException e) {
            System.err.println("Getting all objects gone wrong");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void saveList(List<File> t) {
        super.saveList(t);
    }

    @Override
    public File save(File file) {
        return super.save(file);
    }

    @Override
    public File update(File file) {
        return super.update(file);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public File findById(long id) {
        return super.findById(id);
    }

    @Override
    public List<File> getAll() {
        return super.getAll();
    }

    private Session getSession(){
        if (session == null)
            session = new Configuration().configure().buildSessionFactory().openSession();
        return session;
    }
}
