package com.example.Rejestrator.logic;

import com.example.Rejestrator.ChartApplication;
import com.example.Rejestrator.controllers.*;
import com.example.Rejestrator.enums.prevType;
import com.example.Rejestrator.info.Alerts;
import com.example.Rejestrator.model.Semen;
import com.example.Rejestrator.model.Donor;
import com.example.Rejestrator.service.DonorService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Functions {
    private static ConfigurableApplicationContext ctx = ChartApplication.getCtx();
    private static DonorService donorService = ctx.getBean(DonorService.class);


    public static void addNewSemen(String tag, Semen semen) {
        Donor donor = findDonorByTag(tag);
        donor.addSemen(semen);
        Collections.sort(donor.getSemenList());
        donorService.updateSemenList(donor);
        Alerts.semenSavedInfo();
    }


    public static List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    public static void deleteSemen(String tag, Semen semen) {
        com.example.Rejestrator.model.Donor donor = findDonorByTag(tag);
        donor.deleteSemen(semen);
        donorService.updateSemenList(donor);
        Alerts.semenDeletedInfo();
    }

    public static Donor findDonorByTag(String tag) {

        return donorService.findDonorByTag(tag);
    }

    public static Donor findDonorById(Long id) {
        return donorService.findDonorById(id);
    }


    public static void addNewDonor(com.example.Rejestrator.model.Donor donor) {
        if (!donorService.checkIfPresent(donor.getTag())) {
            donorService.saveDonor(donor);
        } else throw new IllegalArgumentException("Istnieje już dawca o podanym kolczyku");

    }

    public static void updateDonor(Donor donor, Long id) {
        donorService.updateDonor(donor, id);
    }


    public static void deleteDonor(Donor donor) {
        donorService.deleteDonor(donor);
    }


    public static LocalDate getDate(DatePicker date) {
        LocalDate toReturn = date.getValue();

        return toReturn;
    }


    public static <T> void undoFunction(T that, Bufor bufor, Stage stage) throws IOException {
        switch (bufor.getPrev()) {
            case MENU:

                FXMLLoader loader1 = new FXMLLoader(that.getClass().getResource("/fxml/menu.fxml"));
                Parent root1 = loader1.load();
                MenuController menuController = loader1.getController();
                Stage stage1 = new Stage();
                stage1.setTitle("Menu");
                stage1.setScene((new Scene(root1)));
                menuController.setStage(stage1);
                stage.close();
                stage1.show();
                break;

            case DONOR_INFO:
                FXMLLoader loader2 = new FXMLLoader(that.getClass().getResource("/fxml/donorInfo.fxml"));
                Parent root2 = loader2.load();
                DonorInfoController donorInfoController = loader2.getController();
                Stage stage2 = new Stage();
                stage2.setTitle("Informacje o dawcy");
                stage2.setScene((new Scene(root2)));
                donorInfoController.setStage(stage2);
                if (bufor.getPrevPrev() != null) {
                    bufor.setPrev(bufor.getPrevPrev());
                    bufor.setPrevPrev(prevType.MENU);
                } else {
                    bufor.setPrev(prevType.MENU);
                }
                donorInfoController.setBufor(bufor);
                donorInfoController.initData(bufor.getDonorDto(), stage2);
                stage.close();
                stage2.show();
                break;

            case DONOR_LIST:
                FXMLLoader loader3 = new FXMLLoader(that.getClass().getResource("/fxml/donorList.fxml"));
                Parent root3 = loader3.load();
                DonorListController donorListController = loader3.getController();
                Stage stage3 = new Stage();
                stage3.setTitle("Lista dawców");
                stage3.setScene((new Scene(root3)));
                donorListController.setStage(stage3);
                bufor.setPrev(bufor.getPrevPrev());
                bufor.setPrevPrev(null);
                donorListController.setBufor(bufor);
                donorListController.initData();
                stage.close();
                stage3.show();
                break;

            case SEMEN_LIST:
                FXMLLoader loader4 = new FXMLLoader(that.getClass().getResource("/fxml/semenList.fxml"));
                Parent root4 = loader4.load();
                SemenListController semenListController = loader4.getController();
                Stage stage4 = new Stage();
                stage4.setTitle("Informacje o dawcy");
                stage4.setScene((new Scene(root4)));
                semenListController.setStage(stage4);
                semenListController.setBufor(new Bufor(prevType.DONOR_INFO));
                bufor.setPrev(prevType.DONOR_INFO);
                semenListController.initData(bufor.getDonorDto());
                stage.close();
                stage4.show();
                break;
        }
    }
}

