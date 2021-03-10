/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;


import Models.User;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author kk
 */

//Setting View GUI
public class SettingView {
    
    AnchorPane root = new AnchorPane();
    public AnchorPane settingsView(){
        
        //container
        AnchorPane apContainer = new AnchorPane();
        apContainer.setPrefSize(900, 500);
        apContainer.setStyle("-fx-background-color:#e6f2f0");
        VBox vbContainer = new VBox(15);
        
        //header 
        HBox hbHeaderContainer = new HBox();
        HBox.setHgrow(hbHeaderContainer, Priority.ALWAYS);
        hbHeaderContainer.setPrefSize(900.0, 50.0);
        hbHeaderContainer.setStyle("-fx-background-color: white");
        AnchorPane apHeaderContainer = new AnchorPane();
        
       
        HBox hbUserInfoContainer = new HBox(10);
        VBox vbUserInfoContainer = new VBox();
        hbUserInfoContainer.setPadding(new Insets(10,10,10,10));
        vbUserInfoContainer.setAlignment(Pos.BASELINE_LEFT);
        hbUserInfoContainer.setAlignment(Pos.CENTER);
        FontAwesomeIcon faUser = new FontAwesomeIcon();
        faUser.setIconName("USER");
        faUser.setSize("45px");
        faUser.setGlyphStyle("-fx-fill: teal");
        Label lblFullname = new Label(UniversityTeachersEvaluation.currentUser.getUser().getFullName());
        lblFullname.setStyle("-fx-font-size: 20px; -fx-font-weight: bolder; -fx-text-fill: teal");
        Label lblEmail = new Label(UniversityTeachersEvaluation.currentUser.getUser().getEmail());
        lblEmail.setStyle("-fx-text-fill: teal; -fx-font-size:15px");
        
        vbUserInfoContainer.getChildren().addAll(lblFullname, lblEmail);
        hbUserInfoContainer.getChildren().addAll(faUser,vbUserInfoContainer);
        //admin label
        Label lblAdmin = new Label();
        if(UniversityTeachersEvaluation.currentUser.getUser().isAdmin()){
            lblAdmin.setText("Admin");
        }else{
            lblAdmin.setText("Teacher");
        }
        lblAdmin.setStyle("-fx-background-color: teal; -fx-padding: 10px; -fx-background-radius:20px; -fx-text-fill: white;");
        
        //set the width of apHeader to the parent
        HBox.setHgrow(apHeaderContainer, Priority.ALWAYS);
        
        //Align the admin label to right and center
        AnchorPane.setRightAnchor(lblAdmin,10.00);
        AnchorPane.setTopAnchor(lblAdmin,10.00);
        AnchorPane.setBottomAnchor(lblAdmin,10.00);
        
        AnchorPane.setTopAnchor(hbHeaderContainer, 0.00);
        
        
        //Body container
        VBox vbBody = new VBox();
        vbBody.setAlignment(Pos.CENTER);
        
        VBox vbBodyContainer = new VBox(15);
        vbBodyContainer.setMaxWidth(400.00);
        vbBodyContainer.setAlignment(Pos.CENTER);
        vbBodyContainer.setStyle("-fx-background-color:white; -fx-padding: 20px");
        Label lblChangeSettings = new Label("Change Settings");
        lblChangeSettings.setStyle("-fx-font-weight: bolder; -fx-font-size: 30px");
        PasswordField tfNewPass = new PasswordField();
        tfNewPass.setPromptText("New Password");
        PasswordField tfConfirm = new PasswordField();
        tfConfirm.setPromptText("Confirm");
        Button btnDone = new Button("Done");
        btnDone.setStyle("-fx-background-color: teal; -fx-text-fill: white");
        
        AnchorPane.setLeftAnchor(vbBodyContainer, 300.00);
        AnchorPane.setRightAnchor(vbBodyContainer, 300.00);
        AnchorPane.setTopAnchor(vbContainer, 0.00);
        AnchorPane.setBottomAnchor(vbContainer, 0.00);
        vbContainer.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(vbContainer, Priority.ALWAYS);
        
        vbBodyContainer.getChildren().addAll(lblChangeSettings,tfNewPass,tfConfirm,btnDone);
        VBox.setVgrow(vbBody, Priority.ALWAYS);
        vbBody.getChildren().add(vbBodyContainer);
        
        
        hbHeaderContainer.getChildren().add(apHeaderContainer);
        apHeaderContainer.getChildren().addAll(hbUserInfoContainer,lblAdmin);
        vbContainer.getChildren().addAll(hbHeaderContainer,vbBody);
        apContainer.getChildren().add(vbContainer);
        
        btnDone.setOnAction(e->{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Are You Sure?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                String pass = tfNewPass.getText();
                String newPass = tfConfirm.getText();
                if(pass.equals(newPass)){
                    System.out.println("abt to change pss");
                            try {
                            DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/changePassword");
                            serv.changePassword(pass , UniversityTeachersEvaluation.currentUser.getUser().getId());
                        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                            Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                

            } else {
                
            }
        });
        
        root.getChildren().addAll(apContainer);
        return root;
    }
    
    
}
