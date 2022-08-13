package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    protected static final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Не удалось сохранить резюме. В базе недостаточно места.");
        } else if (index >= 0) {
            System.out.println("Не удалось сохранить резюме, uuid: \"" + r.getUuid() + "\" . Данный uuid зарегистрирован в базе.");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме с uuid: \"" + uuid + "\" не найдено.");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Удаление невозможно, резюме с uuid: \"" + uuid + "\" не найдено.");
            return;
        }
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    public void update(String uuid, String newUuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Обновление невозможно, резюме с uuid: \"" + uuid + "\" не найдено.");
            return;
        }
        storage[index].setUuid(newUuid);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    /**
     * @return index Resume if Resumes in storage,
     * -1 if Resume not in storage,
     */
    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if ((storage[i].getUuid()).equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
