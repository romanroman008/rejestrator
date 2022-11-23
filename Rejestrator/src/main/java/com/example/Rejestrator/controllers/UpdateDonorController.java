package com.example.Rejestrator.controllers;

import com.example.Rejestrator.enums.prevType;
import com.example.Rejestrator.logic.Functions;
import com.example.Rejestrator.model.Donor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.time.LocalDate;

@Controller
public class UpdateDonorController {
    @FXML
    public Button returnButton;
    @FXML
    public Button guzior;


    @FXML
    private VBox stronaGlowna;


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
    @FXML
    private TextArea color;
    @FXML
    private TextArea colorB;
    @FXML
    private TextArea amount;
    @FXML
    private TextArea placeOfDrawing;
    @FXML
    private DatePicker date;
    @FXML
    private TextArea others;
    @FXML
    private TextArea recipientName;
    @FXML
    private TextArea recipientAddress;

    Stage stage;
    Donor donor;
    Bufor bufor = new Bufor();
    ;


    public void setBufor(Bufor bufor) {
        this.bufor = bufor;
    }

    public void setBuforDonor(Donor donor) {
        this.bufor.prevDonor = donor;
    }


    public void goBack() throws IOException {
        Functions.undoFunction(this, bufor, this.stage);
    }

    public void initialize() {


        numberOfCertificate.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    year.requestFocus();
                }
                if (numberOfCertificate.isFocused())
                    numberOfCertificate.setStyle("-fx-background-color: white");
            }
        });
        year.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    studbookName.requestFocus();
                }
            }
        });
        studbookName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    donorBreedName.requestFocus();
                }
            }
        });
        donorBreedName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tag.requestFocus();
                }
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
            }
        });
        name.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    timeOfBirth.requestFocus();
                }
            }
        });
        timeOfBirth.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    placeOfBirth.requestFocus();
                }
            }
        });
        placeOfBirth.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    growerName.requestFocus();
                }
            }
        });
        growerName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    growerAddress.requestFocus();
                }
            }
        });
        growerAddress.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    ownerName.requestFocus();
                }
            }
        });
        ownerName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    ownerAddress.requestFocus();
                }
            }
        });
        ownerAddress.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    method.requestFocus();
                }
            }
        });
        method.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    fatherNumber.requestFocus();
                }
            }
        });
        fatherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    fatherName.requestFocus();
                }
            }
        });
        fatherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    motherNumber.requestFocus();
                }
            }
        });
        motherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    motherName.requestFocus();
                }
            }
        });
        motherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandfatherFatherNumber.requestFocus();
                }
            }
        });
        grandfatherFatherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandfatherFatherName.requestFocus();
                }
            }
        });
        grandfatherFatherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandmotherFatherNumber.requestFocus();
                }
            }
        });
        grandmotherFatherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandmotherFatherName.requestFocus();
                }
            }
        });
        grandmotherFatherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandfatherMotherNumber.requestFocus();
                }
            }
        });
        grandfatherMotherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandfatherMotherName.requestFocus();
                }
            }
        });
        grandfatherMotherName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandmotherMotherNumber.requestFocus();
                }
            }
        });
        grandmotherMotherNumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    grandmotherMotherName.requestFocus();
                }
            }
        });

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initData(Donor donor) {
        String string = donor.getNumberOfCertificate();
        numberOfCertificate.setText(string.substring(0, string.indexOf('/')));
        year.setText(string.substring(string.indexOf('/')));
        studbookName.setText(donor.getStudbookName());
        donorBreedName.setText(donor.getDonorBreedName());
        tag.setText(donor.getTag());
        name.setText(donor.getName());
        timeOfBirth.setValue(donor.getTimeOfBirth());
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
        this.donor = donor;
        this.bufor.setDonorDto(this.donor);

    }


    public void saveNewDonor(ActionEvent actionEvent) {

        Popup popup = new Popup();
        popup.getContent().add(new Label("Udało się"));


        //  if(this.numberOfCertificate.getText().trim().isEmpty()){
        //   this.numberOfCertificate.setStyle("-fx-background-color: green");


        // String numberBookText= amount.getText();

        TextArea[] values = new TextArea[]{this.studbookName, this.donorBreedName,
                this.tag, this.name, this.placeOfBirth, this.growerName, this.growerAddress,
                this.ownerName, this.ownerAddress, this.method, this.fatherNumber,
                this.fatherName, this.motherNumber, this.motherName, this.grandfatherFatherNumber,
                this.grandfatherFatherName, this.grandmotherFatherNumber, this.grandmotherFatherName,
                this.grandfatherMotherNumber, this.grandfatherMotherName,
                this.grandmotherMotherNumber, this.grandmotherMotherName};

        boolean isEmpty = false;

        if (this.numberOfCertificate.getText().trim().isEmpty()) {
            this.numberOfCertificate.setStyle("-fx-background-color: red");
            isEmpty = true;
        }
        if (this.year.getText().trim().isEmpty()) {
            this.year.setStyle("-fx-background-color: red");
            isEmpty = true;
        }

        if (this.timeOfBirth.getValue() == null) {
            this.timeOfBirth.setStyle("-fx-background-color: red");
            isEmpty = true;
        }

        for (TextArea value : values) {
            if (value.getText().trim().isEmpty()) {
                value.setStyle("-fx-background-color: red");
                isEmpty = true;
            }
        }


        if (isEmpty) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Błąd");
            alert.setHeaderText("Nie wpisano wszystkich danych");
            alert.show();
        } else {

            String numberOfCertificate = this.numberOfCertificate.getText().trim();
            String year = this.numberOfCertificate.getText().trim();

            numberOfCertificate = new StringBuilder(numberOfCertificate).append("/").append(year).toString();
            String studbookName = this.studbookName.getText();
            String donorBreedName = this.donorBreedName.getText();

            String tag = this.tag.getText().trim();
            String name = this.name.getText();
            LocalDate date2 = Functions.getDate(this.timeOfBirth);
            String placeOfBirth = this.placeOfBirth.getText();
            String growerName = this.growerName.getText();
            String growerAddress = this.growerAddress.getText();
            String ownerName = this.ownerName.getText();
            String ownerAddress = this.ownerAddress.getText();
            String method = this.method.getText();

            String fatherNumber = this.fatherNumber.getText();
            String fatherName = this.fatherName.getText();
            String motherNumber = this.motherNumber.getText();
            String motherName = this.motherName.getText();
            String grandfatherFatherNumber = this.grandfatherFatherNumber.getText();
            String grandfatherFatherName = this.grandfatherFatherName.getText();
            String grandmotherFatherNumber = this.grandmotherFatherNumber.getText();
            String grandmotherFatherName = this.grandmotherFatherName.getText();
            String grandfatherMotherNumber = this.grandfatherMotherNumber.getText();
            String grandfatherMotherName = this.grandfatherMotherName.getText();
            String grandmotherMotherNumber = this.grandmotherMotherNumber.getText();
            String grandmotherMotherName = this.grandmotherMotherName.getText();


            Donor donor = new Donor(tag, numberOfCertificate.trim(), studbookName,
                    donorBreedName, name,
                    growerName, growerAddress,
                    ownerName, ownerAddress,
                    method, placeOfBirth, date2, fatherNumber, fatherName,
                    motherNumber, motherName,
                    grandfatherFatherNumber, grandfatherFatherName,
                    grandmotherFatherNumber, grandmotherFatherName,
                    grandfatherMotherNumber, grandfatherMotherName,
                    grandmotherMotherNumber, grandmotherMotherName);

            // DonorDao dao=ctx.getBean(DonorDao.class);
            // SemenDao semenDao=ctx.getBean(SemenDao.class);
            // dao.save(donor);
            // semenDao.save(semen);
            //SemenService semenService=ctx.getBean(SemenService.class);
            //semenService.add(semenDto);

            Functions.updateDonor(donor, this.donor.getId());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml1/donorInfo.fxml"));
            Parent root = null;
            try {
                root = loader.load();
                Stage stage = new Stage();
                stage.setScene((new Scene(root)));
                DonorInfoController donorInfoController = loader.<DonorInfoController>getController();
                Bufor bufor = new Bufor(prevType.DONOR_LIST);
                bufor.setPrevPrev(prevType.MENU);
                donorInfoController.setBufor(bufor);
                //  donorInfoController.setStage(stage);
                donorInfoController.initData(donor, stage);
                stage.setTitle("Dawca");
                stage.show();
                this.stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // popup.show(this.stage);
    }


}
