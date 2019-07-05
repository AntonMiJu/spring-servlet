package com.lesson4.homework.service;

import com.lesson4.homework.dao.FileDAO;
import com.lesson4.homework.entity.File;
import com.lesson4.homework.entity.Storage;
import com.lesson4.homework.exception.WrongFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileDAO fileDAO;

    public List<File> findFilesByStorage(Storage storage) {
        return fileDAO.findFileByStorage(storage);
    }

    public void saveList(List<File> files) throws WrongFormatException {
        for (File file : files)
            validateFileByName(file);
        fileDAO.saveList(files);
    }

    public File save(File file) throws WrongFormatException {
        validateFileByName(file);
        return fileDAO.save(file);
    }

    public File update(File file) throws WrongFormatException {
        validateFileByName(file);
        return fileDAO.update(file);
    }

    public void delete(long id) {
        fileDAO.delete(id);
    }

    public File findById(long id) {
        return fileDAO.findById(id);
    }

    private void validateFileByName(File file) throws WrongFormatException {
        if (file.getName().length() <= 10)
            return;
        throw new WrongFormatException("Name in file " + file.getId() + " is too long");
    }
}
