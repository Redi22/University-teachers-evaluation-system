/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.Evaluation;
import Models.Task;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
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
public class SingleTeacherTaskView {
    public TabPane taskView(StackPane mainPane){
        TabPane tabView =  new TabPane();
        VBox customDone = UniversityTeachersEvaluation.currentUser.getUser().isAdmin() ? doneTaskView(mainPane) : doneTeacherTaskView(mainPane);
        VBox customAssigned = UniversityTeachersEvaluation.currentUser.getUser().isAdmin() ? assignedTaskView(mainPane) : assignedTeacherTaskView(mainPane); 
        tabView.setStyle("-fx-background-radius: 18; -fx-background-color: #e6fcfb");
        Tab tab1 = new Tab("Assigned Tasks", customAssigned );
        Tab tab2 = new Tab("Done Tasks"  ,customDone );
        tabView.getTabs().add(tab1);
        tabView.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tabView.getTabs().add(tab2);
        return tabView;
    }
    
    
    
    
     public VBox doneTaskView(StackPane mainPane){
     List<Task> tasks = new ArrayList<Task>();
        VBox customTable = new VBox();
        VBox contentHolder =  new VBox();
        Pane content =  new Pane();
        Label label5 = new Label();
        label5.setLayoutX(37.0);
        label5.setLayoutY(14.0);
        label5.setPrefHeight(34.0);
        label5.setPrefWidth(241.0);
        label5.setStyle("-fx-background-color: white;");
        label5.setText("Add Comment on the matter");
        label5.setFont(new Font(16.0));

       
        TextArea descriptionField = new TextArea();
        descriptionField.setLayoutX(37.0);
        descriptionField.setLayoutY(100.0);
        descriptionField.setPrefHeight(200.0);
        descriptionField.setPrefWidth(350.0);
        descriptionField.setPromptText("Comment");
        Button submitBtn = new Button(); 
        submitBtn.setLayoutX(65.0);
        submitBtn.setLayoutY(280.0);
        submitBtn.setMnemonicParsing(false);
//        makeAdmin.setOnAction(this::makeAdmin);
        submitBtn.setPrefHeight(35.0); 
        submitBtn.setPrefWidth(150.0);
        submitBtn.setStyle("-fx-background-color: teal;");
        submitBtn.setText("Submit");
        submitBtn.setTextFill(Color.valueOf("#fff8f8"));

       
 
      
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
        button4.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                    }
                });
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#b2d8d8"));
        contentHolder.setEffect(dropShadow);
        contentHolder.setLayoutX(430.0);
        contentHolder.setLayoutY(130.0);
        contentHolder.setPrefHeight(400);
        contentHolder.setPrefWidth(300);
 
        mainPane.setAlignment(Pos.CENTER);
       HBox DialogTitleBar =  new HBox();
       DialogTitleBar.setAlignment(Pos.CENTER);
       contentHolder.setAlignment(Pos.CENTER); 
       DialogTitleBar.getChildren().addAll(label5, button4);
        contentHolder.getChildren().addAll(DialogTitleBar  ,descriptionField, submitBtn);
        contentHolder.setSpacing(20); 
        contentHolder.setPadding(new Insets(20 , 20 ,30 , 20));
        contentHolder.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        content.getChildren().addAll(overlayContainer ,contentHolder);    
        
          
//        customTable.setLayoutX(220);
//        customTable.setLayoutY(400);
//        customTable.setStyle("-fx-backgroud-color: white;");
        
//        mapsContainer.getChildren().add(labelHolder);
        customTable.setStyle("-fx-background-color: white");
