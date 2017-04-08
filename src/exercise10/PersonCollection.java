/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author e1500941
 */
public class PersonCollection {
    private ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
    
    public void writeToFile(String filename) {
        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream(filename))) {
            fout.writeObject(persons);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
	public void readFromFile(String filename) {
        try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(filename))) {
            persons = (ArrayList<Person>) fin.readObject();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } 
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
