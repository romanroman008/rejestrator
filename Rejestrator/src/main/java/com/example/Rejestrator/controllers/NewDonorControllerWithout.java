package com.example.Rejestrator.controllers;

import com.example.Rejestrator.info.Alerts;
import com.example.Rejestrator.logic.Functions;
import com.example.Rejestrator.model.Donor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class NewDonorControllerWithout {
    public Button returnButton;
    @FXML
    private Button guzior;





    @FXML
    private TextField numberOfCertificate;
    @FXML
    private TextField year;
    @FXML
    private TextArea studbookName;
    @FXML
    private TextArea donorBreedName;



    @FXML
    private TextArea tag;
    @FXML
    private TextArea name;
    @FXML
    private TextArea growerName;
    @FXML
    private TextArea growerAddress;
    @FXML
    private TextArea ownerName;
    @FXML
    private TextArea ownerAddress;
    @FXML
    private TextArea method;
    @FXML
    private TextArea placeOfBirth;

//    private TextField tag;
//    @FXML
//    private TextField name;
//    @FXML
//    private TextField growerName;
//    @FXML
//    private TextField growerAddress;
//    @FXML
//    private TextField ownerName;
//    @FXML
//    private TextField ownerAddress;
//    @FXML
//    private TextField method;
//    @FXML
//    private TextField placeOfBirth;



    @FXML
    private DatePicker timeOfBirth;
    @FXML
    private TextArea motherNumber;
    @FXML
    private TextArea motherName;
    @FXML
    private TextArea fatherNumber;
    @FXML
    private TextArea fatherName;
    @FXML
    private TextArea grandfatherFatherNumber;
    @FXML
    private TextArea grandfatherFatherName;
    @FXML
    private TextArea grandmotherFatherNumber;
    @FXML
    private TextArea grandmotherFatherName;
    @FXML
    private TextArea grandfatherMotherNumber;
    @FXML
    private TextArea grandfatherMotherName;
    @FXML
    private TextArea grandmotherMotherNumber;
    @FXML
    private TextArea grandmotherMotherName;

    Stage stage;
    Bufor bufor=new Bufor();;


    public void setBufor(Bufor bufor){
        this.bufor=bufor;
    }
    public void setBuforDonor(Donor donor){
        this.bufor.prevDonor = donor;
    }


    public void goBack() throws IOException {
        Functions.undoFunction(this,bufor,this.stage);
    }

    public void initialize() {



        numberOfCertificate.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    year.requestFocus();
                }
                if(numberOfCertificate.isFocused())
                    numberOfCertificate.setStyle("-fx-background-color: white");
            }
        });
        year.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    studbookName.requestFocus();
                }
                if(year.isFocused())
                    year.setStyle("-fx-background-color: white");
            }
        });
        studbookName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    donorBreedName.requestFocus();
                }
                if(studbookName.isFocused())
                    studbookName.setStyle("-fx-background-color: white");
            }
        });
        donorBreedName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tag.requestFocus();
                }
                if(donorBreedName.isFocused())
                    donorBreedName.setStyle("-fx-background-color: white");
            }
        });
        /*numberBook.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tag.requestFocus();
                }
            }
        });*/
        tag.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    name.requestFocus();
                }
                if(tag.isFocused())
                    tag.setStyle("-fx-background-color: white");
            }
        });
        name.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    timeOfBirth.requestFocus();
                }
                if(name.isFocused())
                    name.setStyle("-fx-background-color: white");
            }
        });
        timeOfBirth.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    placeOfBirth.requestFocus();
                }
                if(timeOfBirth.isFocused())
                    timeOfBirth.setStyle("-fx-background-color: white");
            }
        });
        placeOfBirth.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    growerName.requestFocus();
                }
                if(placeOfBirth.isFocused())
                    placeOfBirth.setStyle("-fx-background-color: white");
            }
        });
        growerName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    growerAddress.requestFocus();
                }
                if(growerName.isFocused())
                    growerName.setStyle("-fx-background-color: white");
            }
        });
        growerAddress.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    ownerName.requestFocus();
                }
                if(growerAddress.isFocused())
                    growerAddress.setStyle("-fx-background-color: white");
            }
        });
        ownerName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    ownerAddress.requestFocus();
                }
                if(ownerName.isFocused())
                    ownerName.setStyle("-fx-background-color: white");
            }
        });
        ownerAddress.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    method.requestFocus();
                }
                if(ownerAddress.isFocused())
                    ownerAddress.setStyle("-fx-background-color: white");
            }
        });
        method.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    fatherNumber.requestFocus();
                }
                if(method.isFocused())
                    method.setStyle("-fx-background-color: white");
            }
        });
        fatherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    fatherName.requestFocus();
                } if(fatherNumber.isFocused())
                    fatherNumber.setStyle("-fx-background-color: white");
            }
        });
        fatherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    motherNumber.requestFocus();
                }if(fatherName.isFocused())
                    fatherName.setStyle("-fx-background-color: white");
            }
        });
        motherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    motherName.requestFocus();
                }
                if(motherNumber.isFocused())
                    motherNumber.setStyle("-fx-background-color: white");
            }
        });
        motherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandfatherFatherNumber.requestFocus();
                }
                if(motherName.isFocused())
                    motherName.setStyle("-fx-background-color: white");
            }
        });
        grandfatherFatherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandfatherFatherName.requestFocus();
                }
                if(grandfatherFatherNumber.isFocused())
                    grandfatherFatherNumber.setStyle("-fx-background-color: white");
            }
        });
        grandfatherFatherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandmotherFatherNumber.requestFocus();
                }
                if(grandfatherFatherName.isFocused())
                    grandfatherFatherName.setStyle("-fx-background-color: white");
            }
        });
        grandmotherFatherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandmotherFatherName.requestFocus();
                }
                if(grandmotherFatherNumber.isFocused())
                    grandmotherFatherNumber.setStyle("-fx-background-color: white");
            }
        });
        grandmotherFatherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandfatherMotherNumber.requestFocus();
                }
                if(grandmotherFatherName.isFocused())
                    grandmotherFatherName.setStyle("-fx-background-color: white");
            }
        });
        grandfatherMotherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandfatherMotherName.requestFocus();
                }
                if(grandfatherMotherNumber.isFocused())
                    grandfatherMotherNumber.setStyle("-fx-background-color: white");
            }
        });
        grandfatherMotherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandmotherMotherNumber.requestFocus();
                }
                if(grandfatherMotherName.isFocused())
                    grandfatherMotherName.setStyle("-fx-background-color: white");
            }
        });
        grandmotherMotherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandmotherMotherName.requestFocus();
                }
                if(grandmotherMotherNumber.isFocused())
                    grandmotherMotherNumber.setStyle("-fx-background-color: white");
            }
        });
        grandmotherMotherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                   // grandmotherMotherName.requestFocus();
                }
                if(grandmotherMotherName.isFocused())
                    grandmotherMotherName.setStyle("-fx-background-color: white");
            }
        });


    }

    public void setStage(Stage stage){
        this.stage=stage;
    }

    public void saveNewDonor(ActionEvent actionEvent) {

        Popup popup=new Popup();
        popup.getContent().add(new Label("Udało się"));




        //  if(this.numberOfCertificate.getText().trim().isEmpty()){
        //   this.numberOfCertificate.setStyle("-fx-background-color: green");




        // String numberBookText= amount.getText();

        TextArea [] values= new TextArea[]{this.studbookName, this.donorBreedName,
                this.tag, this.name, this.placeOfBirth, this.growerName, this.growerAddress,
                this.ownerName, this.ownerAddress, this.method, this.fatherNumber,
                this.fatherName, this.motherNumber, this.motherName, this.grandfatherFatherNumber,
                this.grandfatherFatherName, this.grandmotherFatherNumber, this.grandmotherFatherName,
                this.grandfatherMotherNumber, this.grandfatherMotherName,
                this.grandmotherMotherNumber, this.grandmotherMotherName};

        boolean isEmpty = false;

        if(this.numberOfCertificate.getText().trim().isEmpty()) {
            this.numberOfCertificate.setStyle("-fx-background-color: red");
            isEmpty=true;
        }
        if(this.year.getText().trim().isEmpty()) {
            this.year.setStyle("-fx-background-color: red");
            isEmpty=true;
        }

        if(this.timeOfBirth.getValue()==null) {
            this.timeOfBirth.setStyle("-fx-background-color: red");
            isEmpty=true;
        }


        for (TextArea value : values) {
            if(value.getText().trim().isEmpty()) {
                value.setStyle("-fx-background-color: red");
                isEmpty = true;
            }
        }


        if(isEmpty){
            Alerts.dataError();
        }
        else {

            String numberOfCertificate= this.numberOfCertificate.getText().trim();
            String year= this.numberOfCertificate.getText().trim();

            numberOfCertificate=new StringBuilder(numberOfCertificate).append("/").append(year).toString();
            String studbookName=this.studbookName.getText();
            String donorBreedName=this.donorBreedName.getText();

            String tag=this.tag.getText().trim().trim();
            String name=this.name.getText().trim();
            LocalDate date2 = Functions.getDate(this.timeOfBirth);
            String placeOfBirth=this.placeOfBirth.getText().trim();
            String growerName=this.growerName.getText();
            String growerAddress=this.growerAddress.getText();
            String ownerName=this.ownerName.getText();
            String ownerAddress=this.ownerAddress.getText();
            String method=this.method.getText();

            String fatherNumber=this.fatherNumber.getText();
            String fatherName=this.fatherName.getText();
            String motherNumber=this.motherNumber.getText();
            String motherName=this.motherName.getText();
            String grandfatherFatherNumber=this.grandfatherFatherNumber.getText();
            String grandfatherFatherName=this.grandfatherFatherName.getText();
            String grandmotherFatherNumber=this.grandmotherFatherNumber.getText();
            String grandmotherFatherName=this.grandmotherFatherName.getText();
            String grandfatherMotherNumber=this.grandfatherMotherNumber.getText();
            String grandfatherMotherName=this.grandfatherMotherName.getText();
            String grandmotherMotherNumber=this.grandmotherMotherNumber.getText();
            String grandmotherMotherName=this.grandmotherMotherName.getText();





            com.example.Rejestrator.model.Donor donor = new com.example.Rejestrator.model.Donor(tag,numberOfCertificate.trim(), studbookName,
                    donorBreedName, name,
                    growerName, growerAddress,
                    ownerName, ownerAddress,
                    method, placeOfBirth, date2,fatherNumber, fatherName,
                    motherNumber, motherName,
                    grandfatherFatherNumber, grandfatherFatherName,
                    grandmotherFatherNumber, grandmotherFatherName,
                    grandfatherMotherNumber, grandfatherMotherName,
                    grandmotherMotherNumber, grandmotherMotherName);


            try {
                Functions.addNewDonor(donor);
                //ggthis.stage.close();
            }catch(IllegalArgumentException e){
                Alerts.donorAlreadyExist();
            }


            clearIt();
        }

    }


    private void clearIt(){
        numberOfCertificate.clear();
        year.clear();
        studbookName.clear();
        donorBreedName.clear();
        tag.clear();
        name.clear();
        timeOfBirth.setValue(LocalDate.of(2022  ,4,1));
        placeOfBirth.clear();
        growerName.clear();
        growerAddress.clear();
        ownerName.clear();
        ownerAddress.clear();
        method.clear();
        fatherNumber.clear();
        fatherName.clear();
        motherNumber.clear();
        motherName.clear();
        grandfatherFatherNumber.clear();
        grandfatherFatherName.clear();
        grandmotherFatherNumber.clear();
        grandmotherFatherName.clear();
        grandfatherMotherNumber.clear();
        grandfatherMotherName.clear();
        grandmotherMotherNumber.clear();
        grandmotherMotherName.clear();
    }
}