//        customTable.setLayoutX(0);
//        customTable.setLayoutY(400); 
//        customTable.setPrefWidth(1200);
            HBox labelHolder = new HBox();
        Label label1 =  new Label("Task Name");       
        Label label2 =  new Label("Service Name");
        Label label3 =  new Label("Percentile");
        Label label4 = new Label("Description");
        label2.setFont(new Font(16.0));
        label1.setFont(new Font(16.0));
        label3.setFont(new Font(16.0));
        label4.setFont(new Font(16.0));
        label4.setPrefWidth(600);
        label4.setStyle("-fx-font-weight: bold ");
        label1.setStyle("-fx-font-weight: bold ");
        label2.setStyle("-fx-font-weight: bold ");
        label3.setStyle("-fx-font-weight: bold ");
        labelHolder.getChildren().addAll(label1 , label2, label4 , label3);
        labelHolder.setSpacing(20);
        customTable.getChildren().add(labelHolder);
        customTable.setPadding(new Insets(20));
        
        try {
            System.out.println("abt to create service");
            DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getDoneTasks");
            System.out.println("reasult set abt to be here");
            tasks =   serv.getDoneTasks(); 
            System.out.println("reasult set here");
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Task singleTask : tasks) {

        HBox some = new HBox();
        
       some.setSpacing(30);
       Label titleLabel =  new Label();
       titleLabel.setText(singleTask.getTitle());
       Label levelLabel =  new Label();
       levelLabel.setText(singleTask.getLevelName());
       Label percentLabel =  new Label();
       percentLabel.setText(String.valueOf(singleTask.getPercentile()));
       Label descLabel = new Label();
       descLabel.setText(singleTask.getDescription());
       descLabel.setWrapText(true); 
       descLabel.setPrefHeight(100); 
       descLabel.setPrefWidth(600);
       levelLabel.setFont(new Font(16.0));
       titleLabel.setFont(new Font(16.0));
       percentLabel.setFont(new Font(16.0));
       percentLabel.setStyle("-fx-background-radius: 18; -fx-background-color: #e6fcfb");
       percentLabel.setPadding(new Insets(5 ,15 ,5 ,15));
      
        FontAwesomeIcon fontAwesomeIcon6 = new FontAwesomeIcon();
        fontAwesomeIcon6.setLayoutX(762.0);
        fontAwesomeIcon6.setLayoutY(38.0);
        fontAwesomeIcon6.setSize("1.5em");
        fontAwesomeIcon6.setIconName("CHECK");
        fontAwesomeIcon6.setFill(Color.WHITE);
        
       
         
       some.getChildren().addAll(titleLabel, levelLabel ,descLabel, percentLabel  );
         
//        some.setLayoutX(100);
//        some.setLayoutY(200);
        some.setPrefHeight(40); 
        Separator border =  new Separator();
        border.setOrientation(Orientation.HORIZONTAL);
        customTable.getChildren().addAll(some , border);
        }
//        customTable.getChildren().add(single.taskView()); 
        
        submitBtn.setOnAction(event -> {
//                String name = rs.getString(4);
//                int teacherId = rs.getInt(5);
//                String description = rs.getString(6);
//                double perc = rs.getDouble(3);
//                boolean comp = rs.getBoolean(7); 
//                int serviceId = rs.getInt(2);
//                Task task = new Task(name , description ,comp , serviceId , teacherId, perc);
//            try {
//                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/editTeacher");
////                serv.add(task);
//                refresh();
//            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
//                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
//            }
        });
        return customTable;
    }
    
    
    
    
    public VBox doneTeacherTaskView(StackPane mainPane){
     List<Task> tasks = new ArrayList<Task>();
        VBox customTable = new VBox();
        VBox contentHolder =  new VBox();
        Pane content =  new Pane();
        Label label5 = new Label();
        label5.setLayoutX(37.0);
        label5.setLayoutY(14.0);
        label5.setPrefHeight(34.0);
        label5.setPrefWidth(241.0);
        label5.setStyle("-fx-background-color: white;");
        label5.setText("Add Comment on the matter");
        label5.setFont(new Font(16.0));

       
        TextArea descriptionField = new TextArea();
        descriptionField.setLayoutX(37.0);
        descriptionField.setLayoutY(100.0);
        descriptionField.setPrefHeight(200.0);
        descriptionField.setPrefWidth(350.0);
        descriptionField.setPromptText("Comment");
        Button submitBtn = new Button(); 
        submitBtn.setLayoutX(65.0);
        submitBtn.setLayoutY(280.0);
        submitBtn.setMnemonicParsing(false);
//        makeAdmin.setOnAction(this::makeAdmin);
        submitBtn.setPrefHeight(35.0); 
        submitBtn.setPrefWidth(150.0);
        submitBtn.setStyle("-fx-background-color: teal;");
        submitBtn.setText("Submit");
        submitBtn.setTextFill(Color.valueOf("#fff8f8"));

       
 
      
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
        button4.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                    }
                });
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#b2d8d8"));
        contentHolder.setEffect(dropShadow);
        contentHolder.setLayoutX(430.0);
        contentHolder.setLayoutY(130.0);
        contentHolder.setPrefHeight(400);
        contentHolder.setPrefWidth(300);
 
        mainPane.setAlignment(Pos.CENTER);
       HBox DialogTitleBar =  new HBox();
       DialogTitleBar.setAlignment(Pos.CENTER);
       contentHolder.setAlignment(Pos.CENTER); 
       DialogTitleBar.getChildren().addAll(label5, button4);
        contentHolder.getChildren().addAll(DialogTitleBar  ,descriptionField, submitBtn);
        contentHolder.setSpacing(20); 
        contentHolder.setPadding(new Insets(20 , 20 ,30 , 20));
        contentHolder.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        content.getChildren().addAll(overlayContainer ,contentHolder);    
        
          
