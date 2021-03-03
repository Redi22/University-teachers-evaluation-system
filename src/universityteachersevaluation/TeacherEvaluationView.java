/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
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
public class TeacherEvaluationView {
    public StackPane teacherEvaluationView(){
          ScrollPane pane =  new ScrollPane();
          StackPane mainPane = new StackPane();
  ScrollPane scrollPane = new ScrollPane();
        pane.setStyle("-fx-background-color: #e6f2f0");
        
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
        Button addTeacherBtn = new Button();
        addTeacherBtn.setLayoutX(65.0);
        addTeacherBtn.setLayoutY(280.0);
        addTeacherBtn.setMnemonicParsing(false);
//        makeAdmin.setOnAction(this::makeAdmin);
        addTeacherBtn.setPrefHeight(35.0);
        addTeacherBtn.setPrefWidth(150.0);
        addTeacherBtn.setStyle("-fx-background-color: teal;");
        addTeacherBtn.setText("Submit");
        addTeacherBtn.setTextFill(Color.valueOf("#fff8f8"));

       
 
      
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
        contentHolder.getChildren().addAll(DialogTitleBar  ,descriptionField, addTeacherBtn);
        contentHolder.setSpacing(20); 
        contentHolder.setPadding(new Insets(20 , 20 ,30 , 20));
        contentHolder.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        
        AnchorPane overlayContainer =  new AnchorPane();
        overlayContainer.setStyle("-fx-background-color: teal;");
        overlayContainer.setOpacity(0.2);
        overlayContainer.setPrefHeight(700);
        overlayContainer.setPrefWidth(1350);
        content.getChildren().addAll(overlayContainer ,contentHolder);    
        
        
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList( 
   new PieChart.Data("Iphone 5S", 13), 
   new PieChart.Data("Samsung Grand", 25), 
   new PieChart.Data("Nokia Lumia", 22)); 
        
        PieChart pieChart = new PieChart(pieChartData);
//        pieChart.setPrefSize(200, 400);
Group root1 = new Group(pieChart);
mainPane.setStyle("-fx-background-color: teal");
        //Defining the x axis               
CategoryAxis xAxis = new CategoryAxis();   
        
xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
   "Speed", "User rating", "Milage", "Safety" , "some" , "other" , "category" ,"here"))); 
xAxis.setLabel("category");  

//Defining the y axis 
NumberAxis yAxis = new NumberAxis(); 
yAxis.setLabel("score");

//Creating the Bar chart 
BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);  
barChart.setTitle("Comparison between various cars"); 
barChart.setLayoutY(0);
barChart.setLayoutX(200);
//Prepare XYChart.Series objects by setting data        
XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
series1.setName("Fiat"); 
series1.getData().add(new XYChart.Data<>("Speed", 1.0)); 
series1.getData().add(new XYChart.Data<>("User rating", 3.0)); 
series1.getData().add(new XYChart.Data<>("Milage", 5.0)); 
series1.getData().add(new XYChart.Data<>("Safety", 5.0));   
series1.getData().add(new XYChart.Data<>("some", 5.0)); 
series1.getData().add(new XYChart.Data<>("other", 5.0)); 
series1.getData().add(new XYChart.Data<>("category", 5.0)); 
series1.getData().add(new XYChart.Data<>("here", 5.0)); 
XYChart.Series<String, Number> series2 = new XYChart.Series<>(); 
series2.setName("Audi"); 
series2.getData().add(new XYChart.Data<>("Speed", 5.0)); 
series2.getData().add(new XYChart.Data<>("User rating", 6.0));  
series2.getData().add(new XYChart.Data<>("some", 5.0)); 
series2.getData().add(new XYChart.Data<>("other", 5.0)); 
series2.getData().add(new XYChart.Data<>("category", 5.0)); 
series2.getData().add(new XYChart.Data<>("here", 5.0)); 
series2.getData().add(new XYChart.Data<>("Milage", 9.0)); 
series2.getData().add(new XYChart.Data<>("Safety", 4.0));  

XYChart.Series<String, Number> series3 = new XYChart.Series<>(); 
series3.setName("Ford"); 
series3.getData().add(new XYChart.Data<>("Speed", 4.0)); 
series3.getData().add(new XYChart.Data<>("User rating", 2.0)); 
series3.getData().add(new XYChart.Data<>("Milage", 3.0)); 
series3.getData().add(new XYChart.Data<>("Safety", 6.0));
series3.getData().add(new XYChart.Data<>("some", 5.0)); 
series3.getData().add(new XYChart.Data<>("other", 5.0)); 
series3.getData().add(new XYChart.Data<>("category", 5.0)); 
series3.getData().add(new XYChart.Data<>("here", 5.0)); 
 barChart.setPrefHeight(300);     
 barChart.setPrefWidth(800); 
//xAxis.setStyle("-fx-bar-fill: red;");
//barChart.setStyle("-fx-bar-fill: red; ");
//Setting the data to bar chart        
barChart.getData().addAll(series1, series2, series3);
Group root = new Group(barChart); 


        SingleTeacherTaskView single = new SingleTeacherTaskView();
        VBox customTable = new VBox();
//        customTable.setLayoutX(220);
//        customTable.setLayoutY(400);
//        customTable.setStyle("-fx-backgroud-color: white;");
        
//        mapsContainer.getChildren().add(labelHolder);
        customTable.setStyle("-fx-background-color: white");
//        customTable.setLayoutX(0);
//        customTable.setLayoutY(400); 
//        customTable.setPrefWidth(1200);
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
        for(int i=0; i<20; i++){
            System.out.println(i);
            
        HBox some = new HBox();
        
       some.setSpacing(30);
       Label titleLabel =  new Label("Service title");       
       Label levelLabel =  new Label("Level of Education");
       Label percentLabel =  new Label("30%");
       Label descLabel = new Label("description description description description description description description description description description description description description description description description description description description description ");
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
         
//        some.setLayoutX(100);
//        some.setLayoutY(200);
        some.setPrefHeight(40); 
        Separator border =  new Separator();
        border.setOrientation(Orientation.HORIZONTAL);
        customTable.getChildren().addAll(some , border);
        }
//        customTable.getChildren().add(single.taskView()); 
        scrollPane.setPrefViewportHeight(400);
//        pane.setPrefWidth(700);
        scrollPane.setStyle("-fx-background-color: #e6f2f0;");
        
        scrollPane.setContent(customTable);
        scrollPane.setPrefWidth(1200);
        scrollPane.setLayoutY(300); 
        customTable.setPadding(new Insets(10 , 10 ,10 ,10));
        VBox scrollContent =  new VBox();
        scrollContent.getChildren().addAll(root, root1 ,customTable );
        pane.setPrefWidth(1200);
        pane.setPrefViewportHeight(650);
        pane.setPadding(new Insets(15,15,15,15));
        pane.setStyle("-fx-background-color: #e6f2f0;");
        scrollContent.setStyle("-fx-background-color: #e6f2f0;"); 
        scrollContent.setPrefWidth(1350);
        pane.setContent(scrollContent);
        mainPane.getChildren().add(pane);
        return mainPane;
    }
}
