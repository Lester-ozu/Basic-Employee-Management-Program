import java.net.URL;
import java.util.ResourceBundle;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;

import java.util.LinkedList;
import java.util.ListIterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class LinkedListPredefinedController implements Initializable{
    
    
    @FXML private TableView<Employee> employeeTable;
    @FXML private TableColumn<Employee, String> IDColumn;
    @FXML private TableColumn<Employee, Byte> ageColumn;
    @FXML private TableColumn<Employee, String> nameColumn;
    @FXML private TableColumn<Employee, String> positionColumn;
    @FXML private TextField nameField, positionField, ageField, IDField, indexField;
    @FXML private Label nameLabel, positionLabel, ageLabel, IDLabel, indexLabel;
    @FXML private ChoiceBox<String> DSComboBox;
    @FXML private AnchorPane scenePane;
    @FXML private Button addFirstButton, addButton, addLastButton, removeFirstButton, removeButton, removeLastButton, getFirstButton,
                         getButton, getLastButton, setButton;

    private LinkedList<Employee> empLinkedList;
    private ObservableList<Employee> empObsList;
    private Employee tempEmp;

    private String [] dataStructures = {"Array List (Defined)",
                                        "Linked List (Defined)",
                                        "Stack (Defined_Array Based)",
                                        "Stack (Defined_Linked List Based)",
                                        "Queue (Defined_Array Based)",
                                        "Queue (Defined_Linked List Based)",
                                        "Array List (Predefined)",
                                        "Linked List (Predefined)",
                                        "Stack (Predefined)",
                                        "Queue (Predefined)"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        nameField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                
                if(ErrorProof.checkName(nameField.getText().trim())) {

                   nameField.setStyle(

                   "-fx-border-width: 0.5;" +
                   "-fx-border-radius: 20;" +
                   "-fx-border-color: red;"+
                   "-fx-background-radius: 20 20 20;" +
                   "-fx-background-color: white;"+
                   "-fx-text-fill: red;"
                   );

                   nameLabel.setText("Invalid Name");

                   addFirstButton.setDisable(true);
                   addButton.setDisable(true);
                   addLastButton.setDisable(true);
                   setButton.setDisable(true);
                }

                else {

                    nameField.setStyle("");
                    nameLabel.setText("");

                    addFirstButton.setDisable(false);
                    addButton.setDisable(false);
                    addLastButton.setDisable(false);
                    setButton.setDisable(false);
                }
            }  
        });

        positionField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                
                if(ErrorProof.checkPosition(positionField.getText().trim())) {

                   positionField.setStyle(

                   "-fx-border-width: 0.5;" +
                   "-fx-border-radius: 20;" +
                   "-fx-border-color: red;"+
                   "-fx-background-radius: 20 20 20;" +
                   "-fx-background-color: white;"+
                   "-fx-text-fill: red;"
                   );

                   positionLabel.setText("Invalid Position");

                   addFirstButton.setDisable(true);
                   addButton.setDisable(true);
                   addLastButton.setDisable(true);
                   setButton.setDisable(true);
                }

                else {

                    positionField.setStyle("");
                    positionLabel.setText("");

                    addFirstButton.setDisable(false);
                    addButton.setDisable(false);
                    addLastButton.setDisable(false);
                    setButton.setDisable(false);
                }
            }  
        });

        ageField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                
                if(ErrorProof.checkAge(ageField.getText().trim())) {

                   ageField.setStyle(

                   "-fx-border-width: 0.5;" +
                   "-fx-border-radius: 20;" +
                   "-fx-border-color: red;"+
                   "-fx-background-radius: 20 20 20;" +
                   "-fx-background-color: white;"+
                   "-fx-text-fill: red;"
                   );

                   ageLabel.setText("Invalid Age");

                   addFirstButton.setDisable(true);
                   addButton.setDisable(true);
                   addLastButton.setDisable(true);
                   setButton.setDisable(true);
                }

                else {

                    ageField.setStyle("");
                    ageLabel.setText("");

                    addFirstButton.setDisable(false);
                    addButton.setDisable(false);
                    addLastButton.setDisable(false);
                    setButton.setDisable(false);
                }
            }  
        });

        IDField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                
                if(ErrorProof.checkID(IDField.getText().trim())) {

                   IDField.setStyle(

                   "-fx-border-width: 0.5;" +
                   "-fx-border-radius: 20;" +
                   "-fx-border-color: red;"+
                   "-fx-background-radius: 20 20 20;" +
                   "-fx-background-color: white;"+
                   "-fx-text-fill: red;"
                   );

                   IDLabel.setText("Invalid ID");

                   addFirstButton.setDisable(true);
                   addButton.setDisable(true);
                   addLastButton.setDisable(true);
                   setButton.setDisable(true);
                }

                else {

                    IDField.setStyle("");
                    IDLabel.setText("");

                    addFirstButton.setDisable(false);
                    addButton.setDisable(false);
                    addLastButton.setDisable(false);
                    setButton.setDisable(false);
                }
            }  
        });

        indexField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                
                if(!indexField.getText().isEmpty()) {

                    if(ErrorProof.checkIndex(indexField.getText().trim()) ||  Integer.parseInt(indexField.getText().trim()) > empLinkedList.size()-1 ||
                                                                            Integer.parseInt(indexField.getText().trim()) < 0) {

                        indexField.setStyle(

                        "-fx-border-width: 0.5;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: red;"+
                        "-fx-background-radius: 20 20 20;" +
                        "-fx-background-color: white;"+
                        "-fx-text-fill: red;"
                        );

                        indexLabel.setText("Invalid Index");
                        setButton.setDisable(true);
                        getButton.setDisable(true);
                    }

                    else {

                        indexField.setStyle("");
                        indexLabel.setText("");

                        setButton.setDisable(false);
                        getButton.setDisable(false);
                    }
                }
            }  
        });

        employeeTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Employee>() {

            @Override
            public void changed(ObservableValue<? extends Employee> arg0, Employee arg1, Employee arg2) {
                
                tempEmp = employeeTable.getSelectionModel().getSelectedItem();

                if(tempEmp != null) {

                    nameField.setText(tempEmp.getName());
                    positionField.setText(tempEmp.getPosition());
                    ageField.setText(String.valueOf(tempEmp.getAge()));
                    IDField.setText(tempEmp.getID());
                    indexField.setText(String.valueOf(employeeTable.getSelectionModel().getSelectedIndex()));
                }

                else {

                    nameField.setText("");
                    positionField.setText("");
                    ageField.setText("");
                    IDField.setText("");
                    indexField.setText("");
                }
            }
        });

        updateTable();

        DSComboBox.getItems().addAll(dataStructures);
        DSComboBox.getSelectionModel().select(7);
            
        DSComboBox.setOnAction(this::changeDS);
    }

    public void addFirst(ActionEvent event) {

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();

            if(!ErrorProof.isSameID(empLinkedList, IDField.getText().trim())) {

                Employee emp = new Employee(name, position, age, ID);

                empLinkedList.addFirst(emp);
                DataRepository.importLinkedList(empLinkedList, empLinkedList.size());
                updateTable();
            }

            else {

                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("ERROR!");
                errorAlert.setHeaderText("An Error Occured :(");
                errorAlert.setContentText("ID already taken.");
                errorAlert.showAndWait();
            }
        }

        else {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("Please fill all required fields!");
            errorAlert.showAndWait();
        }
    }

    public void addEmployee(ActionEvent event) {

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();
            int index;

            if(ErrorProof.isSameID(empLinkedList, IDField.getText().trim())) {

                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("ERROR!");
                errorAlert.setHeaderText("An Error Occured :(");
                errorAlert.setContentText("ID already taken.");
                errorAlert.showAndWait();
            }

            else if(!indexField.getText().isEmpty()) {

                index = Integer.parseInt(indexField.getText());

                Employee emp = new Employee(name, position, age, ID);

                empLinkedList.add(index, emp);
                DataRepository.importLinkedList(empLinkedList, empLinkedList.size());
                updateTable();
            }

            else {

                Employee emp = new Employee(name, position, age, ID);

                empLinkedList.add(emp);
                DataRepository.importLinkedList(empLinkedList, empLinkedList.size());
                updateTable();
            }
        }

        else {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("Please fill all required fields!");
            errorAlert.showAndWait();
        }
    }

    public void addLast(ActionEvent event) {

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();

            if(!ErrorProof.isSameID(empLinkedList, IDField.getText().trim())) {

                Employee emp = new Employee(name, position, age, ID);

                empLinkedList.addLast(emp);
                DataRepository.importLinkedList(empLinkedList, empLinkedList.size());
                updateTable();
            }

            else {

                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("ERROR!");
                errorAlert.setHeaderText("An Error Occured :(");
                errorAlert.setContentText("ID already taken.");
                errorAlert.showAndWait();
            }
        }

        else {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("Please fill all required fields!");
            errorAlert.showAndWait();
        }
    }

    public void removeFirst(ActionEvent event) {

        if(empLinkedList.size() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to delete\nSince list is empty.");
            errorAlert.showAndWait();

            return;
        }

        empLinkedList.removeFirst();
        DataRepository.importLinkedList(empLinkedList, empLinkedList.size());
        updateTable();
    }

    public void removeEmployee(ActionEvent event) {

        if(empLinkedList.size() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to delete\nSince list is empty.");
            errorAlert.showAndWait();

            return;
        }

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {
            
            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();
            int index = -1;

            for(int i = 0 ; i < empObsList.size() ; i++) {

                if(empObsList.get(i).getID().equals(ID)) {

                    index = i;
                    break;
                }
            }

            if (index > -1) {

                empLinkedList.remove(index);
                DataRepository.importLinkedList(empLinkedList, empLinkedList.size());
                updateTable();
            }

            else {

                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("ERROR!");
                errorAlert.setHeaderText("An Error Occured :(");
                errorAlert.setContentText("Employee you are trying to remove doesn't exist.");
                errorAlert.showAndWait();
            }
        }  

        else if(!indexField.getText().trim().isEmpty()) {

            empLinkedList.remove(Integer.parseInt(indexField.getText().trim()));
            DataRepository.importLinkedList(empLinkedList, empLinkedList.size());
            updateTable();
        }

        else {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("Please fill all required fields!");
            errorAlert.showAndWait();
        }
    }

    public void removeLast(ActionEvent event) {

        if(empLinkedList.size() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to delete\nSince list is empty.");
            errorAlert.showAndWait();

            return;
        }

        empLinkedList.removeLast();
        DataRepository.importLinkedList(empLinkedList, empLinkedList.size());
        updateTable();
    }

    public void getFirst(ActionEvent event) {

        employeeTable.getSelectionModel().select(0);

        Employee emp = employeeTable.getSelectionModel().getSelectedItem();

        nameField.setText(emp.getName());
        positionField.setText(emp.getPosition());
        ageField.setText(String.valueOf(emp.getAge()));
        IDField.setText(String.valueOf(emp.getID()));
        indexField.setText("0");
    }

    public void getEmployee(ActionEvent event) {

        if(!indexField.getText().isEmpty()) {

            employeeTable.getSelectionModel().select(Integer.parseInt(indexField.getText()));

            Employee emp = employeeTable.getSelectionModel().getSelectedItem();

            nameField.setText(emp.getName());
            positionField.setText(emp.getPosition());
            ageField.setText(String.valueOf(emp.getAge()));
            IDField.setText(String.valueOf(emp.getID()));
        }
        
        else {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("Please fill the Index field!");
            errorAlert.showAndWait();
        }
    }

    public void getLast(ActionEvent event) {

        employeeTable.getSelectionModel().select(empLinkedList.size()-1);

        Employee emp = employeeTable.getSelectionModel().getSelectedItem();

        nameField.setText(emp.getName());
        positionField.setText(emp.getPosition());
        ageField.setText(String.valueOf(emp.getAge()));
        IDField.setText(String.valueOf(emp.getID()));
        indexField.setText(String.valueOf(empLinkedList.size()-1));
    }
    
    public void setEmployee(ActionEvent event) {

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty() && !indexField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();
            int index = Integer.parseInt(indexField.getText().trim());

            if(ErrorProof.isSameID(empLinkedList, IDField.getText().trim())) {

                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("ERROR!");
                errorAlert.setHeaderText("An Error Occured :(");
                errorAlert.setContentText("ID already taken.");
                errorAlert.showAndWait();
            }

            else {

                Employee emp = new Employee(name, position, age, ID);

                empLinkedList.set(index, emp);
                DataRepository.importLinkedList(empLinkedList, empLinkedList.size());
                updateTable();
            }
        }

        else {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("Please fill all required fields!");
            errorAlert.showAndWait();
        }
    }

    public void exit() {

        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    public void minimize() {

        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.setIconified(true);
    }

    public void updateTable() {

        empLinkedList = new LinkedList<Employee>();
        empObsList = FXCollections.observableArrayList();
        
        ResultSet rs = DataRepository.getTable();

        boolean flag = true;

        if (rs != null) {

            try {
                
                while(rs.next()) {
                    
                    Employee emp = new Employee(rs.getString("Name"), rs.getString("Position"), (byte)rs.getInt("Age"), rs.getString("ID"));

                    if(flag) {

                        empLinkedList.add(emp);
                        flag = false;
                    }

                    else {

                        empLinkedList.addLast(emp);
                    }
                }
            }

            catch (SQLException e) {

                System.out.println("Error: " + e.getMessage());
            }

            finally {

                try {
                    
                    rs.close();
                }

                catch (SQLException e) {

                    System.out.println("Error: " + e.getMessage());
                }
            }
        } 

        ListIterator<Employee> iterator = empLinkedList.listIterator();

        while(iterator.hasNext()) {

            Employee emp = iterator.next();
            empObsList.add(emp);
        }

        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Employee, Byte>("age"));
        IDColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("ID"));

        employeeTable.setItems(empObsList);
        employeeTable.refresh();
    }

    public void changeDS(ActionEvent event) {

        Parent currentRoot = DSComboBox.getScene().getRoot();
        Scene currentScene = DSComboBox.getScene();
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        transitionTo(currentRoot, 0, 400, currentStage, currentScene);

        String DStructure = DSComboBox.getValue();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = null;
        String css = this.getClass().getResource("designCSS.css").toExternalForm();
        Parent root = null;

        switch (DStructure) {

            case "Linked List (Defined)":
                try {

                    root = FXMLLoader.load(getClass().getResource("linkedListDefined.fxml"));
                    scene = new Scene(root);
                    scene.getStylesheets().add(css);
                }

                catch (IOException e) {

                    e.printStackTrace();
                }

                break;
            
            case "Stack (Defined_Array Based)":
                try {

                    root = FXMLLoader.load(getClass().getResource("stackArrayBased.fxml"));
                    scene = new Scene(root);
                    scene.getStylesheets().add(css);
                }

                catch (IOException e) {

                    e.printStackTrace();
                }

                break;

            case "Stack (Defined_Linked List Based)":

                try {

                    root = FXMLLoader.load(getClass().getResource("stackLinkedListBased.fxml"));
                    scene = new Scene(root);
                    scene.getStylesheets().add(css);
                }

                catch (IOException e) {

                    e.printStackTrace();
                }

                break;

            case "Queue (Defined_Array Based)":

                try {

                    root = FXMLLoader.load(getClass().getResource("queueArrayBased.fxml"));
                    scene = new Scene(root);
                    scene.getStylesheets().add(css);
                }

                catch (IOException e) {

                    e.printStackTrace();
                }

                break;
            
            case "Queue (Defined_Linked List Based)":

                try {

                    root = FXMLLoader.load(getClass().getResource("queueLinkedListBased.fxml"));
                    scene = new Scene(root);
                    scene.getStylesheets().add(css);
                }

                catch (IOException e) {

                    e.printStackTrace();
                }

                break;

            case "Array List (Predefined)":

                try {

                    root = FXMLLoader.load(getClass().getResource("arrayListPredefined.fxml"));
                    scene = new Scene(root);
                    scene.getStylesheets().add(css);
                }

                catch (IOException e) {

                    e.printStackTrace();
                }

                break;

            case "Array List (Defined)":

                try {

                    root = FXMLLoader.load(getClass().getResource("arrayListDefined.fxml"));
                    scene = new Scene(root);
                    scene.getStylesheets().add(css);
                }

                catch (IOException e) {

                    e.printStackTrace();
                }

                break;

            case "Stack (Predefined)":

                try {

                    root = FXMLLoader.load(getClass().getResource("stackPredefined.fxml"));
                    scene = new Scene(root);
                    scene.getStylesheets().add(css);
                }

                catch (IOException e) {

                    e.printStackTrace();
                }

                break;

            case "Queue (Predefined)":

                try {

                    root = FXMLLoader.load(getClass().getResource("queuePredefined.fxml"));
                    scene = new Scene(root);
                    scene.getStylesheets().add(css);
                }

                catch (IOException e) {

                    e.printStackTrace();
                }

                break;
        }

        transitionTo(root, -400, 0, stage, scene);
        stage.setScene(scene);
        stage.show();
    }

    public void transitionTo(Parent root, double fromX, double toX, Stage stage, Scene scene) {

        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(root);
        slide.setFromX(fromX);
        slide.setToX(toX);

        stage.setScene(scene);
        slide.play();
    }
}
