/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.LevelOfEducation;
import Models.Teacher;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.table.TableModel;

/**
 *
 * @author kk
 */
public class TeachersView  {
     TextField searchField = null;
    ObservableList<Teacher> listView = FXCollections.observableArrayList();
    public StackPane teacherView(){
        String fullname;
      StackPane mainPane = new StackPane();
     Pane pane =  new Pane();
     searchField = new TextField();
        searchField.setPromptText("serach here");
        searchField.setPrefHeight(40.0); 
        searchField.setPrefWidth(300.0);
        searchField.setPadding(new Insets(5,5,5,5));
        
    
            pane.setStyle("-fx-background-color: #e6f2f0");
            
            AnchorPane content =  new AnchorPane();
            Label label3 = new Label();
            label3.setLayoutX(37.0);
        label3.setLayoutY(14.0);
        label3.setPrefHeight(34.0);
        label3.setPrefWidth(241.0);
        label3.setStyle("-fx-background-color: white;");
        label3.setText("Teacher Registration Form");
        label3.setFont(new Font(16.0));
        ToggleGroup genderGroup = new ToggleGroup();

        TextField fullNameField =  new TextField();
        fullNameField.setLayoutX(37.0);
        fullNameField.setLayoutY(55.0);
        fullNameField.setPrefHeight(34.0);
        fullNameField.setPrefWidth(200.0);
        fullNameField.setPromptText("Full Name");
        
        LevelOfEdCombo com = new LevelOfEdCombo();
        ComboBox levelOfEd = com.combo(); 

//        levelOfEd.getItems().addAll("Masters" , "PHD");
        levelOfEd.setLayoutX(37.0);
        levelOfEd.setLayoutY(200.0);
        levelOfEd.setPrefHeight(34.0);
        levelOfEd.setPrefWidth(200.0);
        levelOfEd.setPromptText("Level of Education");
        Button addTeacherBtn = new Button();
       
        addTeacherBtn.setMnemonicParsing(false);
       
        addTeacherBtn.setPrefHeight(35.0);
        addTeacherBtn.setPrefWidth(100.0);
        addTeacherBtn.setStyle("-fx-background-color: teal;");
        addTeacherBtn.setText("Register");
        addTeacherBtn.setTextFill(Color.valueOf("#fff8f8"));

        TextField phoneField =  new TextField();
        phoneField.setLayoutX(37.0);
        phoneField.setLayoutY(150.0);
        phoneField.setPrefHeight(34.0);
        phoneField.setPrefWidth(200.0);
        phoneField.setPromptText("Phone");

       
 
        TextField emailField =  new TextField();
        emailField.setLayoutX(37.0);
        emailField.setLayoutY(100.0);
        emailField.setPrefHeight(34.0);
        emailField.setPrefWidth(200.0);
        emailField.setPromptText("Email");
        
        
        RadioButton male = new RadioButton("male");
        RadioButton female = new RadioButton("female");
//        male.setToggleGroup(genderGroup);
//        female.setToggleGroup(genderGroup);
        
        
        Button deleteBtn =  new Button(); 
        deleteBtn.setLayoutX(450.0);
        deleteBtn.setLayoutY(10.0);
        deleteBtn.setMnemonicParsing(false); 
        deleteBtn.setPrefHeight(35.0);
        deleteBtn.setPrefWidth(39.0);
        deleteBtn.setStyle("-fx-background-color: #e6fcfb");
        deleteBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        deleteBtn.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
//                        mainPane.getChildren().add(content);
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

        
        
        FontAwesomeIcon fontAwesomeIcon7 = new FontAwesomeIcon();
        fontAwesomeIcon7.setFill(Color.TEAL);
        fontAwesomeIcon7.setLayoutX(705.0);
        fontAwesomeIcon7.setSize("2em");
        fontAwesomeIcon7.setIconName("EDIT");
        fontAwesomeIcon7.setLayoutY(38.0);
        deleteBtn.setGraphic(fontAwesomeIcon6);
        editBtn.setGraphic(fontAwesomeIcon7);
        
        
        HBox btnHolder = new HBox();
        btnHolder.setLayoutX(30.0);
        btnHolder.setLayoutY(290.0);
        btnHolder.setSpacing(15);
        btnHolder.getChildren().addAll(addTeacherBtn  , editBtn ,deleteBtn );
        HBox genderContainer = new HBox();
        genderContainer.getChildren().addAll(male , female);
        genderContainer.setLayoutY(250);
        genderContainer.setSpacing(10);
        genderContainer.setLayoutX(40);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#b2d8d8"));
        content.setEffect(dropShadow);
        content.setLayoutX(900.0);
        content.setLayoutY(100.0);
        content.setPrefHeight(350.0);
        content.setPrefWidth(250.0);

       
        content.getChildren().addAll(label3, fullNameField , btnHolder , phoneField  , emailField  , levelOfEd , genderContainer);
        content.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        pane.getChildren().addAll(content, searchField);
//        pane.setRight(new HBox());

            
        
        
       TableView teachersTable = new TableView();
       TableColumn fullNameColumn =  new TableColumn();
       TableColumn idColumn = new TableColumn();
       TableColumn emailColumn =  new TableColumn();
       TableColumn phoneColumn = new TableColumn();
       TableColumn levelOfEdColumn = new TableColumn();
       TableColumn genderColumn = new TableColumn();
        
        
       idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
       fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
       emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
       phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
       levelOfEdColumn.setCellValueFactory(new PropertyValueFactory<>("levelName"));
       genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
       
        teachersTable.setLayoutX(20.0);
        teachersTable.setLayoutY(50.0);
        teachersTable.setPrefHeight(600.0);
        teachersTable.setPrefWidth(850.0);
        teachersTable.setStyle("-fx-border-radius: 20px");
         idColumn.setPrefWidth(50.0);
        idColumn.setText("ID ");

        fullNameColumn.setPrefWidth(150.0);
        fullNameColumn.setText("Full Name");

        emailColumn.setPrefWidth(130.0);
        emailColumn.setText("Email");

        phoneColumn.setMinWidth(0.0);
        phoneColumn.setPrefWidth(120.0);
        phoneColumn.setText("Phone");

        levelOfEdColumn.setMinWidth(0.0);
        levelOfEdColumn.setPrefWidth(160.0);
        levelOfEdColumn.setText("Level Of Education");

        genderColumn.setMinWidth(0.0);
        genderColumn.setPrefWidth(110.0);
        genderColumn.setText("Gender"); 
        teachersTable.getColumns().add(idColumn);
        teachersTable.getColumns().add(fullNameColumn);
        teachersTable.getColumns().add(emailColumn);
        teachersTable.getColumns().add(phoneColumn);
        teachersTable.getColumns().add(levelOfEdColumn);
        teachersTable.getColumns().add(genderColumn);
    // 
        
         addTeacherBtn.setOnAction(event -> {
            String fullName = fullNameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            int level = com.getLevel().getId();
            Teacher teacher = new Teacher(fullName , email , phone , "male", level );
            try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/addTeacher");
                serv.addTeacher(teacher);
                refresh();
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         
        refresh();
        teachersTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue observableValue, Object oldValue, Object newValue) -> {
    //this will get the selected row and return you a model. 
    if(teachersTable.getSelectionModel().getSelectedItem() != null){
        //cast the returned model to your model and do whatever you want with it
        Teacher t = (Teacher) teachersTable.getSelectionModel().getSelectedItem();
        fullNameField.setText(t.getFullName());
        emailField.setText(t.getEmail());
        phoneField.setText(t.getPhone());
        com.setLevel(t.getLevelId());
        LevelOfEducation lev = com.getLevel();
//        levelOfEd.selectionModelProperty().setValue(lev);
         
        levelOfEd.setValue(lev);
        
        System.out.println("gender " + t.getGender());
        if(t.getGender().equals("male")){
            male.setSelected(true); 
            female.setSelected(false);
        }else{
            female.setSelected(true); 
            male.setSelected(false);
        }
        
        
        
    }
});
        teachersTable.setItems(listView);

    editBtn.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        String fullName = fullNameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String gender;
            if(male.isSelected())
            {
             gender  = "male";
            }else{
                gender = "female";
            }
            int level = com.getLevel().getId();
            Teacher t = (Teacher) teachersTable.getSelectionModel().getSelectedItem();
            Teacher selTeacher = new Teacher(t.getId(),fullName , email , phone ,gender , level);
            try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/editTeacher");
                serv.editTeacher(selTeacher);
                refresh();
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
                            }
                });
    
        Button button4 = new Button();
        button4.setMnemonicParsing(false);
        button4.setLayoutY(400);
        button4.setLayoutX(120);
        button4.setPrefHeight(50.0);
        button4.setPrefWidth(50.0); 
        button4.setStyle("-fx-background-color: white;");
        FontAwesomeIcon cancelBtn = new FontAwesomeIcon();
        cancelBtn.setIconName("REMOVE"); 
        cancelBtn.setFill(Color.TEAL);

        button4.setGraphic(cancelBtn);
        button4.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));
       
    
    Pane deleteDialog = new Pane();
        VBox dialContent = new VBox();
        HBox delDialogTitleBar =  new HBox();
        delDialogTitleBar.setAlignment(Pos.CENTER);
        Label delTitle = new Label(); 
        delDialogTitleBar.setSpacing(200);
        delDialogTitleBar.getChildren().addAll(delTitle, button4);
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
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        deleteDialog.getChildren().addAll(overlayContainer , dialContent);
        
        deleteBtn.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().add(deleteDialog);
                    }
                });
        button4.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(deleteDialog);
                    }
                });
        confirmBtn.setOnAction(event -> {
            try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/deleteTeacher");
                Teacher t = (Teacher) teachersTable.getSelectionModel().getSelectedItem();
                serv.deleteTeacher(t.getId());
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.err.println("listening");
            refresh();
});
        
        pane.getChildren().add(teachersTable);
        mainPane.getChildren().add(pane);
        return mainPane;
    }
    
    public List<Teacher> getData(boolean search){
        List<Teacher> teachs = null;
        if(!search){
                try {
                    DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getTeachers");
                    System.out.println("reasult set abt to be here");
                    teachs =   serv.getTeachers();
                    System.out.println("reasult set here");
                } catch (NotBoundException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else{
                try {
                    DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/searchTeachers");
                    System.out.println("reasult set abt to be here");
                    teachs =   serv.searchTeachers(searchField.getText());
                    System.out.println("reasult set here");
                } catch (NotBoundException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(TeachersView.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        return teachs;
    }
    
    public void refresh(){
                System.out.println("abt to create service");
                listView.clear();
                boolean search = false;
                if(searchField.getText() != null){
                    search = true;
                }
                List<Teacher> teachs = getData(search);
                listView.addAll(teachs); 
                System.out.println("added");
       
    }
}
