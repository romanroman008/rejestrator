package com.example.Rejestrator.controllers;

import com.example.Rejestrator.enums.prevType;
import com.example.Rejestrator.info.Alerts;
import com.example.Rejestrator.logic.Functions;
import com.example.Rejestrator.model.Donor;
import com.example.Rejestrator.view.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class DonorInfoController {

    @FXML
    public Button generateFileButton;
    @FXML
    public Label studbookName;
    @FXML
    public Label numberOfCertificate;
    @FXML
    public Label donorBreedName;
    @FXML
    public Label numberBook;
    @FXML
    public Label tag;
    @FXML
    public Label name;
    @FXML
    public Label timeOfBirth;
    @FXML
    public Label placeOfBirth;
    @FXML
    public Label growerName;
    @FXML
    public Label growerAddress;
    @FXML
    public Label ownerAddress;
    @FXML
    public Label ownerName;
    @FXML
    public Label method;
    @FXML
    public Label fatherNumber;
    @FXML
    public Label fatherName;
    @FXML
    public Label motherNumber;
    @FXML
    public Label motherName;
    @FXML
    public Label grandfatherFatherNumber;
    @FXML
    public Label grandfatherFatherName;
    @FXML
    public Label grandmotherFatherNumber;
    @FXML
    public Label grandmotherFatherName;
    @FXML
    public Label grandfatherMotherNumber;
    @FXML
    public Label grandfatherMotherName;
    @FXML
    public Label grandmotherMotherNumber;
    @FXML
    public Label grandmotherMotherName;
    @FXML
    public Button deleteDrawingButton;
    @FXML
    public Button deleteDonorButton;
    @FXML
    public Button updateDonorButton;


    private Donor donor;

    @FXML
    Button showAllSemenButton;
    @FXML
    Button addNewDrawingButton;
    @FXML
    Button returnButton;

    Stage stage;

    Bufor bufor=new Bufor();


    public void setBufor(Bufor bufor){
        this.bufor=bufor;
    }
    public void setBuforDonor(Donor donor){
        this.bufor.setDonorDto(donor);
    }

    public void goBack() throws IOException {
        Functions.undoFunction(this,bufor,this.stage);
    }


    public void showAllSemen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/semenList.fxml"));
        Parent root=loader.load();
        Stage stage=new Stage();
        stage.setScene((new Scene(root)));
        stage.setTitle("Pobrania");
        SemenListController semenListController=loader.getController();
        semenListController.setStage(stage);
        Bufor bufor=new Bufor(prevType.DONOR_INFO);
        bufor.setPrevPrev(this.bufor.getPrev());
        semenListController.setBufor(bufor);
        semenListController.initData(Functions.findDonorByTag(donor.getTag()));
        stage.show();
        this.stage.close();
    }


    public void initData(Donor donor, Stage stage) {
        this.donor = donor;
        numberOfCertificate.setText(donor.getNumberOfCertificate());
        studbookName.setText(donor.getStudbookName());
        donorBreedName.setText(donor.getDonorBreedName());
        numberBook.setText(donor.getTag());
        tag.setText(donor.getTag());
        name.setText(donor.getName());
        timeOfBirth.setText(String.valueOf(donor.getTimeOfBirth()));
        placeOfBirth.setText(donor.getPlaceOfBirth());
        growerName.setText(donor.getGrowerName());
        growerAddress.setText(donor.getGrowerAddress());
        ownerName.setText(donor.getOwnerName());
        ownerAddress.setText(donor.getGrowerAddress());
        method.setText(donor.getMethod());
        fatherNumber.setText(donor.getFatherNumber());
        fatherName.setText(donor.getFatherName());
        motherNumber.setText(donor.getMotherNumber());
        motherName.setText(donor.getMotherName());
        grandfatherFatherNumber.setText(donor.getGrandfatherFatherNumber());
        grandfatherFatherName.setText(donor.getGrandfatherFatherName());
        grandmotherFatherNumber.setText(donor.getGrandmotherFatherNumber());
        grandmotherFatherName.setText(donor.getGrandmotherFatherName());
        grandfatherMotherNumber.setText(donor.getGrandfatherMotherNumber());
        grandfatherMotherName.setText(donor.getGrandfatherMotherName());
        grandmotherMotherNumber.setText(donor.getGrandfatherMotherNumber());
        grandmotherMotherName.setText(donor.getGrandmotherMotherName());
        this.stage=stage;
        setBuforDonor(donor);

    }

    public void addNewDrawing(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/newSemen.fxml"));
        Parent root=loader.load();
        Stage stage=new Stage();
        stage.setScene((new Scene(root)));
        NewSemenController newSemenController=loader.<NewSemenController>getController();
        Donor donor = Functions.findDonorByTag(this.donor.getTag());
        Bufor bufor=new Bufor(prevType.DONOR_INFO);
        bufor.setDonorDto(this.donor);
        newSemenController.setStage(stage);
        bufor.setPrevPrev(this.bufor.getPrev());
        newSemenController.setBufor(bufor);
        newSemenController.initData(donor);
        stage.setTitle("Nowe pobranie");
        stage.show();
        this.stage.close();
    }

    public void generatePdf(ActionEvent actionEvent) throws IOException {
        try {
            View.createPdf(Functions.findDonorByTag(this.donor.getTag().trim()));
            Alerts.pdfCreatedInfo();
        }catch(FileNotFoundException e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Plik otwarty przez inny proces");
            alert.setHeaderText("Plik otwarty przez inny proces");
            alert.setContentText("Zamknij plik aby kontynuwaać");
            alert.show();
        }
    }

    public void deleteDonor(ActionEvent actionEvent) throws IOException {
        Functions.deleteDonor(donor);
        goBack();
        Alerts.donorDeletedInfo(donor.getTag());
    }

    public void updateDonor(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml123/updateDonor1.fxml"));
        Parent root = loader.load();
        UpdateDonorController donorController = loader.getController();
        Stage stage = new Stage();
        stage.setScene((new Scene(root)));
        stage.setTitle("Aktualizowanie dawcy");
        donorController.setStage(stage);
        Donor donor =Functions.findDonorByTag(this.donor.getTag());
        Bufor bufor=new Bufor(prevType.DONOR_INFO);
        bufor.setPrevPrev(this.bufor.getPrev());
        donorController.setBufor(bufor);
        donorController.initData(donor);
        stage.show();
        this.stage.close();



    }


    public void setStage(Stage stage){
        this.stage=stage;
    }
}
