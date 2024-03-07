/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Sources:https://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm
//ccoe528 Lectures

package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Rahul Verma
 */
public class CentralCore extends Application{
    private String usernameOwner;
    private String passwordOwner;
    TextField username = new TextField();
    TextField password = new TextField();
    Button loginButton = new Button("Login");
    Button booksButton = new Button("Books");
    Button customersButton = new Button("Customers");
    Button logoutButton = new Button("Logout");
    private User activeUser = new Owner("admin", "admin", 0); 
    
    @Override
    public void start(Stage primaryStage){
        //Scene scene = new Scene(g1, 400, 300);
        primaryStage.setTitle("Bookstore App");
        primaryStage.setScene(new Scene(ownerStart(), 400, 300));
        primaryStage.show();
        
        
        
        //final Text actiontarget = new Text();
        //g1.add(actiontarget, 1, 6);
        loginButton.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            //activeUser.username = username.getText();
            //System.out.println(activeUser.getUsername());
            if (usernameOwner.equals("admin") == true && passwordOwner.equals("admin") == true){
                System.out.println("owner");
                //primaryStage.setScene(new Scene(OwnerStartScreen(), 500, 200));
            }
            //primaryStage.setScene(new Scene(OwnerBooksScreen(), 500, 200));
            //actiontarget.setText("Sign in button pressed");
        }
        });
        
        username.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            TextField tfUsername = (TextField)e.getSource();
            activeUser.setUsername(tfUsername.getText());
            if (tfUsername.getText().equals("admin") == true){
                passwordOwner = tfUsername.getText();
            }
            //System.out.println(activeUser.getUsername());
            
            /*if (activeUser.username.equals("admin") && activeUser.password.equals("admin")){
                System.out.println("owner");
                //primaryStage.setScene(new Scene(OwnerStartScreen(), 500, 200));
            }*/
            //primaryStage.setScene(new Scene(OwnerBooksScreen(), 500, 200));
            //actiontarget.setText("Sign in button pressed");
        }
        });
        
        password.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            TextField tfPassword = (TextField)e.getSource();
            if (tfPassword.getText().equals("admin") == true){
                passwordOwner = tfPassword.getText();
            }
            //activeUser.setPassword(tfPassword.getText());
            
            /*if (activeUser.username.equals("admin") && activeUser.password.equals("admin")){
                System.out.println("owner");
                //primaryStage.setScene(new Scene(OwnerStartScreen(), 500, 200));
            }*/
            //primaryStage.setScene(new Scene(OwnerBooksScreen(), 500, 200));
            //actiontarget.setText("Sign in button pressed");
        }
        });
        
        
        
        
    }
    
    public GridPane loginPane(){
        GridPane g1 = new GridPane();
        g1.setPadding(new Insets(11, 12, 13, 14));
        g1.setHgap(5);
        g1.setVgap(5);
        
        g1.add(new Label("Username:"), 0, 1);
        
        g1.add(username, 1, 1);
        // //problem

        //TextField tfMi = new TextField();
        //tfMi.setPrefColumnCount(1);
        g1.add(new Label("Password:"), 0,2);
        
        g1.add(password, 1, 2);
        //activeUser.password = password.getText(); //problem
        
        Text title = new Text("Welcome to the BookStore App");
        g1.add(title, 0, 0, 2, 1);
        g1.add(loginButton, 2,4);
        
        return g1;
    }
    
    public GridPane ownerStart(){
        GridPane g1 = new GridPane();
        g1.setPadding(new Insets(11, 12, 13, 14));
        g1.setHgap(5);
        g1.setVgap(5);
        //Text title = new Text("Welcome to the BookStore App");
        //g1.add(title, 0, 0, 2, 1);
        
        //g1.add(new Label("Books"), 0, 1);
        //g1.add
        g1.add(booksButton, 1, 1);
        g1.add(customersButton, 1, 2);
        g1.add(logoutButton, 1, 3);        
        
        return g1;
    }
    
    public GridPane ownerBooks(){
        return null;
    }
    
    public GridPane ownerCustomers(){
        return null;
    }    
    
    public GridPane customersStart(){
        return null;
    }
    
    public GridPane customerCost(){
        return null;
    }
    
    protected static ObservableList<Book> booksSelected = FXCollections.observableArrayList();
    protected static ObservableList<User> usersList = FXCollections.observableArrayList();
    protected static ObservableList<Book> booksList = FXCollections.observableArrayList();
    
    public static void main(String[] args){
        launch(args);
    }
}
