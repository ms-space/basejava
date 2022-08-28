package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractArrayStorageTest {

    private final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume r = storage.get(UUID_1);
        storage.update(r);
        Assert.assertEquals(r, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume());
    }

    @Test
    public void getAll() {
        Resume[] expected = new Resume[3];
        expected[0] = new Resume(UUID_1);
        expected[1] = new Resume(UUID_2);
        expected[2] = new Resume(UUID_3);
        Assert.assertArrayEquals(expected, storage.getAll());
    }

    @Test
    public void save() {
        storage.save(new Resume());
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = storage.size(); i < STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail("Overflow happened ahead of time\n" +
                    "STORAGE_LIMIT = " + STORAGE_LIMIT + "\n" +
                    e.getMessage());
        }
        storage.save(new Resume());
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void get() {
        Resume expected = new Resume(UUID_1);
        Assert.assertEquals(expected, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}