package com.mycompany.project_ap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    Scene scene1;
    Scene scene2;

    @Override
    public void start(Stage primaryStage) {

        //خلفية
        String imgpath = new File("").getAbsolutePath() + "\\k.jpg";
        Image image = new Image(new File(imgpath).toURI().toString(), 90, 800, false, false);
        ImageView imageView1 = new ImageView(image);

        //اسم الحضانه 
        Label TitleLabel = new Label("Baby DayCare");
        TitleLabel.setFont(Font.font("Comic Sans MS", 40));
        TitleLabel.setStyle("-fx-text-fill: #6892d5;");
        TitleLabel.setAlignment(Pos.CENTER);
        TitleLabel.setPadding(new Insets(20, 20, 5, 20));
        Label message = new Label("");

        //بيانات الطفل
        Label ChildLabel = new Label("child Information");
        ChildLabel.setFont(Font.font("Comic Sans MS", 26));
        ChildLabel.setStyle("-fx-text-fill: #6892d5;");
        //1
        Label nameLabel = new Label("Child Name    :");
        nameLabel.setFont(Font.font("Comic Sans MS", 16));
        TextField nameTextField = new TextField();
        HBox nameHBox = new HBox(5);
        nameHBox.getChildren().addAll(nameLabel, nameTextField);
        //2
        Label ageLabel = new Label("Age       :");
        ageLabel.setFont(Font.font("Comic Sans MS", 16));
        TextField ageTextField = new TextField();
        HBox ageHBox = new HBox(46);
        ageHBox.getChildren().addAll(ageLabel, ageTextField);
        //3
        Label dobLabel = new Label("Date of Birth:");
        dobLabel.setFont(Font.font("Comic Sans MS", 16));
        DatePicker datePicker = new DatePicker();
        HBox DaHBox = new HBox(10);
        DaHBox.getChildren().addAll(dobLabel, datePicker);
        //4
        Label IDLabel = new Label("Child ID        :");
        IDLabel.setFont(Font.font("Comic Sans MS", 16));
        TextField IDTextField = new TextField();
        HBox genderIdHBox = new HBox(10);
        genderIdHBox.getChildren().addAll(IDLabel, IDTextField);
        //5
        Label GLabel = new Label("Gender:");
        GLabel.setFont(Font.font("Comic Sans MS", 16));
        RadioButton boyRadioButton = new RadioButton("Boy");
        boyRadioButton.setFont(Font.font("Comic Sans MS", 16));
        RadioButton girlRadioButton = new RadioButton("Girl");
        girlRadioButton.setFont(Font.font("Comic Sans MS", 16));
        //جنس الطفل 
        ToggleGroup genderToggleGroup = new ToggleGroup();
        boyRadioButton.setToggleGroup(genderToggleGroup);
        girlRadioButton.setToggleGroup(genderToggleGroup);
        HBox gen = new HBox(10);
        gen.getChildren().addAll(GLabel, boyRadioButton, girlRadioButton);
        //6
        Label infLabel = new Label("Dose the child suffer from any disease:");
        infLabel.setFont(Font.font("Comic Sans MS", 16));
        TextField infTextField = new TextField();
        HBox infHBox = new HBox(10);
        infHBox.getChildren().addAll(infLabel, infTextField);
        
        

        Button saveButton = new Button("Save");
        saveButton.setFont(Font.font("Comic Sans MS", 18));

        VBox childInfoVBox = new VBox(10);
        childInfoVBox.getChildren().addAll(ChildLabel, nameHBox, ageHBox, DaHBox, genderIdHBox, gen, infHBox, saveButton);
        childInfoVBox.setPadding(new Insets(5, 5, 5, 30));//t,r,b,l

        //1
        Label ListLabel1 = new Label("Nurse Name:");
        ListLabel1.setFont(Font.font("Comic Sans MS", 18));
        ObservableList<String> nurseList = FXCollections.observableArrayList(
                "Sara                ", "Haneen", "Raghad", "Jana", "Rana", "Renad");
        //1.1
        ListView<String> listViewNames = new ListView<>(nurseList);
        listViewNames.setPrefSize(100, 130);
        Label ListLabework = new Label("Available Times:");
        ListLabework.setFont(Font.font("Comic Sans MS", 18));
        ListLabework.setVisible(false);
        ListView<String> listViewInfo = new ListView<>();
        listViewInfo.setVisible(false);
        listViewInfo.setPrefSize(100, 90);
        //2.1
        Button closeButton = new Button("Close");
        closeButton.setVisible(false);
        closeButton.setPrefSize(60, 20);
        closeButton.setStyle("-fx-font-size: 10;");
        closeButton.setOnAction(event -> {

            listViewNames.getSelectionModel().clearSelection();
            listViewInfo.getItems().clear();
            listViewInfo.setVisible(false);
            closeButton.setVisible(false);
            ListLabework.setVisible(false);
        });

        listViewNames.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<String> information = getInformationForName(newValue);
            listViewInfo.setItems(information);
            listViewInfo.setVisible(true);
            closeButton.setVisible(true);
            ListLabework.setVisible(true);
        });

        //تبع الاسم 
        VBox childInfoVBox1 = new VBox(5, ListLabel1, listViewNames);
        VBox childInfoVBox2 = new VBox(5, ListLabework, listViewInfo);
        Label ListLabel2 = new Label("Name:");
        ListLabel2.setFont(Font.font("Comic Sans MS", 18));
        ObservableList<String> list2 = FXCollections.observableArrayList( //"Item1               ", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7"
                );
        ListView<String> listView2 = new ListView<>(list2);
        listView2.setPrefSize(100, 130);
        VBox listVBox2 = new VBox(5, ListLabel2, listView2);
        HBox listHBox = new HBox(20);
        HBox buttonHBox = new HBox(closeButton);
        buttonHBox.setAlignment(Pos.CENTER);
        listHBox.getChildren().addAll(buttonHBox, childInfoVBox2, childInfoVBox1, listVBox2);
        //تبع العمر
        Label ListLabel3 = new Label(" Age:");
        ListLabel3.setFont(Font.font("Comic Sans MS", 18));
        ObservableList<String> list3 = FXCollections.observableArrayList( //"Item1               ", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7"
                );
        ListView<String> listView3 = new ListView<>(list3);
        listView3.setPrefSize(100, 130);
        VBox listVBox3 = new VBox(5, ListLabel3, listView3);
        //نبع ال id
        Label ListLabel4 = new Label("Child ID :");
        ListLabel4.setFont(Font.font("Comic Sans MS", 18));
        ObservableList<String> list4 = FXCollections.observableArrayList( //"Item1               ", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7"
                );
        ListView<String> listView4 = new ListView<>(list4);
        VBox listVBox4 = new VBox(5, ListLabel4, listView4);
        //تبع الامراض       
        Label ListLabel5 = new Label("Disease :");
        ListLabel5.setFont(Font.font("Comic Sans MS", 18));
        ObservableList<String> list5 = FXCollections.observableArrayList( //"Item1               ", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7"
                );
        ListView<String> listView5 = new ListView<>(list5);
        listView5.setPrefSize(100, 130);
        VBox listVBox5 = new VBox(5, ListLabel5, listView5);
        //تبع الجنس       
        Label ListLabel6 = new Label("Gender :");
        ListLabel6.setFont(Font.font("Comic Sans MS", 18));
        ObservableList<String> list6 = FXCollections.observableArrayList();
        ListView<String> listView6 = new ListView<>(list6);
        listView6.setPrefSize(100, 130);
        VBox listVBox6 = new VBox(6, ListLabel6, listView6);

        //       
        listView4.setPrefSize(100, 130);
        ListView<String> listViewInfo1 = new ListView<>();
        listViewInfo1.setVisible(false);
        listViewInfo1.setPrefSize(100, 130);
        Button closeButton1 = new Button("Close");
        closeButton1.setVisible(false);
        closeButton1.setPrefSize(60, 20);
        closeButton1.setStyle("-fx-font-size: 10;");

        //
        HBox list2HBox = new HBox(20);
        list2HBox.getChildren().addAll(closeButton1, listViewInfo1, listVBox3, listVBox4, listVBox5, listVBox6);
        VBox mlistVBox = new VBox(20);

        //
        Button AddButton = new Button("Add");
        AddButton.setFont(Font.font("Comic Sans MS", 18));
        Button DeleteButton = new Button("delete");
        DeleteButton.setFont(Font.font("Comic Sans MS", 18));
        Button clearButton = new Button("Clear");
        clearButton.setFont(Font.font("Comic Sans MS", 18));

        Button FileB = new Button("create a file"); //list2
        FileB.setOnAction(e -> {
            FileB.setFont(Font.font("Comic Sans MS", 18));
            try {
                FileWriter fw = new FileWriter("out.txt");
                for (String s : list2) {
                    String line = s + " " + list3.get(list2.indexOf(s)) + " "
                            + list4.get(list2.indexOf(s))
                            + " " + list5.get(list2.indexOf(s))
                            + " " + list6.get(list2.indexOf(s)) + "\n";
                    //System.out.println(line);
                    fw.write(line);
                }
                fw.close();
            } catch (IOException ex) {

                System.out.print("File not created");
            }
        });
        HBox buHBox = new HBox(10, AddButton, DeleteButton, clearButton, FileB);
        buHBox.setPadding(new Insets(5, 5, 5, 220));//t,r,b,l
        mlistVBox.getChildren().addAll(listHBox, list2HBox, buHBox);
        mlistVBox.setPadding(new Insets(5, 30, 5, 5));//t,r,b,l

        //
        VBox infoVBox = new VBox(20);
        infoVBox.getChildren().addAll(TitleLabel, childInfoVBox, message);
        //تقيم الخدمة 
        Label evLabel = new Label("Service evaluation:");
        evLabel.setFont(Font.font("Comic Sans MS", 23));
        evLabel.setStyle("-fx-text-fill: #6892d5;");
        message.setStyle("-fx-text-fill: red;");
        message.setFont(Font.font("Comic Sans MS", 23));

        //ADD button action 
        AddButton.setOnAction(event -> {
            String childName = nameTextField.getText();
            String childAge = ageTextField.getText();
            String childDOB = datePicker.getValue().toString();
            String childID = IDTextField.getText();
            String Boy = boyRadioButton.getText();
            String Girl = girlRadioButton.getText();
            String childdis = infTextField.getText();
            String childGender = boyRadioButton.isSelected() ? "Boy" : "Girl";
            //String childInfo = "Name: " + childName + "\nAge: " + childAge + "\nDate of Birth: " + childDOB
            //+ "\nChild ID: " + childID + "\nGender: " + Boy + Girl + "\nDisease:" +childdis +childGender;

            String childInfo = "Name: " + childName + "\nAge: " + childAge + "\nDate of Birth: " + childDOB
                    + "\nChild ID: " + childID + "\nGender: " + childGender + "\nDisease:" + childdis;
            list2.add(childName);
            list3.add(childID);
            list4.add(childAge);
            list5.add(childdis);
            list6.add(childGender);
            /*
        listView2.getItems().add(childName);
        listView3.getItems().add(childID);
        listView4.getItems().add(childAge);
        listView5.getItems().add(childdis);
       listView6.getItems().add(childGender);*/

            listViewInfo1.getItems().add(childInfo);

            nameTextField.clear();
            ageTextField.clear();
            datePicker.setValue(null);
            IDTextField.clear();
            boyRadioButton.setSelected(false);
            girlRadioButton.setSelected(false);
        });

        AddButton.setOnAction(event -> {
    String childName = nameTextField.getText();
    String childAgeText = ageTextField.getText();
    String childDOB = datePicker.getValue().toString();
    String childID = IDTextField.getText();
    String childdis = infTextField.getText();
    String childGender = boyRadioButton.isSelected() ? "Boy" : "Girl";

    // Validate that age is a number
    try {
        int childAge = Integer.parseInt(childAgeText);

        // Age is a valid number, proceed with adding the child
        String childInfo = "Name: " + childName + "\nAge: " + childAge + "\nDate of Birth: " + childDOB
                + "\nChild ID: " + childID + "\nGender: " + childGender + "\nDisease:" + childdis;

        list2.add(childName);
        list3.add(childID);
        list4.add(String.valueOf(childAge));
        list5.add(childdis);
        list6.add(childGender);

        listViewInfo1.getItems().add(childInfo);

        // Clear the input fields
        nameTextField.clear();
        ageTextField.clear();
        datePicker.setValue(null);
        IDTextField.clear();
        boyRadioButton.setSelected(false);
        girlRadioButton.setSelected(false);
    } catch (NumberFormatException e) {
        // Age is not a valid number
        message.setText("Please enter a valid age (numeric value).");
    }
});

        // Button "Clear";
        clearButton.setOnAction(event -> {
            nameTextField.clear();
            ageTextField.clear();
            infTextField.clear();
            datePicker.setValue(null);
            IDTextField.clear();
            boyRadioButton.setSelected(false);
            girlRadioButton.setSelected(false);
        });

        //save all  
        saveButton.setOnAction((var e) -> {
            if ("".equals(nameTextField.getText())
                    || "".equals(ageTextField.getText())
                    || "".equals(IDTextField.getText())
                    || "".equals(infTextField.getText())) {
                message.setText("Please fill all fields");

            } else {
                message.setText("");
            }
        });

        //DeleteButton
        DeleteButton.setOnAction(e -> {

            String childName = nameTextField.getText();
            String childAge = ageTextField.getText();
            String childDOB = datePicker.getValue().toString();
            String childID = IDTextField.getText();
            String childgen = boyRadioButton.getText();
            String childgen1 = girlRadioButton.getText();
            String childdis = infTextField.getText();
            String childGender = boyRadioButton.isSelected() ? "Boy" : "Girl";
            String childInfo = "Name: " + childName + "\nAge: " + childAge + "\nDate of Birth: " + childDOB
                    + "\nChild ID: " + childID + "\nGender: " + childgen + childgen1 + "\nDisease:" + childdis + childGender;

            listView2.getItems().remove(childName);
            listView3.getItems().remove(childID);
            listView4.getItems().remove(childAge);
            listView5.getItems().remove(childgen);
            listView6.getItems().remove(childgen1);
            listView6.getItems().remove(childdis);
            listViewInfo1.getItems().remove(childInfo);
        });

        //المشهد الثاني .............................................................................
        HBox hb1 = new HBox(20);
        TextField N = new TextField();
        Label L1 = new Label("Enter the name :         ");
        hb1.setPadding(new Insets(20, 20, 20, 20));
        Button b = new Button("Search");
        hb1.getChildren().addAll(L1, N, b);

        HBox Gender = new HBox(10);
        Gender.setAlignment(Pos.TOP_LEFT);
        ComboBox<String> Itemfilter = new ComboBox();
        Itemfilter.getItems().addAll("F", "G");
        Itemfilter.setValue("CHOOSE");

        //Gender.getChildren().addAll(new Label("Choose the gender of the child: "), Itemfilter);
        Text text1 = new Text("");
        text1.setFill(Color.BLUE);
        text1.setFont(Font.font("Comic Sans MS", 18));
        text1.setX(134);
        text1.setY(90);
        Pane p = new Pane();
        p.setPrefSize(400, 300);
        p.setStyle("-fx-border-color: black; -fx-border-width: 1px");
        p.getChildren().addAll(text1);

        // Inside your start() method, after creating the search button
        b.setOnAction(e -> {
            String childID = N.getText();

            for (int i = 0; i < listView3.getItems().size(); i++) {
                if (listView3.getItems().get(i).equals(childID)) {
                    String childName = listView2.getItems().get(i);
                    String childAge = listView4.getItems().get(i);
                    String gender = listView6.getItems().get(i);
                    String disease = listView5.getItems().get(i);

                    String childInfo = "Child Information:\n"
                            + "Name: " + childName + "\n"
                            + "Age: " + childAge + "\n"
                            + "Child ID: " + childID + "\n"
                            + "Gender: " + gender + "\n"
                            + "Disease: " + disease;

                    text1.setText(childInfo);
                    return; // Stop searching after finding the child
                }
            }

            // If the child with the provided ID is not found
            text1.setText("Child with ID " + childID + " not found.");
        });

        Button clearTextButton = new Button("Clear ");
        clearTextButton.setFont(Font.font("Comic Sans MS", 15));
        clearTextButton.setOnAction(e -> text1.setText(""));

        Button Back = new Button("Back");

        VBox v = new VBox(20);
        v.setPadding(new Insets(20, 20, 20, 70));

        Group g = new Group();
        g.getChildren().addAll(v);

        Scene scene2 = new Scene(g, 1050, 700);

        primaryStage.setTitle("s2");
        primaryStage.setScene(scene2);
        primaryStage.show();
        //...............................................................................................
        Slider Slider = new Slider();
        Slider.setPrefSize(270, 0);
        Slider.setMin(0);
        Slider.setMax(5);
        Slider.setValue(0);
        Slider.setShowTickLabels(true);
        Slider.setShowTickMarks(true);

        Slider.setMajorTickUnit(1);
        Slider.setMinorTickCount(1);
        Slider.setBlockIncrement(1);

        Button NEX = new Button(" NEXT ");
        NEX.setFont(Font.font("Comic Sans MS", 18));
        NEX.setAlignment(Pos.BOTTOM_RIGHT);
        NEX.setPadding(new Insets(16));

        NEX.setOnAction(e -> {

            primaryStage.setScene(scene2);
        });

        HBox bottomHBox = new HBox(10, evLabel, Slider, NEX);

        bottomHBox.setAlignment(Pos.CENTER);
        bottomHBox.setPadding(new Insets(5, 20, 40, 20));

        Pane leftpane = new Pane();
        leftpane.getChildren().addAll(infoVBox);

        Pane rightpane = new Pane();
        rightpane.getChildren().addAll(mlistVBox);

        BorderPane main = new BorderPane();
        BorderPane.setAlignment(TitleLabel, Pos.CENTER);
        main.setTop(TitleLabel);

        main.setLeft(leftpane);
        main.setRight(rightpane);
        main.setBottom(bottomHBox);

        Button displayAllButton = new Button("Display");
         displayAllButton.setFont(Font.font("Comic Sans MS", 15));

        displayAllButton.setOnAction(event -> {
            StringBuilder allChildInfo = new StringBuilder("All Child Information:\n");

            for (int i = 0; i < listView2.getItems().size(); i++) {
                String childName = listView2.getItems().get(i);
                String childAge = listView4.getItems().get(i);
                String childID = listView3.getItems().get(i);

                String childInfo = "Name: " + childName + "\nAge: " + childAge + "\nChild ID: " + childID + "\n\n";

                allChildInfo.append(childInfo);
            }

            text1.setText(allChildInfo.toString());
        });

        HBox h = new HBox(10,displayAllButton,clearTextButton);

        v.getChildren().addAll(hb1,h,p, Back);

        var scene1 = new Scene(new StackPane(imageView1, main), 1050, 700);

        Back.setOnAction(e -> {

            primaryStage.setScene(scene1);
        });
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    ////////////// 
    private ObservableList<String> getInformationForName(String name) {
        ObservableList<String> information = FXCollections.observableArrayList();
        switch (name) {
            case "Mona":

                information.add("6 am to 12 pm ,12 pm to 8 pm");

                break;

            case "Salmaa":
                information.add("7 am to 3 pm, 9pm to 2am");

                break;
            case "Hanaa":

                information.add(" 5 am to 9pm");
                break;
            case "Haneen":

                information.add(" 5 am to 9pm");

            default:
                information.add("No information available for " + name);
        }

        return information;

        // primaryStage.setTitle("Warehouse Inventory");
        //primaryStage.setScene(BabyDayCare);
        //primaryStage.show();
    }
    
    

    public static void main(String[] args) {
        launch();
    }

}