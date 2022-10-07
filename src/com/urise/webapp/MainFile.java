package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/com/urise/webapp/model");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }


        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(dir.isDirectory());
        System.out.println("===========================");

        File dirProject = new File("./src");
        printDirectoryDeeply(dirProject);
    }


    static void printDirectoryDeeply(File dir) throws IOException {
        int cnt = 0;
        String str = "";
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                cnt = file.getAbsolutePath().split("[\\\\]").length;
                str = " ".repeat(cnt);
                if (file.isFile()) {
                    System.out.println(str + "File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(str + "Directory: " + file.getName());
                    printDirectoryDeeply(file);
                }
            }
        }
    }
}
