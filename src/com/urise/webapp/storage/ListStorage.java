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
    public void update(Resume r) {
        storage.set(getExistIndex(r.getUuid()), r);
    }

    @Override
    public void save(Resume r) {
        storage.add(checkNotExist(r));
    }

    @Override
    public Resume get(String uuid) {
        return storage.get(getExistIndex(uuid));
    }

    @Override
    public void delete(String uuid) {
        storage.remove(getExistIndex(uuid));
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
    protected int getIndex(String uuid) {
        Resume searchObject = new Resume(uuid);
        return storage.indexOf(searchObject);
    }


}
