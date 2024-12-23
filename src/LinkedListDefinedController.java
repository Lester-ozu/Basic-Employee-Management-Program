import java.net.URL;
import java.util.ResourceBundle;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;

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

public class LinkedListDefinedController implements Initializable{
    
    @FXML private TableView<Employee> employeeTable;
    @FXML private TableColumn<Employee, String> IDColumn;
    @FXML private TableColumn<Employee, Byte> ageColumn;
    @FXML private TableColumn<Employee, String> nameColumn;
    @FXML private TableColumn<Employee, String> positionColumn;
    @FXML private TextField nameField, positionField, ageField, IDField, indexField;
    @FXML private Label nameLabel, positionLabel, ageLabel, IDLabel, indexLabel;
    @FXML private ChoiceBox<String> DSComboBox;
    @FXML private AnchorPane scenePane;
    @FXML private Button insertHeadButton, insertButton, insertTailButton, deleteFirstButton, deleteButton, deleteLastButton,
                         fIndexButton, fValueButton, previousButton, updateButton, nextButton;

    private DoublyLinkedList_Capote empLinkedList;
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

                   insertHeadButton.setDisable(true);
                   insertButton.setDisable(true);
                   insertTailButton.setDisable(true);
                   fValueButton.setDisable(true);
                   updateButton.setDisable(true);
                }

                else {

                    nameField.setStyle("");
                    nameLabel.setText("");

                   insertHeadButton.setDisable(false);
                   insertButton.setDisable(false);
                   insertTailButton.setDisable(false);
                   fValueButton.setDisable(false);
                   updateButton.setDisable(false);
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

                   insertHeadButton.setDisable(true);
                   insertButton.setDisable(true);
                   insertTailButton.setDisable(true);
                   fValueButton.setDisable(true);
                   updateButton.setDisable(true);
                }

                else {

                    positionField.setStyle("");
                    positionLabel.setText("");

                   insertHeadButton.setDisable(false);
                   insertButton.setDisable(false);
                   insertTailButton.setDisable(false);
                   fValueButton.setDisable(false);
                   updateButton.setDisable(false);
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

                   insertHeadButton.setDisable(true);
                   insertButton.setDisable(true);
                   insertTailButton.setDisable(true);
                   fValueButton.setDisable(true);
                   updateButton.setDisable(true);
                }

                else {

                    ageField.setStyle("");
                    ageLabel.setText("");

                   insertHeadButton.setDisable(false);
                   insertButton.setDisable(false);
                   insertTailButton.setDisable(false);
                   fValueButton.setDisable(false);
                   updateButton.setDisable(false);
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

                   insertHeadButton.setDisable(true);
                   insertButton.setDisable(true);
                   insertTailButton.setDisable(true);
                   fValueButton.setDisable(true);
                   updateButton.setDisable(true);
                }

                else {

                    IDField.setStyle("");
                    IDLabel.setText("");

                   insertHeadButton.setDisable(false);
                   insertButton.setDisable(false);
                   insertTailButton.setDisable(false);
                   fValueButton.setDisable(false);
                   updateButton.setDisable(false);
                }
            }  
        });

        indexField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                
                if(!indexField.getText().isEmpty()) {

                    if(ErrorProof.checkIndex(indexField.getText().trim()) ||  Integer.parseInt(indexField.getText().trim()) > empLinkedList.getSize()-1 ||
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
                        fIndexButton.setDisable(true);
                    }

                    else {

                        indexField.setStyle("");
                        indexLabel.setText("");

                        fIndexButton.setDisable(false);
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
        DSComboBox.getSelectionModel().select(1);
            
        DSComboBox.setOnAction(this::changeDS);
    }
    

    public void insertAtHead(ActionEvent event) {

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();

            if(!ErrorProof.isSameID(empLinkedList.getHead(), IDField.getText().trim())) {

                Employee emp = new Employee(name, position, age, ID);

                empLinkedList.insertAtHead(emp);
                DataRepository.importLinkedList(empLinkedList.getHead(), empLinkedList.getSize());
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

    public void insert(ActionEvent event) {

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();
            int index;

            if(ErrorProof.isSameID(empLinkedList.getHead(), IDField.getText().trim())) {

                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("ERROR!");
                errorAlert.setHeaderText("An Error Occured :(");
                errorAlert.setContentText("ID already taken.");
                errorAlert.showAndWait();
            }

            else if(!indexField.getText().isEmpty()) {

                index = Integer.parseInt(indexField.getText());

                Employee emp = new Employee(name, position, age, ID);

                empLinkedList.insert(emp, index);
                DataRepository.importLinkedList(empLinkedList.getHead(), empLinkedList.getSize());
                updateTable();
            }

            else {

                Employee emp = new Employee(name, position, age, ID);

                empLinkedList.insert(emp);
                DataRepository.importLinkedList(empLinkedList.getHead(), empLinkedList.getSize());
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

    public void insertAtTail(ActionEvent event) {

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();

            if(!ErrorProof.isSameID(empLinkedList.getHead(), IDField.getText().trim())) {

                Employee emp = new Employee(name, position, age, ID);

                empLinkedList.insertAtTail(emp);
                DataRepository.importLinkedList(empLinkedList.getHead(), empLinkedList.getSize());
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

    public void deleteFirstRecord(ActionEvent event) {

        if(empLinkedList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to delete\nSince list is empty.");
            errorAlert.showAndWait();

            return;
        }

        empLinkedList.deleteFirstRecord();
        DataRepository.importLinkedList(empLinkedList.getHead(), empLinkedList.getSize());
        updateTable();
    }

    public void delete(ActionEvent event) {

        if(empLinkedList.getSize() < 1) {

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

            Employee emp = new Employee(name, position, age, ID);

            empLinkedList.delete(emp);
            DataRepository.importLinkedList(empLinkedList.getHead(), empLinkedList.getSize());
            updateTable();
        }  

        else if(!indexField.getText().trim().isEmpty()) {

            empLinkedList.delete(Integer.parseInt(indexField.getText().trim()));
            DataRepository.importLinkedList(empLinkedList.getHead(), empLinkedList.getSize());
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

    public void deleteLastRecord(ActionEvent event) {

        if(empLinkedList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to delete\nSince list is empty.");
            errorAlert.showAndWait();

            return;
        }

        empLinkedList.deleteLastRecord();
        DataRepository.importLinkedList(empLinkedList.getHead(), empLinkedList.getSize());
        updateTable();
    }

    public void findByIndex(ActionEvent event) {

        if(empLinkedList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to find\nSince list is empty.");
            errorAlert.showAndWait();
        }

        if(!indexField.getText().trim().isEmpty()) {

            Employee emp = employeeTable.getItems().get(Integer.parseInt(indexField.getText().trim()));
            employeeTable.getSelectionModel().select(emp);

            nameField.setText(emp.getName());
            positionField.setText(emp.getPosition());
            ageField.setText(String.valueOf(emp.getAge()));
            IDField.setText(emp.getID());
        }

        else {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("Please fill Index Field!");
            errorAlert.showAndWait();
        }
    }

    public void findByValue(ActionEvent event) {

        if(empLinkedList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to find\nSince list is empty.");
            errorAlert.showAndWait();
        }

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();

            Employee emp = new Employee(name, position, age, ID);

            employeeTable.getSelectionModel().select(empLinkedList.findByValue(emp));
            indexField.setText(String.valueOf(employeeTable.getSelectionModel().getSelectedIndex()));
        }

        else {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("Please fill all required fields!");
            errorAlert.showAndWait();
        }
    }

    public void previous(ActionEvent event) {

        if(empLinkedList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is no previous Employee\nSince list is empty.");
            errorAlert.showAndWait();
        }

        int index = employeeTable.getSelectionModel().getSelectedIndex();

        if(index <= 0) {

            employeeTable.getSelectionModel().select(empLinkedList.getSize()-1);
        }

        else {

            employeeTable.getSelectionModel().select(index-1);
        }
    }

    public void update(ActionEvent event) {

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();

            if(!ErrorProof.isSameID(tempEmp, empLinkedList.getHead(), IDField.getText().trim())) {

                if(!empLinkedList.update(tempEmp, name, position, age, ID)) {
                    
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setTitle("ERROR!");
                    errorAlert.setHeaderText("An Error Occured :(");
                    errorAlert.setContentText("Employee you are trying to update doesn't exist.");
                    errorAlert.showAndWait();
                }

                else {

                    DataRepository.importLinkedList(empLinkedList.getHead(), empLinkedList.getSize());
                    updateTable();
                }
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

    public void next(ActionEvent event) {

        if(empLinkedList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is no next Employee\nSince list is empty.");
            errorAlert.showAndWait();
        }

        int index = employeeTable.getSelectionModel().getSelectedIndex();

        if(index >= empLinkedList.getSize()-1) {

            employeeTable.getSelectionModel().select(0);
        }

        else {

            employeeTable.getSelectionModel().select(index+1);
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

        empLinkedList = new DoublyLinkedList_Capote();
        empObsList = FXCollections.observableArrayList();
        
        ResultSet rs = DataRepository.getTable();

        boolean flag = true;

        if (rs != null) {

            try {
                
                while(rs.next()) {
                    
                    Employee emp = new Employee(rs.getString("Name"), rs.getString("Position"), (byte)rs.getInt("Age"), rs.getString("ID"));

                    if(flag) {

                        empLinkedList.insert(emp);
                        flag = false;
                    }

                    else {

                        empLinkedList.insertAtTail(emp);
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

        if(!empLinkedList.isEmpty()) {

            Employee nav = empLinkedList.getHead();

            for (int i = 0 ; i < empLinkedList.getSize() ; i++) {

                empObsList.add(nav);
                nav = nav.getNext();
            }
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

            case "Linked List (Predefined)":

                try {

                    root = FXMLLoader.load(getClass().getResource("linkedListPredefined.fxml"));
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
