package matteogilioli.balancebuddy.logic.file;

import java.io.*;

public class FileLoadSave {
    public static Object load(File file) {
        try {
            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            Object data = objectStream.readObject();
            objectStream.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            return new Error();
        }
    }

    public static boolean save(Object data, File file) {
        try {
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(data);
            objectStream.flush();
            objectStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