//        customTable.setLayoutX(220);
//        customTable.setLayoutY(400);
//        customTable.setStyle("-fx-backgroud-color: white;");
        
//        mapsContainer.getChildren().add(labelHolder);
        customTable.setStyle("-fx-background-color: white");
//        customTable.setLayoutX(0);
//        customTable.setLayoutY(400); 
//        customTable.setPrefWidth(1200);
            HBox labelHolder = new HBox();
        Label label1 =  new Label("Task Name");       
        Label label2 =  new Label("Service Name");
        Label label3 =  new Label("Percentile");
        Label label4 = new Label("Description");
        label2.setFont(new Font(16.0));
        label1.setFont(new Font(16.0));
        label3.setFont(new Font(16.0));
        label4.setFont(new Font(16.0));
        label4.setPrefWidth(500);
        label4.setStyle("-fx-font-weight: bold ");
        label1.setStyle("-fx-font-weight: bold ");
        label2.setStyle("-fx-font-weight: bold ");
        label3.setStyle("-fx-font-weight: bold ");
        labelHolder.getChildren().addAll(label1 , label2, label4 , label3);
        labelHolder.setSpacing(25);
        customTable.getChildren().add(labelHolder);
        customTable.setPadding(new Insets(20));
        
        try {
            System.out.println("abt to create service");
            DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getDoneTeacherTasks");
            System.out.println("reasult set abt to be here");
            tasks =   serv.getDoneTeacherTasks(UniversityTeachersEvaluation.currentUser.getUser().getTeacherId()); 
            System.out.println("reasult set here");
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Task singleTask : tasks) {

        HBox some = new HBox();
        
       some.setSpacing(30);
       Label titleLabel =  new Label();
       titleLabel.setText(singleTask.getTitle());
       Label levelLabel =  new Label();
       levelLabel.setText(singleTask.getLevelName());
       Label percentLabel =  new Label();
       percentLabel.setText(String.valueOf(singleTask.getPercentile()));
       Label descLabel = new Label();
       descLabel.setText(singleTask.getDescription());
       descLabel.setWrapText(true); 
       descLabel.setPrefHeight(100); 
       descLabel.setPrefWidth(600);
       levelLabel.setFont(new Font(16.0));
       titleLabel.setFont(new Font(16.0));
       percentLabel.setFont(new Font(16.0));
       percentLabel.setStyle("-fx-background-radius: 18; -fx-background-color: #e6fcfb");
       percentLabel.setPadding(new Insets(5 ,15 ,5 ,15));
      
        FontAwesomeIcon fontAwesomeIcon6 = new FontAwesomeIcon();
        fontAwesomeIcon6.setLayoutX(762.0);
        fontAwesomeIcon6.setLayoutY(38.0);
        fontAwesomeIcon6.setSize("1.5em");
        fontAwesomeIcon6.setIconName("CHECK");
        fontAwesomeIcon6.setFill(Color.WHITE);
        
       
         
       some.getChildren().addAll(titleLabel, levelLabel ,descLabel, percentLabel  );
         
//        some.setLayoutX(100);
//        some.setLayoutY(200);
        some.setPrefHeight(40); 
        Separator border =  new Separator();
        border.setOrientation(Orientation.HORIZONTAL);
        customTable.getChildren().addAll(some , border);
        }
