package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteLogic(int index) {
        for (int i = index; i < size; i++) {
            storage[i] = storage[i + 1];
        }
    }

    @Override
    protected void addResume(Resume r, int index) {
        int index0 = -index - 1;
        Resume tmp = storage[index0];
        storage[index0] = r;
        for (int i = size; i > index0; i--) {
            storage[i] = storage[i - 1];
        }
        storage[index0 + 1] = tmp;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, null);
    }
}