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

//class for storing logged in current user information 
public class CurrentUser {
    private User user = null;

    public User getUser() {
        return user;
    }

    public CurrentUser(User user) {
        this.user = user;
    }
 public CurrentUser() {
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}
