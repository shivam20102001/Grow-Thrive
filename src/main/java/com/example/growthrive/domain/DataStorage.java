package com.example.growthrive.domain;

import java.io.*;

public class DataStorage {
    public static void saveUserData(User user) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userData.ser"))) {
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User loadUserData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userData.ser"))) {
            return (User) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
