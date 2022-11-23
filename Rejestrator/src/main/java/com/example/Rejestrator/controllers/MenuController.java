package com.example.Rejestrator.controllers;

import com.example.Rejestrator.enums.prevType;
import com.example.Rejestrator.info.Alerts;
import com.example.Rejestrator.logic.Functions;
import com.example.Rejestrator.model.Donor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class MenuController {

    @FXML
    public Button addNewDrawingButton;
    @FXML
    public TextField donorTagTextField;

    public Button addNewWithoutButton;
    @FXML
    public VBox v;
    @FXML
    Button seeAllButton;
    @FXML
    Button findButton;
    @FXML
    Button addNewButton;


    Stage stage;


    public void addNewDonor(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/newDonorWithSemen.fxml"));
        Parent root = loader.load();
        NewDonorWithSemenController donorController = loader.getController();
        Stage stage = new Stage();
        stage.setScene((new Scene(root)));
        stage.setTitle("Nowy dawca");
        donorController.setStage(stage);
        Bufor bufor = new Bufor(prevType.MENU);
        donorController.setBufor(bufor);
        this.stage = (Stage) v.getScene().getWindow();
        this.stage.close();
        stage.show();


    }

    public void showAll(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/donorList.fxml"));
        Parent root = loader.load();
        DonorListController donorListController = loader.getController();
        Stage stage = new Stage();
        stage.setScene((new Scene(root)));
        stage.setTitle("Lista dawców");
        donorListController.setStage(stage);
        Bufor bufor = new Bufor(prevType.MENU);
        donorListController.setBufor(bufor);
        donorListController.initData();
        this.stage = (Stage) v.getScene().getWindow();
        this.stage.close();
        stage.show();

    }

    public void findDonor(ActionEvent actionEvent) {
        if (donorTagTextField.getText().isEmpty()) {
            Alerts.donorNotFound();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/donorInfo.fxml"));
                Parent root = null;
                root = loader.load();
                Stage stage = new Stage();
                stage.setScene((new Scene(root)));
                DonorInfoController donorInfoController = loader.<DonorInfoController>getController();
                Donor donor = Functions.findDonorByTag(donorTagTextField.getText().trim());
                donorInfoController.initData(donor, stage);
                Bufor bufor = new Bufor(prevType.MENU);
                donorInfoController.setBufor(bufor);
                stage.setTitle("Informacje o dawcy");
                this.stage = (Stage) v.getScene().getWindow();
                this.stage.close();
                stage.show();
            } catch (IOException | NullPointerException e) {
                // alert.show();
                e.printStackTrace();
                Alerts.donorNotFound();
            }

        }
        //donorInfoController.initData(donorDto);

//        try {
//            RandomGenerator.getWord(10);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    public void addNewDrawing(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Podaj kolczyk");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");
        if (donorTagTextField.getText().isEmpty()) {
            Alerts.donorNotFound();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/newSemen.fxml"));
                Parent root = null;
                root = loader.load();
                Stage stage = new Stage();
                stage.setScene((new Scene(root)));
                NewSemenController newSemenController = loader.<NewSemenController>getController();
                Donor donor = Functions.findDonorByTag(donorTagTextField.getText());
                newSemenController.initData(donor);
                Bufor bufor = new Bufor(prevType.MENU);
                newSemenController.setBufor(bufor);
                stage.setTitle("Nowe pobranie");
                newSemenController.setStage(stage);
                this.stage = (Stage) v.getScene().getWindow();
                this.stage.close();
                stage.show();
            } catch (IOException | NullPointerException e) {
                Alerts.donorNotFound();
            }
        }
    }

    public void addNewDonorWithout(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/newDonor.fxml"));
        Parent root = loader.load();
        NewDonorController donorController = loader.getController();
        Stage stage = new Stage();
        stage.setScene((new Scene(root)));
        stage.setTitle("Nowy dawca");
        donorController.setStage(stage);
        Bufor bufor = new Bufor(prevType.MENU);
        donorController.setBufor(bufor);
        this.stage = (Stage) v.getScene().getWindow();
        this.stage.close();
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
