package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

import static java.lang.Math.abs;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
        }
    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (abs(index) >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            int index0 = abs(index) - 1;
            Resume tmp = storage[index0];
            storage[index0] = r;
            for (int i = size; i > index0; i--) {
                storage[i] = storage[i - 1];
            }
            storage[index0 + 1] = tmp;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            for (int i = index; i < size; i++) {
                storage[i] = storage[i + 1];
            }
            storage[size] = null;
            size--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, null);
    }
}