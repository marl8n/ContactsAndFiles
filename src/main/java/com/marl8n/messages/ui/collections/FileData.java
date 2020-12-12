/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.messages.ui.collections;

import com.marl8n.messages.Models.Contact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIDP9
 */
public class FileData {
    public static String directory = System.getProperty("user.home");
    public static String fileName = "contacts.dat";
    public static String filePath = directory + File.separator + "Contacts" + File.separator + fileName;
    
    public static void Load() {
        Object buffer = null;
        
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while ( (buffer = ois.readObject()) != null ) {
                DataAndLists.contacts.add((Contact) buffer);
            }
            ois.close();
            fis.close();
        } catch ( FileNotFoundException e ) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void Save() {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for ( int i = 0; i < DataAndLists.contacts.size(); i++ ) {
                oos.writeObject(DataAndLists.contacts.get(i));
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
