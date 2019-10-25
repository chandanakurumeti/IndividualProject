package tasksmanagement;

import java.io.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This Class FileOperations deals with the operations in which files are involved
 */

public class FileOperations {

    /**
     * writeToFile() method gets the data from the arraylist and writes it into the file
     *
     * @param fileName
     * @param taskItemList
     * @return boolean result
     */
    public static boolean writeToFile(String fileName, List<Task> taskItemList) {
        boolean result = false;
        try {
            File file = new File(fileName);   //creating a file with the fileName
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Task taskItem : taskItemList) {
                objectOut.writeObject(taskItem); // writing the tasks from taskItemList into the file
            }
            fileOut.close();
            objectOut.close();  //closing the file and object
            result = true;      // returns true only if tasks has been added to the file
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.printf("ERROR: %s\n ", ex);
        }
        return result;        // returns false if tasks are not added to the file.
    }

    /**
     * readFromFile() method reads the data from file into the arraylist
     *
     * @param fileName
     * @return loadList
     */

    public List<Task> readFromFile(String fileName) {
        List<Task> loadList = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            while (fileIn.available() > 0) {         // check if the file stream is at the end
                Task obj = (Task) objectIn.readObject();
                loadList.add(obj);                  //getting the data from file and adding into the arraylist created loadList
            }
            fileIn.close();                         // closing the file and object
            objectIn.close();
            return loadList;                        // returning the arraylist loadList after adding the data from file into it.
        } catch (Exception ex) {
            System.out.printf("ERROR: %s\n ", ex);
            return loadList;
        }
    }
}