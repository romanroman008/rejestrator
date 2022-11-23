package com.example.Rejestrator.controllers;

import com.example.Rejestrator.enums.prevType;
import com.example.Rejestrator.logic.Functions;
import com.example.Rejestrator.model.Donor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class DonorListController {

    ObservableList list = FXCollections.observableArrayList();
    Stage stage;
    @FXML
    Button returnButton;
    @FXML
    private ListView<Donor> donorDtoListView;
    Bufor bufor = new Bufor();


    public void setBufor(Bufor bufor) {
        this.bufor = bufor;
    }

    public void setBuforDonor(Donor donor) {
        this.bufor.prevDonor = donor;
    }

    public void goBack() throws IOException {
        Functions.undoFunction(this, this.bufor, this.stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static class HBoxCell extends HBox {
        Label label = new Label();
        Button button = new Button();

        HBoxCell(String labelText, String buttonText) {
            super();

            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);

            button.setText(buttonText);

            this.getChildren().addAll(label, button);
        }
    }


    private void crateButtonList() {
        this.donorDtoListView.setCellFactory((Callback<ListView<Donor>, ListCell<Donor>>) param -> {
            return new ListCell<Donor>() {
                @Override
                protected void updateItem(Donor donor, boolean empty) {
                    super.updateItem(donor, empty);

                    if (donor == null || empty) {
                        setText(null);
                    } else {

                        HBox root = new HBox(10);
                        root.setAlignment(Pos.CENTER_LEFT);
                        root.setPadding(new Insets(5, 10, 5, 10));


                        Region region = new Region();
                        HBox.setHgrow(region, Priority.ALWAYS);
                        root.getChildren().add(region);


                        Label numberOfCertificate = new Label(donor.getNumberOfCertificate());
                        Label studbookName = new Label(donor.getStudbookName());
                        Label donorBreedName = new Label(donor.getDonorBreedName());
                        Label tag = new Label(donor.getTag());
                        numberOfCertificate.setMaxWidth(Double.MAX_VALUE);
                        studbookName.setMaxWidth(Double.MAX_VALUE);
                        donorBreedName.setMaxWidth(Double.MAX_VALUE);
                        tag.setMaxWidth(Double.MAX_VALUE);
                        HBox.setHgrow(numberOfCertificate, Priority.ALWAYS);
                        HBox.setHgrow(studbookName, Priority.ALWAYS);
                        HBox.setHgrow(donorBreedName, Priority.ALWAYS);
                        HBox.setHgrow(tag, Priority.ALWAYS);
                        root.getChildren().addAll(numberOfCertificate, studbookName, donorBreedName, tag);


                        Button btnShowDetails = new Button("Szczegóły");
                        btnShowDetails.setOnAction(event -> {
                            // Code to add friend
                            try {
                                showDetails(donor);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                        Button btnAddFriend = new Button("Aktualizuj");
                        btnAddFriend.setOnAction(event -> {
                            // Code to add friend
                            try {
                                updateDonor(donor);  //trycatche
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        Button btnRemove = new Button("Usuń");
                        btnRemove.setOnAction(event -> {   ///aleerty w functionbs
                            // Code to remove friend
                            deleteDonor(donor);
                            System.out.println("Broke up with !");
                        });
                        root.getChildren().addAll(btnShowDetails, btnAddFriend, btnRemove);

                        // Finally, set our cell to display the root HBox
                        setText(null);
                        setGraphic(root);
                    }

                }
            };

        });
    }

    public void generateSelected(ActionEvent actionEvent) throws IOException {

        // View.createSelectedPdf(donorDto,semenListToGenerate);
    }


    private void deleteDonor(com.example.Rejestrator.model.Donor donor) {
        Functions.deleteDonor(donor);
        list.remove(donor);
        donorDtoListView.getItems().remove(donor);
        crateButtonList();
    }


    private void updateDonor(com.example.Rejestrator.model.Donor donor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/updateDonor.fxml"));
        Parent root = loader.load();
        UpdateDonorController donorController = loader.getController();
        Stage stage = new Stage();
        stage.setScene((new Scene(root)));
        stage.setTitle("Aktualizowanie dawcy");
        donorController.setStage(stage);
        Functions.findDonorByTag(donor.getTag());
        donorController.initData(donor);
        Bufor bufor = new Bufor(prevType.DONOR_LIST);
        bufor.setPrevPrev(prevType.MENU);
        donorController.setBufor(bufor);
        stage.show();
        this.stage.close();
    }


    private void showDetails(com.example.Rejestrator.model.Donor donor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/donorInfo.fxml"));
        Parent root = null;
        root = loader.load();
        Stage stage = new Stage();
        stage.setScene((new Scene(root)));
        DonorInfoController donorInfoController = loader.<DonorInfoController>getController();
        donorInfoController.initData(donor, stage);
        stage.setTitle("Informacje o dawcy");
        Bufor bufor = (new Bufor(prevType.DONOR_LIST));
        bufor.setPrevPrev(prevType.MENU);
        donorInfoController.setBufor(bufor);
        donorInfoController.setBuforDonor(donor);
        stage.show();
        this.stage.close();
    }


    public void initData() {
        Functions.getAllDonors().stream().forEach(e -> list.add(e));
        ;
        donorDtoListView.getItems().addAll(list);
        crateButtonList();

    }


}
