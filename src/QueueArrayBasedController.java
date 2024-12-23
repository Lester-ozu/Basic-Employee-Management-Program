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

public class QueueArrayBasedController implements Initializable {
    
    @FXML private TableView<Employee> employeeTable;
    @FXML private TableColumn<Employee, String> IDColumn;
    @FXML private TableColumn<Employee, Byte> ageColumn;
    @FXML private TableColumn<Employee, String> nameColumn;
    @FXML private TableColumn<Employee, String> positionColumn;
    @FXML private TextField nameField, positionField, ageField, IDField, indexField;
    @FXML private Label nameLabel, positionLabel, ageLabel, IDLabel, indexLabel;
    @FXML private Button offerButton, peekButton, pollButton, clearButton, containsButton;
    @FXML private ChoiceBox<String> DSComboBox;
    @FXML private AnchorPane scenePane;

    private QueueArrayListBased_Capote empQueueArrayList;
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
        
        indexField.setDisable(true);

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

                   offerButton.setDisable(true);
                   containsButton.setDisable(true);
                }

                else {

                    nameField.setStyle("");
                    nameLabel.setText("");

                    offerButton.setDisable(false);
                    containsButton.setDisable(false);
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

                   offerButton.setDisable(true);
                   containsButton.setDisable(true);
                }

                else {

                    positionField.setStyle("");
                    positionLabel.setText("");

                    offerButton.setDisable(false);
                    containsButton.setDisable(false);
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

                   offerButton.setDisable(true);
                   containsButton.setDisable(true);
                }

                else {

                    ageField.setStyle("");
                    ageLabel.setText("");

                    offerButton.setDisable(false);
                    containsButton.setDisable(false);
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

                   offerButton.setDisable(true);
                   containsButton.setDisable(true);
                }

                else {

                    IDField.setStyle("");
                    IDLabel.setText("");

                    offerButton.setDisable(false);
                    containsButton.setDisable(false);
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
                }

                else {

                    nameField.setText("");
                    positionField.setText("");
                    ageField.setText("");
                    IDField.setText("");
                }
            }
        });

        updateTable();

        DSComboBox.getItems().addAll(dataStructures);
        DSComboBox.getSelectionModel().select(4);
            
        DSComboBox.setOnAction(this::changeDS);
    }

    public void offerEmployee(ActionEvent event) {

        if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();

            if(ErrorProof.isSameID(empQueueArrayList.getList(), IDField.getText().trim())) {

                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("ERROR!");
                errorAlert.setHeaderText("An Error Occured :(");
                errorAlert.setContentText("ID already taken.");
                errorAlert.showAndWait();
            }

            else {

                Employee emp = new Employee(name, position, age, ID);

                empQueueArrayList.offer(emp);
                DataRepository.importArrayList(empQueueArrayList.getList(), empQueueArrayList.getSize());
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

    public void peekEmployee(ActionEvent event) {

        if(empQueueArrayList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to peek\nSince the list is empty.");

            errorAlert.showAndWait();

            return;
        }

        employeeTable.getSelectionModel().select(empQueueArrayList.peek());

        nameField.setText(empQueueArrayList.peek().getName());
        positionField.setText(empQueueArrayList.peek().getPosition());
        ageField.setText(String.valueOf(empQueueArrayList.peek().getAge()));
        IDField.setText(empQueueArrayList.peek().getID());
    }

    public void pollEmployee(ActionEvent event) {

        if(empQueueArrayList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to pop\nSince the list is empty.");

            errorAlert.showAndWait();

            return;
        }

        empQueueArrayList.poll();
        DataRepository.importArrayList(empQueueArrayList.getList(), empQueueArrayList.getSize());
        updateTable();
    }

    public void clearTable(ActionEvent event) {

        if(empQueueArrayList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("Table is already empty");

            errorAlert.showAndWait();

            return;
        }

        empQueueArrayList.clear();
        DataRepository.clear();
        updateTable();
    }

    public void containsEmployee(ActionEvent event) {

        if(empQueueArrayList.getSize() < 1) {

            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("ERROR!");
            errorAlert.setHeaderText("An Error Occured :(");
            errorAlert.setContentText("There is nothing to search\nSince the list is empty.");

            errorAlert.showAndWait();

            return;
        }

        else if(!nameField.getText().isEmpty() && !positionField.getText().isEmpty() && !ageField.getText().isEmpty() && !IDField.getText().isEmpty()) {

            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            byte age = Byte.parseByte(ageField.getText().trim());
            String ID = IDField.getText().trim();

            if(empQueueArrayList.contains(new Employee(name, position, age, ID))) {

                int index = -1;

                for (int i = 0 ; i < empObsList.size() ; i++) {

                    if(empObsList.get(i).getID().equals(ID)) {

                        index = i;
                        break;
                    }
                }

                employeeTable.getSelectionModel().select(index);
            }

            else {

                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("ERROR!");
                errorAlert.setHeaderText("An Error Occured :(");
                errorAlert.setContentText("Employee doesn't exist.");

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

    public void exit() {

        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    public void minimize() {

        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.setIconified(true);
    }

    public void updateTable() {

        empQueueArrayList = new QueueArrayListBased_Capote();
        empObsList = FXCollections.observableArrayList();
        
        ResultSet rs = DataRepository.getTable();

        if (rs != null) {

            try {

                while(rs.next()) {

                    Employee emp = new Employee(rs.getString("Name"), rs.getString("Position"), (byte)rs.getInt("Age"), rs.getString("ID"));
                    empQueueArrayList.offer(emp);
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

        if(!empQueueArrayList.isEmpty()) {

            for (int i = 0 ; i < empQueueArrayList.getSize() ; i++) {

                empObsList.add(empQueueArrayList.getList()[i]);
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
