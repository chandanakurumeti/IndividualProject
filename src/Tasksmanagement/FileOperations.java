package Tasksmanagement;
import java.io.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
public class FileOperations  {
    /* To write an object to a file */
    public static boolean writeToFile (String fileName, List<Task> taskItemList) {
        boolean result = false;
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Task taskItem : taskItemList) {
                objectOut.writeObject(taskItem);
            }
            fileOut.close();
            objectOut.close();
            result = true;
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.printf("ERROR: %s\n ", ex);
        } return result;
    }
    /* To read an object from a file */
    public List<Task> readFromFile(String fileName) {
        List<Task> loadList = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            while (fileIn.available() > 0){         // check if the file stream is at the end
                Task obj = (Task) objectIn.readObject();
                loadList.add(obj);
            }
            fileIn.close();
            objectIn.close();
            return loadList;
        } catch (Exception ex) {
            System.out.printf("ERROR: %s\n ", ex);
            return loadList;
        }
    }
}