//        customTable.getChildren().add(single.taskView()); 
        
        submitBtn.setOnAction(event -> {
//                String name = rs.getString(4);
//                int teacherId = rs.getInt(5);
//                String description = rs.getString(6);
//                double perc = rs.getDouble(3);
//                boolean comp = rs.getBoolean(7); 
//                int serviceId = rs.getInt(2);
//                Task task = new Task(name , description ,comp , serviceId , teacherId, perc);
//            try {
//                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/editTeacher");
////                serv.add(task);
//                refresh();
//            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
//                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
//            }
        });
        return customTable;
    }
    
    
    
    public VBox assignedTeacherTaskView(StackPane mainPane){
     List<Task> tasks = new ArrayList<Task>();
          VBox customTable = new VBox();
          
          VBox contentHolder =  new VBox();
        Pane content =  new Pane();
        Label label5 = new Label();
        label5.setLayoutX(37.0);
        label5.setLayoutY(14.0);
        label5.setPrefHeight(34.0);
        label5.setPrefWidth(241.0);
        label5.setStyle("-fx-background-color: white;");
        label5.setText("Add Comment on the matter");
        label5.setFont(new Font(16.0));

       
        TextArea descriptionField = new TextArea();
        descriptionField.setLayoutX(37.0);
        descriptionField.setLayoutY(100.0);
        descriptionField.setPrefHeight(200.0);
        descriptionField.setPrefWidth(350.0);
        descriptionField.setPromptText("Comment");
        Button submitBtn = new Button(); 
        submitBtn.setLayoutX(65.0);
        submitBtn.setLayoutY(280.0);
        submitBtn.setMnemonicParsing(false);
//        makeAdmin.setOnAction(this::makeAdmin);
        submitBtn.setPrefHeight(35.0); 
        submitBtn.setPrefWidth(150.0);
        submitBtn.setStyle("-fx-background-color: teal;");
        submitBtn.setText("Submit");
        submitBtn.setTextFill(Color.valueOf("#fff8f8"));

       
 
      
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
        button4.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                    }
                });
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#b2d8d8"));
        contentHolder.setEffect(dropShadow);
        contentHolder.setLayoutX(430.0);
        contentHolder.setLayoutY(130.0);
        contentHolder.setPrefHeight(400);
        contentHolder.setPrefWidth(300);
 
        mainPane.setAlignment(Pos.CENTER);
       HBox DialogTitleBar =  new HBox();
       DialogTitleBar.setAlignment(Pos.CENTER);
       contentHolder.setAlignment(Pos.CENTER); 
       DialogTitleBar.getChildren().addAll(label5, button4);
        contentHolder.getChildren().addAll(DialogTitleBar  ,descriptionField, submitBtn);
        contentHolder.setSpacing(20); 
        contentHolder.setPadding(new Insets(20 , 20 ,30 , 20));
        contentHolder.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        content.getChildren().addAll(overlayContainer ,contentHolder);    
        

        customTable.setStyle("-fx-background-color: white");

            HBox labelHolder = new HBox();
        Label label1 =  new Label("Task Name");       
        Label label2 =  new Label("Service Name");
        Label label3 =  new Label("Percentile");
        Label label4 = new Label("Description");
        label2.setFont(new Font(16.0));
        label1.setFont(new Font(16.0));
        label3.setFont(new Font(16.0));
        label4.setFont(new Font(16.0));
        label4.setPrefWidth(500);
        label4.setStyle("-fx-font-weight: bold ");
        label1.setStyle("-fx-font-weight: bold ");
        label2.setStyle("-fx-font-weight: bold ");
        label3.setStyle("-fx-font-weight: bold ");
        labelHolder.getChildren().addAll(label1 , label2, label4 , label3);
        labelHolder.setSpacing(25);
        customTable.getChildren().add(labelHolder);
        customTable.setPadding(new Insets(20));
        
        try {
            System.out.println("abt to create service");
            DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getAsssignTeacherTasks");
            System.out.println("reasult set abt to be here");
            tasks =   serv.getAssignedTeacherTasks(UniversityTeachersEvaluation.currentUser.getUser().getTeacherId());
            System.out.println(tasks.size());
             
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Task singleTask : tasks) {

        HBox some = new HBox();
        
       some.setSpacing(30);
       Label titleLabel =  new Label();
       titleLabel.setText(singleTask.getTitle());
       Label levelLabel =  new Label();
       levelLabel.setText(singleTask.getLevelName());
       Label percentLabel =  new Label();
       percentLabel.setText(String.valueOf(singleTask.getPercentile()));
       Label descLabel = new Label();
       descLabel.setText(singleTask.getDescription());
       descLabel.setWrapText(true); 
       descLabel.setPrefHeight(100); 
       descLabel.setPrefWidth(600);
       levelLabel.setFont(new Font(16.0));
       titleLabel.setFont(new Font(16.0));
       percentLabel.setFont(new Font(16.0));
       percentLabel.setStyle("-fx-background-radius: 18; -fx-background-color: #e6fcfb");
       percentLabel.setPadding(new Insets(5 ,15 ,5 ,15));
        Button doneBtn =  new Button(); 
        doneBtn.setLayoutX(450.0);
        doneBtn.setLayoutY(10.0);
        doneBtn.setMnemonicParsing(false);
        doneBtn.setPrefHeight(30.0);
        doneBtn.setPrefWidth(80.0); 
        doneBtn.setText("Done");
        doneBtn.setStyle("-fx-background-color: teal");
        doneBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        FontAwesomeIcon fontAwesomeIcon6 = new FontAwesomeIcon();
        fontAwesomeIcon6.setLayoutX(762.0);
        fontAwesomeIcon6.setLayoutY(38.0);
        fontAwesomeIcon6.setSize("1.5em");
        fontAwesomeIcon6.setIconName("CHECK");
        fontAwesomeIcon6.setFill(Color.WHITE);
        doneBtn.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().add(content);
                    }
                });
