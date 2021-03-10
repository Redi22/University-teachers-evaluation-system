/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.CurrentUser;
import Models.User;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
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

//login Page 
public class LoginView {
    
    VBox vbLoginContainer = new VBox();
    //login VBox returning function
    public VBox LoginView(){
        //container
        VBox vbLogin = new VBox(10);
        vbLogin.setMaxWidth(400.00);
        vbLogin.setStyle("-fx-background-color:white; -fx-padding: 20px; -fx-background-radius: 15px");
        FontAwesomeIcon faUser = new FontAwesomeIcon();
        faUser.setIconName("USER");
        faUser.setGlyphStyle("-fx-fill: teal; -fx-font-size: 55px");
        
        Label lblLogin = new Label("User Login");
        lblLogin.setStyle("-fx-font-size: 45px; -fx-font-weight: bolder");
        Label lblEmail = new Label("Email");
        lblEmail.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: teal;");
        Label lblPassword = new Label("Password");
        lblPassword.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: teal;");
        
        VBox vbEmail = new VBox(5);
        TextField tfEmail = new TextField();
        tfEmail.setPrefHeight(50.0);
        tfEmail.setPromptText("Email");
        vbEmail.getChildren().addAll(lblEmail, tfEmail);
        
        VBox vbPass = new VBox(5);
        PasswordField pfPassword = new PasswordField();
        pfPassword.setPrefHeight(50.0);
        pfPassword.setPromptText("Password");
        vbPass.getChildren().addAll(lblPassword,pfPassword);
        
        
        Button btnLogin = new Button("Login");
        btnLogin.setStyle("-fx-background-color: teal; -fx-text-fill: white; -fx-font-weight: bolder; -fx-font-size: 25px");
        btnLogin.setPrefSize(350.0,50.0);
        
        
        vbLogin.getChildren().addAll(faUser, lblLogin, new Separator(), vbEmail, vbPass, new Separator(), btnLogin);
        vbLoginContainer.getChildren().add(vbLogin);
        vbLogin.setAlignment(Pos.CENTER);
        
        VBox.setVgrow(vbLoginContainer, Priority.ALWAYS);
        vbLoginContainer.setAlignment(Pos.CENTER);
        vbLoginContainer.setStyle("-fx-background-color: #e6f2f0");
        
        //login event handler
        btnLogin.setOnAction(event -> {
              User user = null;
      String email = tfEmail.getText();
     try {
                    DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getUserByEmail");
                    System.out.println("reasult set abt to be here");
                    user  =   serv.getUserByEmail(email);
                    System.out.println(user.getFullName()); 
                } catch (NotBoundException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                }
            String password = pfPassword.getText();
            CurrentUser cu = new CurrentUser(user);
            if(user.getPassword().equals(password)) {
                            UniversityTeachersEvaluation.currentUser = cu;
                            SceneChanger sc =  new SceneChanger();

                            NavDrawer navDrawerClass = new NavDrawer();
                            AppBar appBarClass = new AppBar();
                            HBox appBar = appBarClass.appBar();
                            VBox navDrawer = navDrawerClass.navDrawer();
                            ServicesView tv = new ServicesView();
                            ScrollPane somePane = tv.servicesView();
                            somePane.setLayoutX(160);
                            somePane.setLayoutY(53);
                            somePane.setPrefHeight(650);
                            somePane.setPrefWidth(1350); 
                            navDrawerClass.colorChanger();
                            Pane pane = new Pane();
                            pane.getChildren().addAll(appBar , navDrawer ,somePane );
                            Scene s = new Scene(pane, 1350 , 700);
                            sc.changeScene(s);
     }
        });
        
        
        return vbLoginContainer;
    }
    
   
}
