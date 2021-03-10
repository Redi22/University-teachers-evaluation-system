/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;


import Models.Teacher;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

/**
 *
 * @author kk
 */
//ComboBox component custom for teachers
public class TeacherCombo {
 
    private Teacher teacher = null;

    public TeacherCombo() {
        
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public ComboBox combo(){
        List<Teacher> teachers = null;
         DatabaseServiceInterface serv;
        try {
            serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getTeachers");
            teachers = serv.getTeachers();
        } catch (NotBoundException ex) {
            Logger.getLogger(LevelOfEdCombo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LevelOfEdCombo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(LevelOfEdCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        ComboBox<Teacher> c = new ComboBox<Teacher>();
        c.setPrefHeight(300);
        c.setConverter(new StringConverter<Teacher>() {
            @Override
            public String toString(Teacher ed) {
                return ed.getFullName(); 
            }
            @Override
            public Teacher fromString(final String string) {
                return c.getItems().stream().filter(edLevel -> edLevel.getFullName().equals(string)).findFirst().orElse(null);
            }
    });
        
        c.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            teacher = newValue;
});
        
        c.getItems().addAll(teachers);
        return c;
    }
    
}

