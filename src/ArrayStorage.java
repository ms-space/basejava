/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0, s = size(); i < s; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int indResume = getIndexResume(r.uuid);
        if (indResume == -2) {
            System.out.println("Не удалось сохранить резюме. Не задан uuid.");
            return;
        } else if (indResume >= 0) {
            System.out.println("Не удалось сохранить резюме, uuid: " + r.uuid + " . Данный uuid зарегистрирован в базе.");
            return;
        }
        try {
            storage[size()] = r;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("В базе нет места для сохранения резюме: " + r.uuid);
        }
    }

    Resume get(String uuid) {
        int indResume = getIndexResume(uuid);
        if (indResume == -1) {
            System.out.println("Резюме с uuid: " + uuid + " не найдено.");
            return null;
        } else if (indResume == -2) {
            System.out.println("Не задан uuid. Повторите ввод.");
            return null;
        }
        return storage[indResume];
    }

    void delete(String uuid) {
        int indResume = getIndexResume(uuid);
        if (indResume == -1) {
            System.out.println("Удаление невозможно, резюме с uuid: " + uuid + " не найдено.");
            return;
        } else if (indResume == -2) {
            System.out.println("Не задан uuid. Повторите ввод.");
            return;
        }

        int sizeResume = size();
        if (sizeResume == 1) {
            storage[indResume] = null;
        } else {
            storage[indResume] = storage[sizeResume - 1];
            storage[sizeResume - 1] = null;

        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumeBuffer = new Resume[size()];
        System.arraycopy(storage, 0, resumeBuffer, 0, resumeBuffer.length);
        return resumeBuffer;
    }

    int size() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return storage.length;
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
        for (int i = 0, s = size(); i < s; i++) {
            if ((storage[i].uuid).equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