//        
       
        doneBtn.setGraphic(fontAwesomeIcon6);
         
       some.getChildren().addAll(titleLabel, levelLabel ,descLabel, percentLabel , doneBtn );
    
        some.setPrefHeight(40); 
        Separator border =  new Separator();
        border.setOrientation(Orientation.HORIZONTAL);
        customTable.getChildren().addAll(some , border);
        
        
        submitBtn.setOnAction(event -> {
                String comment = descriptionField.getText();
                double val = singleTask.getPercentile();
                int taskId = singleTask.getId();
                Evaluation eval = new Evaluation(comment , val ,taskId );
                mainPane.getChildren().remove(content);

            try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/addEvaluation");
                serv.addEvaluation(eval);
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        }
        
        
        return customTable;
    }
    
    
    
    public VBox assignedTaskView(StackPane mainPane){
     List<Task> tasks = new ArrayList<Task>();
          VBox customTable = new VBox();
          
          VBox contentHolder =  new VBox();
        Pane content =  new Pane();
        Label label5 = new Label();
        label5.setLayoutX(37.0);
        label5.setLayoutY(14.0);
        label5.setPrefHeight(34.0);
        label5.setPrefWidth(241.0);
        label5.setStyle("-fx-background-color: white;");
        label5.setText("Add Comment on the matter");
        label5.setFont(new Font(16.0));

       
        TextArea descriptionField = new TextArea();
        descriptionField.setLayoutX(37.0);
        descriptionField.setLayoutY(100.0);
        descriptionField.setPrefHeight(200.0);
        descriptionField.setPrefWidth(350.0);
        descriptionField.setPromptText("Comment");
        Button submitBtn = new Button(); 
        submitBtn.setLayoutX(65.0);
        submitBtn.setLayoutY(280.0);
        submitBtn.setMnemonicParsing(false);
//        makeAdmin.setOnAction(this::makeAdmin);
        submitBtn.setPrefHeight(35.0); 
        submitBtn.setPrefWidth(150.0);
        submitBtn.setStyle("-fx-background-color: teal;");
        submitBtn.setText("Submit");
        submitBtn.setTextFill(Color.valueOf("#fff8f8"));

       
 
      
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
        button4.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().remove(content);
                    }
                });
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#b2d8d8"));
        contentHolder.setEffect(dropShadow);
        contentHolder.setLayoutX(430.0);
        contentHolder.setLayoutY(130.0);
        contentHolder.setPrefHeight(400);
        contentHolder.setPrefWidth(300);
 
        mainPane.setAlignment(Pos.CENTER);
       HBox DialogTitleBar =  new HBox();
       DialogTitleBar.setAlignment(Pos.CENTER);
       contentHolder.setAlignment(Pos.CENTER); 
       DialogTitleBar.getChildren().addAll(label5, button4);
        contentHolder.getChildren().addAll(DialogTitleBar  ,descriptionField, submitBtn);
        contentHolder.setSpacing(20); 
        contentHolder.setPadding(new Insets(20 , 20 ,30 , 20));
        contentHolder.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        content.getChildren().addAll(overlayContainer ,contentHolder);    
      
        customTable.setStyle("-fx-background-color: white");

            HBox labelHolder = new HBox();
        Label label1 =  new Label("Service title");       
        Label label2 =  new Label("Level of Education");
        Label label3 =  new Label("Percentile");
        Label label4 = new Label("Description");
        label2.setFont(new Font(16.0));
        label1.setFont(new Font(16.0));
        label3.setFont(new Font(16.0));
        label4.setFont(new Font(16.0));
        label4.setPrefWidth(600);
        label4.setStyle("-fx-font-weight: bold ");
        label1.setStyle("-fx-font-weight: bold ");
        label2.setStyle("-fx-font-weight: bold ");
        label3.setStyle("-fx-font-weight: bold ");
        labelHolder.getChildren().addAll(label1 , label2, label4 , label3);
        labelHolder.setSpacing(20);
        customTable.getChildren().add(labelHolder);
        customTable.setPadding(new Insets(20));
        
        try {
            System.out.println("abt to create service");
            DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getAssignedTasks");
            System.out.println("reasult set abt to be here");
            tasks =   serv.getAssignedTasks();
            System.out.println(tasks.size());
             
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Task singleTask : tasks) {

        HBox some = new HBox();
        
       some.setSpacing(30);
       Label titleLabel =  new Label();
       titleLabel.setText(singleTask.getTitle());
       Label levelLabel =  new Label();
       levelLabel.setText(singleTask.getLevelName());
       Label percentLabel =  new Label();
       percentLabel.setText(String.valueOf(singleTask.getPercentile()));
       Label descLabel = new Label();
       descLabel.setText(singleTask.getDescription());
       descLabel.setWrapText(true); 
       descLabel.setPrefHeight(100); 
       descLabel.setPrefWidth(600);
       levelLabel.setFont(new Font(16.0));
       titleLabel.setFont(new Font(16.0));
       percentLabel.setFont(new Font(16.0));
       percentLabel.setStyle("-fx-background-radius: 18; -fx-background-color: #e6fcfb");
       percentLabel.setPadding(new Insets(5 ,15 ,5 ,15));
        Button doneBtn =  new Button(); 
        doneBtn.setLayoutX(450.0);
        doneBtn.setLayoutY(10.0);
        doneBtn.setMnemonicParsing(false);
        doneBtn.setPrefHeight(30.0);
        doneBtn.setPrefWidth(80.0); 
        doneBtn.setText("Done");
        doneBtn.setStyle("-fx-background-color: teal");
        doneBtn.setTextFill(javafx.scene.paint.Color.valueOf("#fff8f8"));

        FontAwesomeIcon fontAwesomeIcon6 = new FontAwesomeIcon();
        fontAwesomeIcon6.setLayoutX(762.0);
        fontAwesomeIcon6.setLayoutY(38.0);
        fontAwesomeIcon6.setSize("1.5em");
        fontAwesomeIcon6.setIconName("CHECK");
        fontAwesomeIcon6.setFill(Color.WHITE);
        doneBtn.setOnAction(
                new  EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        mainPane.getChildren().add(content);
                    }
                });
//        
       
        doneBtn.setGraphic(fontAwesomeIcon6);
         
       some.getChildren().addAll(titleLabel, levelLabel ,descLabel, percentLabel );
       
        some.setPrefHeight(40); 
        Separator border =  new Separator();
        border.setOrientation(Orientation.HORIZONTAL);
        customTable.getChildren().addAll(some , border);
        
        
        submitBtn.setOnAction(event -> {
                String comment = descriptionField.getText();
                double val = singleTask.getPercentile();
                int taskId = singleTask.getId();
                Evaluation eval = new Evaluation(comment , val ,taskId );
                mainPane.getChildren().remove(content);

            try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/addEvaluation");
                serv.addEvaluation(eval);
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        }
        
        
        return customTable;
    }
    
}
