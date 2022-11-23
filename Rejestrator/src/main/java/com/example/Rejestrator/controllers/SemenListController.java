package com.example.Rejestrator.controllers;

import com.example.Rejestrator.enums.prevType;
import com.example.Rejestrator.info.Alerts;
import com.example.Rejestrator.logic.Functions;
import com.example.Rejestrator.model.Donor;
import com.example.Rejestrator.view.View;
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
import com.example.Rejestrator.model.Semen;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SemenListController {

    public Button returnButton;
    ObservableList list = FXCollections.observableArrayList();
    List<Semen> semenListToGenerate = new ArrayList<>();
    private Donor donor;
    Stage stage;
    @FXML
    private ListView<Semen> semenListView;

    Bufor bufor = new Bufor();
    ;


    public void setBufor(Bufor bufor) {
        this.bufor = bufor;
    }

    public void setBuforDonor(Donor donor) {
        this.bufor.prevDonor = donor;
    }


    public void goBack() throws IOException {
        Functions.undoFunction(this, this.bufor, this.stage);
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

    //    public void createContent(List<SemenDto> semenList,String tag) {
//
//
//        List<HBoxCell> list = new ArrayList<>();
//        for (int i = 0; i < semenList.size(); i++) {
//            list.add(new HBoxCell(semenList.get(i).toString(), "Button " + i));
//            list.get(i).button.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    Functions.deleteSemen(tag,semenList.get(i));
//                }
//            });
//           // Functions.deleteSemen(tag,semenList.get(i))
//        }
//
//        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
//        this.lista.setItems(myObservableList);
//
//
//    }
//    void addButton(String label, ActionListener action) {
//        // simple method adds a button with an actionPerformed
//        JButton b = new JButton(label);
//        b.addActionListener(action);
//    }
    private void crateButtonList(String tag) {
        this.semenListView.setCellFactory((Callback<ListView<Semen>, ListCell<Semen>>) param -> {
            return new ListCell<Semen>() {
                @Override
                protected void updateItem(Semen semen, boolean empty) {
                    super.updateItem(semen, empty);

                    if (semen == null || empty) {
                        setText(null);
                    } else {
                        // Here we can build the layout we want for each ListCell. Let's use a HBox as our root.
                        HBox root = new HBox(10);
                        root.setAlignment(Pos.CENTER_LEFT);
                        root.setPadding(new Insets(5, 10, 5, 10));

                        // Within the root, we'll show the username on the left and our two buttons to the right
                        root.getChildren().add(new Label(semen.getColor()));
                        root.getChildren().add(new Label(semen.getColorB()));
                        root.getChildren().add(new Label(String.valueOf(semen.getAmount())));
                        root.getChildren().add(new Label(String.valueOf(semen.getDate())));
                        root.getChildren().add(new Label(semen.getRecipientName()));
                        root.getChildren().add(new Label(semen.getRecipientAddress()));

                        Label color = new Label(semen.getColor());
                        Label colorB = new Label(semen.getColorB());
                        Label amount = new Label(String.valueOf(semen.getAmount()));
                        Label date = new Label(String.valueOf(semen.getDate()));
                        Label recipientName = new Label(semen.getRecipientName());
                        Label recipientAddress = new Label(semen.getRecipientAddress());
                        color.setMaxWidth(Double.MAX_VALUE);
                        colorB.setMaxWidth(Double.MAX_VALUE);
                        amount.setMaxWidth(Double.MAX_VALUE);
                        date.setMaxWidth(Double.MAX_VALUE);
                        recipientName.setMaxWidth(Double.MAX_VALUE);
                        recipientAddress.setMaxWidth(Double.MAX_VALUE);
                        HBox.setHgrow(color, Priority.ALWAYS);
                        HBox.setHgrow(colorB, Priority.ALWAYS);
                        HBox.setHgrow(amount, Priority.ALWAYS);
                        HBox.setHgrow(date, Priority.ALWAYS);
                        HBox.setHgrow(recipientName, Priority.ALWAYS);
                        HBox.setHgrow(recipientAddress, Priority.ALWAYS);

                        root.getChildren().addAll(color, colorB, amount, date, recipientName, recipientAddress);


                        Region region = new Region();
                        HBox.setHgrow(region, Priority.ALWAYS);
                        root.getChildren().add(region);


                        CheckBox checkBox = new CheckBox("Zaznacz");
                        checkBox.selectedProperty().addListener((observable -> {
                            if (checkBox.isSelected())
                                semenListToGenerate.add(semen);
                            else
                                semenListToGenerate.remove(semen);
                        }));


                        Button btnAddFriend = new Button("Aktualizuj");
                        btnAddFriend.setOnAction(event -> {
                            try {
                                updateSemen(semen);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Added " + semen.getColor() + " as a friend!");
                        });
                        Button btnRemove = new Button("Usuń");
                        btnRemove.setOnAction(event -> {
                            deleteSemen(semen);
                            System.out.println("Broke up with " + semen.getColor() + "!");
                        });
                        root.getChildren().addAll(checkBox, btnAddFriend, btnRemove);


                        setText(null);
                        setGraphic(root);
                    }

                }
            };

        });
    }

    public void generateSelected(ActionEvent actionEvent) throws IOException {

        View.createSelectedPdf(donor, semenListToGenerate);
        Alerts.pdfCreatedInfo();
    }


    private void deleteSemen(Semen semen) {
        Functions.deleteSemen(this.donor.getTag(), semen);
        list.remove(semen);
        semenListView.getItems().remove(semen);

        this.donor.getSemenList().remove(semen);
        semenListView.getItems().remove(semen);
        crateButtonList(donor.getTag());
    }


    private void updateSemen(Semen semen) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/updateSemen.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene((new Scene(root)));
        UpdateSemenController updateSemenController = loader.<UpdateSemenController>getController();
        updateSemenController.stage = stage;
        updateSemenController.initData(this.donor, semen);
        stage.setTitle("Stary dawca");
        stage.show();
        Bufor bufor = new Bufor(prevType.SEMEN_LIST);
        bufor.setDonorDto(this.donor);
        updateSemenController.setBufor(bufor);
        this.stage.close();

    }


    public void initData(Donor donor) {

        this.donor = donor;
        donor.getSemenList().stream().forEach(e -> list.add(e));
        semenListView.getItems().addAll(list);
        bufor.setDonorDto(donor);
        crateButtonList(donor.getTag());


    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
