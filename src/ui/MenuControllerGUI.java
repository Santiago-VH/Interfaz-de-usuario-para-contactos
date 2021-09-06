package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Contact;
import model.ContactManager;

public class MenuControllerGUI {

    @FXML
    private MenuBar barMenu;
	
    @FXML
    private Pane mainPane;
    
    
    @FXML
    private TableView<Contact> tvContactList;

    @FXML
    private TableColumn<Contact, String> tcid;

    @FXML
    private TableColumn<Contact, String> tcName;

    @FXML
    private TableColumn<Contact, String> tcEmail;
    
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    private ObservableList<Contact> observableList;
    private ContactManager contactManager;
    
    public MenuControllerGUI() {
    	contactManager = new ContactManager();
    	
    }
    
    private void initializeTableView() {
    	observableList = FXCollections.observableArrayList(contactManager.getContacts());
    	
    	tvContactList.setItems(observableList);
    	tcid.setCellValueFactory(new PropertyValueFactory<Contact,String>("id"));
    	tcName.setCellValueFactory(new PropertyValueFactory<Contact,String>("name"));
    	tcEmail.setCellValueFactory(new PropertyValueFactory<Contact,String>("email"));
    }
    
    
    
    @FXML
    public void showForm1(ActionEvent event) throws IOException {
    	Parent form1 = FXMLLoader.load(getClass().getResource("Formulario-1.fxml"));
    	mainPane.getChildren().setAll(form1);
    }

    @FXML
    public void showForm2(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Formulario-2.fxml"));
    	fxmlLoader.setController(this);
    	Parent form2 = fxmlLoader.load();
    	mainPane.getChildren().setAll(form2);
    }
   
    @FXML
    public void showListContact(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Formulario-3.fxml"));
    	fxmlLoader.setController(this);
    	Parent form3 = fxmlLoader.load();
    	mainPane.getChildren().setAll(form3);
    	
    	initializeTableView();
    }
    
    @FXML
    public void addContact(ActionEvent event) {

    }
    
    @FXML
    public void showInformation(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Contact Manager");
    	alert.setHeaderText("Santiago V.H");
    	alert.setContentText("Contact Manager Application");
    	alert.showAndWait();
    }

}


