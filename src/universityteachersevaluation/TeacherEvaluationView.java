/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.util.Arrays;
import javafx.collections.FXCollections;
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
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author kk
 */
public class TeacherEvaluationView {
    public ScrollPane teacherEvaluationView(){
          ScrollPane pane =  new ScrollPane();
    
  ScrollPane scrollPane = new ScrollPane();
        pane.setStyle("-fx-background-color: #e6f2f0");
        
        
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
        HBox some = single.taskView();
        some.setAlignment(Pos.CENTER); 
        some.setLayoutX(100);
        some.setLayoutY(200);
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
        customTable.setPadding(new Insets(10 , 10 ,60 ,10));
        VBox scrollContent =  new VBox();
        scrollContent.getChildren().addAll(root, customTable );
        pane.setPrefWidth(1200);
        pane.setPrefViewportHeight(650);
//        pane.setLayoutY(300); 
        pane.setContent(scrollContent);
        return pane;
    }
}
