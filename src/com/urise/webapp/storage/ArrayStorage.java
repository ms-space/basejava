package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Не удалось сохранить резюме. В базе недостаточно места.");
            return;
        }

        int index = getIndexResume(r.getUuid());
        switch (index) {
            case -1 -> {
                storage[size] = r;
                size++;
            }
            case -2 -> System.out.println("Не удалось сохранить резюме. Не задан uuid.");
            default ->
                    System.out.println("Не удалось сохранить резюме, uuid: \"" + r.getUuid() + "\" . Данный uuid зарегистрирован в базе.");
        }
    }

    public Resume get(String uuid) {
        int index = getIndexResume(uuid);
        switch (index) {
            case -1 -> {
                System.out.println("Резюме с uuid: \"" + uuid + "\" не найдено.");
                return null;
            }
            case -2 -> {
                System.out.println("Не задан uuid. Повторите ввод.");
                return null;
            }
            default -> {
                return storage[index];
            }
        }
    }

    public void delete(String uuid) {
        int index = getIndexResume(uuid);
        switch (index) {
            case -1 -> System.out.println("Удаление невозможно, резюме с uuid: \"" + uuid + "\" не найдено.");
            case -2 -> System.out.println("Не задан uuid. Повторите ввод.");
            default -> {
                storage[index] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    public void update(String uuid, String newUuid) {
        int index = getIndexResume(uuid);
        switch (index) {
            case -1 -> System.out.println("Обновление невозможно, резюме с uuid: \"" + uuid + "\" не найдено.");
            case -2 -> System.out.println("Не задан uuid. Повторите ввод.");
            default -> storage[index].setUuid(newUuid);
        }
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
     * -2 if uuid Resume is null
     */
    private int getIndexResume(String uuid) {
        if (uuid == null) {
            return -2;
        }
        for (int i = 0; i < size; i++) {
            if ((storage[i].getUuid()).equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
