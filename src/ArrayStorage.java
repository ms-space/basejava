/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        int index = getIndexResume(r.uuid);
        if (index == -2) {
            System.out.println("Не удалось сохранить резюме. Не задан uuid.");
            return;
        }
        if (index >= 0) {
            System.out.println("Не удалось сохранить резюме, uuid: " + r.uuid + " . Данный uuid зарегистрирован в базе.");
            return;
        }
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        int index = getIndexResume(uuid);
        if (index == -1) {
            System.out.println("Резюме с uuid: " + uuid + " не найдено.");
            return null;
        }
        if (index == -2) {
            System.out.println("Не задан uuid. Повторите ввод.");
            return null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        int index = getIndexResume(uuid);
        if (index == -1) {
            System.out.println("Удаление невозможно, резюме с uuid: " + uuid + " не найдено.");
            return;
        }
        if (index == -2) {
            System.out.println("Не задан uuid. Повторите ввод.");
            return;
        }
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[size];
        System.arraycopy(storage, 0, allResume, 0, allResume.length);
        return allResume;
    }

    int size() {
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
            if ((storage[i].uuid).equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
