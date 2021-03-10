/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.Service;
import Models.Task;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author kk
 */


//mapped view / service view component view
public class SingleMappedServiceView {
    
    public HBox mappedServiceView(Service s , StackPane mainPane){
       HBox pane =  new HBox();
       pane.setSpacing(30);
       VBox contentHolder =  new VBox();
    
        Pane content =  new Pane();
        
        TextField searchField = new TextField();
        searchField.setPromptText("serach here");
        searchField.setPrefHeight(40.0);
        searchField.setPrefWidth(300.0);
        Label label5 = new Label();
        label5.setLayoutX(37.0);
        label5.setLayoutY(14.0);
        label5.setPrefHeight(34.0);
        label5.setPrefWidth(241.0);
        label5.setStyle("-fx-background-color: white;");
        label5.setText("Service Registration");
        label5.setFont(new Font(16.0));

        TextField nameField =  new TextField();
        nameField.setLayoutX(37.0);
        nameField.setLayoutY(150.0); 
        nameField.setPrefHeight(40.0);
        nameField.setPrefWidth(300.0);
        nameField.setPromptText("Name");

        TextArea descriptionField = new TextArea();
        descriptionField.setLayoutX(37.0);
        descriptionField.setLayoutY(200.0);
        descriptionField.setPrefHeight(120.0);
        descriptionField.setWrapText(true); 
        descriptionField.setPrefWidth(300.0);
        descriptionField.setPromptText("Description");
        Button addService = new Button();
        addService.setLayoutX(65.0); 
        addService.setLayoutY(280.0);
        addService.setMnemonicParsing(false);
        addService.setPrefHeight(35.0);
        addService.setPrefWidth(150.0);
        addService.setStyle("-fx-background-color: teal;");
        addService.setText("Register");
        addService.setTextFill(Color.valueOf("#fff8f8"));

        addService.setOnAction(event -> {
            String name = nameField.getText();
            String desc = descriptionField.getText();
            Service servi = new Service(s.getId() , name , desc , s.getPercentile() , s.getLevelId() , s.getServiceCategoryId(), s.getServiceName());
             try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/editService");
                 System.out.println("service created");
                serv.editService(servi); 
                System.out.println("service done");
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        TextField percentileField =  new TextField();
        percentileField.setLayoutX(37.0);
        percentileField.setLayoutY(55.0);
        percentileField.setPrefHeight(40.0);
        percentileField.setPrefWidth(300.0);
        percentileField.setPromptText("Percentile");

       
 
        ComboBox levelOfEdField =  new ComboBox();
        levelOfEdField.getItems().addAll("Masters" , "PHD");
       
        levelOfEdField.setPrefHeight(40.0);
        levelOfEdField.setPrefWidth(400.0);
        levelOfEdField.setPromptText("Level Of Education");
        
        Button button4 = new Button();
        
        button4.setPrefHeight(50.0);
        button4.setPrefWidth(50.0); 
        button4.setStyle("-fx-background-color: white;");
        Button button5 = new Button();
        
        button5.setPrefHeight(50.0);
        button5.setPrefWidth(50.0); 
        button5.setStyle("-fx-background-color: white;");
        
         Button button6 = new Button();
        
        button6.setPrefHeight(50.0);
        button6.setPrefWidth(50.0); 
        button6.setStyle("-fx-background-color: white;");
        FontAwesomeIcon cancelBtn = new FontAwesomeIcon();
        cancelBtn.setIconName("REMOVE"); 
        cancelBtn.setFill(Color.TEAL);

        button4.setGraphic(cancelBtn);
        button4.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
       
        button5.setGraphic(cancelBtn);
        button5.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
       
        button6.setGraphic(cancelBtn);
        button6.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#b2d8d8"));
        contentHolder.setEffect(dropShadow);
        contentHolder.setLayoutX(430.0);
        contentHolder.setLayoutY(130.0);
        contentHolder.setPrefHeight(400);
        contentHolder.setPrefWidth(350);
 
       HBox DialogTitleBar =  new HBox();
       contentHolder.setAlignment(Pos.CENTER);  
       DialogTitleBar.setSpacing(10);
       DialogTitleBar.getChildren().addAll(label5, button5);
        contentHolder.getChildren().addAll(DialogTitleBar  ,nameField  ,descriptionField   ,percentileField , levelOfEdField, addService);
        contentHolder.setSpacing(20); 
        contentHolder.setPadding(new Insets(20 , 20 ,30 , 20));
        contentHolder.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        content.getChildren().addAll(overlayContainer ,contentHolder);
  
       
       
       
       pane.setPrefHeight(100);
       Label label1 =  new Label(s.getName());       
       Label label2 =  new Label(s.getServiceName());
       Label label3 =  new Label(String.valueOf(s.getPercentile()) + "%"); 
       Label label4 = new Label(s.getDescription());
       label4.setWrapText(true); 
       label4.setPrefHeight(100); 
       label4.setPrefWidth(350); 
       label2.setFont(new Font(16.0));
       label1.setFont(new Font(16.0));
       label3.setFont(new Font(16.0));
       label3.setStyle("-fx-background-radius: 18; -fx-background-color: #e6fcfb");
       label3.setPadding(new Insets(5 ,15 ,5 ,15));
        Button deleteBtn =  new Button(); 
        deleteBtn.setLayoutX(450.0);
        deleteBtn.setLayoutY(10.0);
        deleteBtn.setMnemonicParsing(false); 
        deleteBtn.setPrefHeight(35.0);
        deleteBtn.setPrefWidth(39.0);
        deleteBtn.setStyle("-fx-background-color: #e6fcfb");
        deleteBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        Pane deleteDialog = new Pane();
        VBox dialContent = new VBox();
        HBox delDialogTitleBar =  new HBox();
       delDialogTitleBar.setAlignment(Pos.CENTER);
       Label delTitle = new Label(); 
       delDialogTitleBar.setSpacing(200);
       delDialogTitleBar.getChildren().addAll(delTitle, button6);
        Label prompt = new Label();
        prompt.setText("Are you sure?");
        prompt.setFont(new Font(20.0));
        Button confirmBtn = new Button("Confirm Delete");
        confirmBtn.setStyle("-fx-background-color: teal");
        
        
        dialContent.setEffect(dropShadow);
        dialContent.setLayoutX(400.0);
        dialContent.setLayoutY(200.0);
        dialContent.setPrefHeight(200);
        dialContent.setPrefWidth(300);
        dialContent.getChildren().addAll(delDialogTitleBar , prompt , confirmBtn);
        dialContent.setSpacing(20); 
        dialContent.setPadding(new Insets(20 , 20 ,30 , 20));
        dialContent.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        dialContent.setAlignment(Pos.CENTER);
        deleteDialog.getChildren().addAll(overlayContainer , dialContent);
        
        
        
        
         Pane assignDialog = new Pane();
        VBox assginContent = new VBox();
        HBox assignDialogTitleBar =  new HBox();
       assignDialogTitleBar.setAlignment(Pos.CENTER);
       Label assignTitle = new Label("assign Task"); 
       assignDialogTitleBar.getChildren().addAll(assignTitle, button4);
        
       TextField nameField1 =  new TextField();
        nameField1.setLayoutX(37.0);
        nameField1.setLayoutY(55.0);
        nameField1.setPrefHeight(34.0);
        nameField1.setPrefWidth(200.0);
        nameField1.setPromptText("Name");
        
        TextField percField =  new TextField();
        percField.setLayoutX(37.0);
        percField.setLayoutY(55.0); 
        percField.setPrefHeight(34.0);
        percField.setPrefWidth(200.0);
        percField.setPromptText("Percentile");
        
        TeacherCombo com = new TeacherCombo();
        
        ComboBox teachersField = com.combo(); 
        
        teachersField.setPrefHeight(40.0);
        teachersField.setPrefWidth(200.0);
        teachersField.setPromptText("Teacher");
        
       TextArea descriptionField1 =  new TextArea();
       
        descriptionField1.setPrefHeight(200.0);
        descriptionField1.setPrefWidth(200.0);
        descriptionField1.setPromptText("description");
       
        Button assignFinishBtn = new Button("Assign Teacher");
        assignFinishBtn.setStyle("-fx-background-color: teal");
        assignFinishBtn.setTextFill(Color.WHITE); 
        
        Button finishBtn = new Button("Finish");
        finishBtn.setStyle("-fx-background-color: teal");
        finishBtn.setTextFill(Color.WHITE); 
        
        assginContent.setEffect(dropShadow);
        assginContent.setLayoutX(400.0);
        assginContent.setLayoutY(200.0);
        assginContent.setPrefHeight(200);
        assginContent.setPrefWidth(300);
        assginContent.getChildren().addAll(assignDialogTitleBar , teachersField , nameField1 , descriptionField1 , percentileField , finishBtn);
        assginContent.setSpacing(20); 
        assginContent.setPadding(new Insets(20 , 20 ,30 , 20));
        assginContent.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        assginContent.setAlignment(Pos.CENTER);
        assignDialog.getChildren().addAll(overlayContainer , assginContent);
        
         
        deleteBtn.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().add(deleteDialog);
                    }
                });
       
       
        
