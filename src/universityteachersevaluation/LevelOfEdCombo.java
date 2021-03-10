/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.LevelOfEducation;
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

//Combobox class custom component to get data from server and model populate 

public class LevelOfEdCombo {
    
    private LevelOfEducation level = null;

    public LevelOfEdCombo() {
        
    }

    public LevelOfEducation getLevel() {
        return level;
    }

    //setter for level from server
    public void setLevel(int id) {
        LevelOfEducation lev = null;
         try {
            DatabaseServiceInterface serv1 = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getLevelById");
            lev =   serv1.getLevelById(id);
        } catch (NotBoundException ex) {
            Logger.getLogger(LevelOfEdCombo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LevelOfEdCombo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(LevelOfEdCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.level = lev;
    }
    List<LevelOfEducation> levels = null;

    //function for returing the gui part for the combobox
    public ComboBox combo(){
         DatabaseServiceInterface serv;
        try {
            serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getLevelOfEducation");
            levels =   serv.getLevelOfEds();
        } catch (NotBoundException ex) {
            Logger.getLogger(LevelOfEdCombo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LevelOfEdCombo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(LevelOfEdCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        ComboBox<LevelOfEducation> c = new ComboBox<LevelOfEducation>();
        c.setConverter(new StringConverter<LevelOfEducation>() {
        @Override
        public String toString(LevelOfEducation ed) {
            return ed.getName();
        }
        @Override
        public LevelOfEducation fromString(final String string) {
            return c.getItems().stream().filter(edLevel -> edLevel.getName().equals(string)).findFirst().orElse(null);
        }
    });
        
        c.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            level = newValue;
});
        
        c.getItems().addAll(levels);
        return c;
    }
    

}
