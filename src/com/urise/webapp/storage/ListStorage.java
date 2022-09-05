package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void doUpdate(Resume r, Object index) {
        storage.set((Integer) index, r);
    }

    @Override
    public void doSave(Resume r, Object searchKey) {
        storage.add(r);
    }

    @Override
    public Resume doGet(Object index) {
        return storage.get((Integer) index);
    }

    @Override
    public void doDelete(Object index) {
        storage.remove(((Integer) index).intValue());
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchObject = new Resume(uuid);
        return storage.indexOf(searchObject);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }


}
