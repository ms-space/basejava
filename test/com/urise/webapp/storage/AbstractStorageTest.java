package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.ResumeTestData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected final Storage storage;
    private static final String UUID_NOT_EXIST = "dummy";
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String FULL_NAME_1 = "fullName1";
    private static final String FULL_NAME_2 = "fullName2";
    private static final String FULL_NAME_3 = "fullName3";
    private static final String FULL_NAME_4 = "fullName4";
    private static final Resume RESUME_1 = new ResumeTestData().setResumeTestData(UUID_1, FULL_NAME_1);
    private static final Resume RESUME_2 = new ResumeTestData().setResumeTestData(UUID_2, FULL_NAME_2);
    private static final Resume RESUME_3 = new ResumeTestData().setResumeTestData(UUID_3, FULL_NAME_3);
    private static final Resume RESUME_4 = new ResumeTestData().setResumeTestData(UUID_4, FULL_NAME_4);

    AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        assertArrayEquals(new ArrayList<Resume>().toArray(), storage.getAllSorted().toArray());
    }

    @Test
    public void update() {
        storage.update(RESUME_1);
        assertSame(RESUME_1, storage.get(RESUME_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume(UUID_NOT_EXIST));
    }


    @Test
    public void getAllSorted() {
        Resume[] expected = {RESUME_1, RESUME_2, RESUME_3};
        assertSize(expected.length);
        assertArrayEquals(expected, storage.getAllSorted().toArray());
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(RESUME_1.getUuid());
        assertSize(2);
        assertGet(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_NOT_EXIST);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_NOT_EXIST);
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}