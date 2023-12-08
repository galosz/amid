package com.example.sprawko;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class HelloAplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Label imie = new Label("Imie: ");
        Label nazwisko = new Label("Nazwisko: ");
        Label adres = new Label("Adres: ");
        Label miejscowosc = new Label("Miejscowość: ");
        Label telefon = new Label("Telefon: ");
        Label email = new Label("Email: ");

        TextField imie_field = new TextField();
        TextField nazwisko_field = new TextField();
        TextField adres_field = new TextField();
        TextField miejscowosc_field = new TextField();
        TextField telefon_field = new TextField();
        TextField email_field = new TextField();

        Button zatwierdz = new Button("ZATWIERDŹ");
        Button reset = new Button("RESET");

        VBox vbox = new VBox();
        vbox.setMinSize(500, 500);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(
                createRow(imie, imie_field),
                createRow(nazwisko, nazwisko_field),
                createRow(adres, adres_field),
                createRow(miejscowosc, miejscowosc_field),
                createRow(telefon, telefon_field),
                createRow(email, email_field),
                zatwierdz,
                reset
        );

        zatwierdz.setOnMouseClicked((new EventHandler<MouseEvent>() {
            int a = 0;

            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean patternImie = Pattern.matches("^[A-Za-z]{2,}+$", imie_field.getText());
                boolean patternNazwisko = Pattern.matches("^[A-Za-z]{2,}+$", nazwisko_field.getText());
                boolean patternMiejscowosc = Pattern.matches("^[A-Za-z]{3,}+$", miejscowosc_field.getText());
                boolean patternAdres = adres_field.getText().isEmpty();
                boolean patternTelefon = Pattern.matches("\\d{9,}", telefon_field.getText());
                boolean patternEmail = Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", email_field.getText());

                if (!patternAdres) {
                    a++;
                } else {
                    System.out.println("Błąd w adresie");
                }

                if (patternImie) {
                    a++;
                } else {
                    System.out.println("Błąd w imieniu");
                }
                if (patternNazwisko) {
                    a++;
                } else {
                    System.out.println("Błąd w nazwisku");
                }
                if (patternMiejscowosc) {
                    a++;
                } else {
                    System.out.println("Błąd w miejscowosci");
                }

                if (patternEmail) {
                    a++;
                } else {
                    System.out.println("Błąd w emailu");
                }

                if (patternTelefon) {
                    a++;
                } else {
                    System.out.println("Błąd w telefonie");
                }

                if (a == 6) {
                    System.out.println("formularz poprawnie wypełniony ");
                } else {
                    System.out.println("WYSTĄPIŁ BŁAD");
                }
                a = 0;
            }
        }));

        reset.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imie_field.setText("");
                nazwisko_field.setText("");
                adres_field.setText("");
                miejscowosc_field.setText("");
                telefon_field.setText("");
                email_field.setText("");
            }
        });

        Group group = new Group(vbox);
        Scene scene = new Scene(group, 500, 500);
        scene.setFill(Color.WHITE);

        stage.setTitle("Formularz");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createRow(Label label, TextField textField) {
        VBox row = new VBox(5);
        row.getChildren().addAll(label, textField);
        return row;
    }

    public static void main(String[] args) {
        launch();
    }
}
