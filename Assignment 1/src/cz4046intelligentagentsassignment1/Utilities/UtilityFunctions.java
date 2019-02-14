package cz4046intelligentagentsassignment1.Utilities;

import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * Class that contains all the utility function for the program
 * @author Kenneth
 */
public class UtilityFunctions {

    /**
    * Deep copy functions that creates an replica of any objects.
    * Requires the object to be serializable
    * @param originalObject Object to be duplicated
    */
    public static Object deepCopy(Object originalObject){
        Object newObject = null;
        
        // Write the object out to a byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        try {
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(originalObject);
            out.flush();
            out.close();
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
            return null;
        }
        

        // Make an input stream from the byte array and read
        // a copy of the object back in.
        
        try {
            ObjectInputStream in = new ObjectInputStream(
            new ByteArrayInputStream(bos.toByteArray()));
            newObject = in.readObject();
            return newObject;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error:" + ex.getMessage());
            return null;
        }
    }
}

