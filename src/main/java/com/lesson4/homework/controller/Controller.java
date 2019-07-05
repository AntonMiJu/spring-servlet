package com.lesson4.homework.controller;

import com.lesson4.homework.entity.File;
import com.lesson4.homework.entity.Storage;
import com.lesson4.homework.exception.WrongFormatException;
import com.lesson4.homework.service.FileService;
import com.lesson4.homework.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Controller {
    private FileService fileService;
    private StorageService storageService;

    @Autowired
    public Controller(FileService fileService, StorageService storageService) {
        this.fileService = fileService;
        this.storageService = storageService;
    }

    public void put(Storage storage, File file) throws WrongFormatException {
        validateFileByFormat(storage, file);
        if (storage.getStorageSize() > file.getSize()) {
            storage.setStorageSize(storage.getStorageSize() - file.getSize());
            file.setStorage(storage);
            fileService.save(file);
        }
    }

    public void delete(Storage storage, File file) throws WrongFormatException {
        File fileById = fileService.findById(file.getId());
        if (fileById != null) {
            storage.setStorageSize(storage.getStorageSize() + file.getSize());
            file.setStorage(null);
            fileService.update(file);
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception{
        List<File> files = fileService.findFilesByStorage(storageFrom);
        for (File file : files){
            validateFileByFormat(storageTo,file);
            if (storageTo.getStorageSize() > file.getSize())
                storageTo.setStorageSize(storageTo.getStorageSize() - file.getSize());
            else
                throw  new Exception("Storage "+storageTo.getId()+" hasn't enough space.");
        }
        fileService.saveList(files);
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws WrongFormatException {
        File fileById = fileService.findById(id);
        if (fileById != null && storageTo.getStorageSize() > fileById.getSize()) {
            validateFileByFormat(storageTo,fileById);
            storageFrom.setStorageSize(storageFrom.getStorageSize() + fileById.getSize());
            storageTo.setStorageSize(storageTo.getStorageSize() - fileById.getSize());
            fileById.setStorage(storageTo);
            fileService.update(fileById);
        }
    }

    private void validateFileByFormat(Storage storage, File file) throws WrongFormatException {
        for (String format : storage.getFormatsSupported()) {
            if (file.getFormat().equals(format))
                return;
        }
        throw new WrongFormatException("File " + file.getId() + " has wrong format and can not be save to storage " + storage.getId());
    }
}