        FontAwesomeIcon fontAwesomeIcon6 = new FontAwesomeIcon();
        fontAwesomeIcon6.setLayoutX(762.0);
        fontAwesomeIcon6.setLayoutY(38.0);
        fontAwesomeIcon6.setSize("2em");
        fontAwesomeIcon6.setIconName("TRASH");
        fontAwesomeIcon6.setFill(Color.TEAL);
        
        
        Button editBtn = new Button();
        editBtn.setLayoutX(400.0);
        editBtn.setLayoutY(9.0);
        editBtn.setMnemonicParsing(false);
        editBtn.setPrefHeight(35.0);
        editBtn.setPrefWidth(39.0); 
        editBtn.setStyle("-fx-background-color: #e6fcfb;");
        editBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        editBtn.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        nameField.setText(s.getName());
                        descriptionField.setText(s.getDescription());
                        percentileField.setText(String.valueOf(s.getPercentile()));
                        mainPane.getChildren().add(content);
                    }
                });
        
        FontAwesomeIcon fontAwesomeIcon7 = new FontAwesomeIcon();
        fontAwesomeIcon7.setFill(Color.TEAL);
        fontAwesomeIcon7.setLayoutX(705.0);
        fontAwesomeIcon7.setSize("2em");
        fontAwesomeIcon7.setIconName("EDIT");
        fontAwesomeIcon7.setLayoutY(38.0);
        deleteBtn.setGraphic(fontAwesomeIcon6);
        editBtn.setGraphic(fontAwesomeIcon7);
        
         button4.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                        mainPane.getChildren().remove(assignDialog);
                        mainPane.getChildren().remove(deleteDialog);
                    }
                });
         button5.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                        mainPane.getChildren().remove(assignDialog);
                        mainPane.getChildren().remove(deleteDialog);
                    }
                });
         button6.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                        mainPane.getChildren().remove(assignDialog);
                        mainPane.getChildren().remove(deleteDialog);
                    }
                });
        confirmBtn.setOnAction(event -> {
            try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/deleteService");
                serv.deleteService(s.getId());
                mainPane.getChildren().remove(deleteDialog);

            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        assignFinishBtn.setOnAction(event -> {
                mainPane.getChildren().add(assignDialog);
        });
        finishBtn.setOnAction(event -> { 
            String name = nameField1.getText();
                int teacherId = 1;
                String description = descriptionField1.getText();
                double perc = Double.parseDouble(percentileField.getText());
                boolean comp = false;
                int serviceId = 1;
                Task task = new Task(name , description ,comp , serviceId , teacherId, perc);
                
                 
            try {
                 DatabaseServiceInterface serv1 = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getServices");
                List<Service> services = serv1.getAllServices();
                double allPercent = 0;

                for(Service ser :services){
                    allPercent += ser.getPercentile();
                }
                if(allPercent <= 100 || perc > 100 || perc <= 0){
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/addTask");
                serv.addTask(task);
                mainPane.getChildren().remove(content);
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Percentile max reached");

            Optional<ButtonType> result = alert.showAndWait();
            
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       pane.getChildren().addAll(label1, label2 ,label4, label3 );
       if(UniversityTeachersEvaluation.currentUser.getUser().isAdmin()){
            pane.getChildren().addAll(editBtn , deleteBtn ,assignFinishBtn);
        }
       return pane;
    }
}
