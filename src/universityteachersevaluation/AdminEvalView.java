/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.Evaluation;
import Models.Service;
import Models.ServiceCategory;
import Models.Task;
import Models.Teacher;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TabPane;
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


//admin Dashboard view page
public class AdminEvalView {
    public StackPane teacherEvaluationView(){
        List<Task>  tasks = new ArrayList<Task>();
        ScrollPane pane =  new ScrollPane();
        StackPane mainPane = new StackPane();
        ScrollPane scrollPane = new ScrollPane();
        pane.setStyle("-fx-background-color: #e6f2f0");
        
        List<Evaluation> under = new ArrayList<Evaluation>();
        List<Evaluation> good = new ArrayList<Evaluation>();
        List<Evaluation> great = new ArrayList<Evaluation>();
        XYChart.Series<String, Number> underSerCatTasks = new XYChart.Series<>(); 
        XYChart.Series<String, Number> goodSerCatTasks = new XYChart.Series<>(); 

        XYChart.Series<String, Number> greatSerCatTasks = new XYChart.Series<>(); 

        BarChart<String, Number> barChart = null ;
    
         try {
                DatabaseServiceInterface serv = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getEvaluations");
                List<Evaluation> evals =   serv.getEvaluations();
                DatabaseServiceInterface serv2;
                serv2 = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getDoneTasks");
                List<Task> doneTasks = serv2.getDoneTasks();
                DatabaseServiceInterface serv3 = (DatabaseServiceInterface) Naming.lookup("rmi://localhost:5050/getServices"); 
                List<Service> services = serv3.getAllServices();  
                
                //xAxis for the bar graph
            CategoryAxis xAxis = new CategoryAxis();   
        ObservableList<String> categories = FXCollections.observableArrayList();
        //adding the services as a category for the bar graph
            services.forEach(service -> { 
                categories.add(service.getName());
            });
        xAxis.setCategories(categories); 
        xAxis.setLabel("category");  
        NumberAxis yAxis = new NumberAxis(); 
        yAxis.setLabel("score");

        //Creating the Bar chart 
        barChart = new BarChart<>(xAxis, yAxis);  
        barChart.setTitle("Evaluation Based On Services"); 
        barChart.setLayoutY(0);
        barChart.setLayoutX(200);
        

//checking and assigning the evaluations in the 3 categories
            evals.forEach(e -> 
                {
                   
                    if(e.getValue() <= 30){
                        
                        doneTasks.forEach(task -> {
                            if(e.getTaskId() == task.getId()){
                                services.forEach(ser ->  {
                                    if(ser.getId() == task.getServiceId()){
                                       underSerCatTasks.getData().add(new XYChart.Data<>(ser.getName().toString(), e.getValue()));
                                    }
                                });
                                under.add(e);
                            }});  
                    
                    }else if(e.getValue() <= 60){
                         doneTasks.forEach(task -> {
                            if(e.getTaskId() == task.getId()){
                                services.forEach(ser ->  {
                                    System.out.println(ser.getId());
                                    System.out.println(task.getServiceId());
                                    if(ser.getId() == task.getServiceId()){
                                       goodSerCatTasks.getData().add(new XYChart.Data<>(ser.getName(), e.getValue()));
                                    }
                                });
                                 good.add(e);
                            }});  
                    
                       
                    }else if(e.getValue() <= 100){
                         doneTasks.forEach(task -> {
                            if(e.getTaskId() == task.getId()){
                                services.forEach(ser ->  {
                                    if(ser.getId() == task.getServiceId()){
                                       greatSerCatTasks.getData().add(new XYChart.Data<>(ser.getName(),e.getValue()));
                                    }
                                });
                                great.add(e);
                            }});  
                        
                    }
                        
                });
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(UniversityTeachersEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList( 
                new PieChart.Data("Under Achievement", under.size()), 
                new PieChart.Data("Good Achievement", good.size()), 
                new PieChart.Data("Great Achievement", great.size())); 

        PieChart pieChart = new PieChart(pieChartData);
        Group root1 = new Group(pieChart);
        mainPane.setStyle("-fx-background-color: teal");
        underSerCatTasks.setName("Under Achievements");  

        goodSerCatTasks.setName("Good Achievements"); 

        greatSerCatTasks.setName("Great Achievements"); 

         barChart.setPrefHeight(300);     
         barChart.setPrefWidth(800); 

        //Setting the data to bar chart        
        barChart.getData().addAll(underSerCatTasks, goodSerCatTasks, greatSerCatTasks);
        Group root = new Group(barChart); 


        SingleTeacherTaskView single = new SingleTeacherTaskView();
       
        scrollPane.setPrefWidth(1200);
        scrollPane.setLayoutY(300); 
        VBox scrollContent =  new VBox();
        TabPane customTab = single.taskView(mainPane);

        scrollContent.getChildren().addAll(root, root1 ,customTab  );
        pane.setPrefWidth(1200);
        pane.setPrefViewportHeight(650);
        pane.setPadding(new Insets(15,15,15,15));
        pane.setStyle("-fx-background-color: #e6f2f0;");
        scrollContent.setStyle("-fx-background-color: #e6f2f0;"); 
        scrollContent.setPrefWidth(1350);
        pane.setContent(scrollContent);
        mainPane.getChildren().add(pane);
        scrollPane.setPrefViewportHeight(400);
        scrollPane.setStyle("-fx-background-color: #e6f2f0;");
        scrollPane.setContent(scrollContent); 
        
        
        return mainPane;
    }
}
