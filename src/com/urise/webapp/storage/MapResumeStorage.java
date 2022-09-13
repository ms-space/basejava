package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    protected Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Object value) {
        return value != null;
    }

    @Override
    protected void doUpdate(Resume r, Object value) {
        Resume searchResume = (Resume) value;
        map.put(searchResume.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object value) {
        return (Resume) value;
    }

    @Override
    protected void doDelete(Object value) {
        Resume r = (Resume) value;
        map.remove(r.getUuid());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}