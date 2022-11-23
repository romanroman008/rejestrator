package com.example.Rejestrator.info;

import javafx.scene.control.Alert;

public class Alerts {

    //INFO
    public static void donorSavedInfo(String tag) {
        Alert donorSaved = new Alert(Alert.AlertType.INFORMATION);
        donorSaved.setTitle("Zapisano");
        donorSaved.setHeaderText("Zapisano dawce o kolczyku: " + tag);
        donorSaved.show();
    }

    public static void pdfCreatedInfo() {
        Alert fileGenerated = new Alert(Alert.AlertType.INFORMATION);
        fileGenerated.setTitle("Wygenerowano plik PDF");
        fileGenerated.setHeaderText("Wygenerowano plik PDF do folderu Rejestrator - Pliki PDF");
        fileGenerated.show();
    }

    public static void donorUpdatedInfo(String tag) {
        Alert donorSaved = new Alert(Alert.AlertType.INFORMATION);
        donorSaved.setTitle("Zaaktualizowano");
        donorSaved.setHeaderText("Zaaktualizowano dawce o kolczyku: " + tag);
        donorSaved.show();
    }

    public static void semenSavedInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zapisano");
        alert.setHeaderText("Zapisano pobranie");
        alert.show();
    }

    public static void semenDeletedInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usunięto");
        alert.setHeaderText("Usunięto pobranie");
        alert.show();
    }

    public static void donorDeletedInfo(String tag) {
        Alert donorSaved = new Alert(Alert.AlertType.INFORMATION);
        donorSaved.setTitle("Usunięto");
        donorSaved.setHeaderText("Usunięto dawce o kolczyku: " + tag);
        donorSaved.show();
    }


    //ERRORS
    public static void donorNotFound() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Brak dawcy");
        alert.setHeaderText("Nie znaleziono dawcy");
        alert.show();
    }

    public static void donorAlreadyExist() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Już istnieje");
        alert.setHeaderText("Dawca o podanym kolczyku już istnieje");
        alert.show();
    }

    public static void dataError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Za mało danych");
        alert.setHeaderText("Uzupełnij pola");
        alert.show();
    }

    public static void invalidNumberError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText("To nie jest liczba");
        alert.show();
    }

    public static void systemNotSupportedError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText("Twoj system operacyjny nie jest wspierany");
        alert.show();
    }
}
