/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author kk
 */
public class Service {
    
    private int id;
    private String name;
    private double percentile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentile() {
        return percentile;
    }

    public void setPercentile(double percentile) {
        this.percentile = percentile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
    private String description;
    private int levelId;
    
    public Service(int id, String name , double percentile , String description , int levelId){
        this.id = id;
        this.description = description;
        this.name =  name;
        this.levelId = levelId;
        this.percentile = percentile;
    }

    

    
}
