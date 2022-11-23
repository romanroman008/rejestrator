package com.example.Rejestrator.controllers;

import com.example.Rejestrator.info.Alerts;
import com.example.Rejestrator.logic.Functions;
import com.example.Rejestrator.model.Donor;
import com.example.Rejestrator.model.Semen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class NewSemenController {
    @FXML
    public TextArea color;
    @FXML
    public TextArea colorB;
    @FXML
    public TextArea amount;
    @FXML
    public TextArea placeOfDrawing;
    @FXML
    public DatePicker date;
    @FXML
    public TextArea others;
    @FXML
    public TextArea recipientName;
    @FXML
    public TextArea recipientAddress;
    @FXML
    public Button addNewDrawingButton;
    @FXML
    public Button returnButton;
    @FXML
    private ListView<Semen> list;
            
            
    ObservableList listO= FXCollections.observableArrayList();

    private Donor donor;


    Stage stage;


    Bufor bufor=new Bufor();;


    public void setBufor(Bufor bufor){
        this.bufor=bufor;
    }
    public void setBuforDonor(Donor donor){
        this.bufor.prevDonor = donor;
    }


    public void goBack() throws IOException {
        Functions.undoFunction(this,this.bufor,this.stage);
    }

    public void initData(Donor donor) {
        this.donor = donor;
        loadData();

        color.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    colorB.requestFocus();
                }
                if(color.isFocused())
                    color.setStyle("-fx-background-color: white");
            }
        });
        colorB.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    amount.requestFocus();
                }
                if(colorB.isFocused())
                    colorB.setStyle("-fx-background-color: white");
            }
        });
        amount.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    placeOfDrawing.requestFocus();
                }
                if(amount.isFocused())
                    amount.setStyle("-fx-background-color: white");
            }
        });
        placeOfDrawing.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    date.requestFocus();
                }
                if(placeOfDrawing.isFocused())
                    placeOfDrawing.setStyle("-fx-background-color: white");
            }
        });
        date.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    others.requestFocus();
                }
                if(date.isFocused())
                    date.setStyle("-fx-background-color: white");
            }
        });
        others.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    recipientName.requestFocus();
                }
                if(others.isFocused())
                    others.setStyle("-fx-background-color: white");
            }
        });
        recipientName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    recipientAddress.requestFocus();
                }
                if(recipientName.isFocused())
                    recipientName.setStyle("-fx-background-color: white");
            }
        });
        recipientAddress.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if( recipientAddress.isFocused())
                    recipientAddress.setStyle("-fx-background-color: white");
            }
        });


    }
    private void loadData()
    {
        donor.getSemenList().stream().forEach(e->listO.add(e));
        list.getItems().addAll(listO);
    }

    public void addNewDrawing(ActionEvent actionEvent) {

        TextArea [] values= new TextArea[]{this.color,this.colorB,this.amount,
                this.placeOfDrawing,this.others,this.recipientName,this.recipientAddress};


        boolean isEmpty = false;

        if(this.date.getValue()==null) {
            this.date.setStyle("-fx-background-color: red");
            isEmpty=true;
        }
        for (TextArea value : values) {
            if(value.getText().trim().isEmpty()) {
                value.setStyle("-fx-background-color: red");   // /optymmailziacja
                isEmpty = true;
            }
        }

        try {
            Integer.parseInt(amount.getText().trim());
        }catch(NumberFormatException e){
            this.amount.setStyle("-fx-background-color: red");
            Alerts.invalidNumberError();
        }

        if(isEmpty){
            Alerts.dataError();
        }
        else {
            String color=this.color.getText();
            String colorB=this.colorB.getText();
            String amount=this.amount.getText();
            String placeOfDrawing=this.placeOfDrawing.getText();
            LocalDate date = Functions.getDate(this.date);
            String others=this.others.getText();
            String recipientName=this.recipientName.getText();
            String recipientAddress=this.recipientAddress.getText();

            Semen semen = new Semen(color, colorB,
                    Integer.parseInt(amount.trim()), placeOfDrawing, date,
                    others, recipientName, recipientAddress);
            listO.add(semen);
            list.getItems().add(semen);
            Functions.addNewSemen(this.donor.getTag(),semen);
            clearView();
        }



       // loadData();
    }

    private void clearView(){
        this.color.setText("");
        this.colorB.setText("");
        this.amount.setText("");
        this.placeOfDrawing.setText("");
        //this.date.setValue(semenDto.getDate());
        this.others.setText("");
        this.recipientName.setText("");
        this.recipientAddress.setText("");
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
}
