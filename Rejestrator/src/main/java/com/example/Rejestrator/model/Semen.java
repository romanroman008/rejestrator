package com.example.Rejestrator.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Semen implements Serializable,Comparable<Semen> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String color;
    private String colorB;
    private int amount;
    private String placeOfDrawing;
    private LocalDate date;
    private String others;
    private String recipientName;
    private String recipientAddress;

    Semen(){};

    public Semen(String color, String colorB, int amount, String placeOfDrawing, LocalDate date, String others, String recipientName, String recipientAddress) {
        this.color = color;
        this.colorB = colorB;
        this.amount = amount;
        this.placeOfDrawing = placeOfDrawing;
        this.date = date;
        this.others = others;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorB() {
        return colorB;
    }

    public void setColorB(String colorB) {
        this.colorB = colorB;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPlaceOfDrawing() {
        return placeOfDrawing;
    }

    public void setPlaceOfDrawing(String placeOfDrawing) {
        this.placeOfDrawing = placeOfDrawing;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semen semenDto = (Semen) o;
        return amount == semenDto.amount && color.equals(semenDto.color) && colorB.equals(semenDto.colorB) && placeOfDrawing.equals(semenDto.placeOfDrawing) && date.equals(semenDto.date) && others.equals(semenDto.others) && recipientName.equals(semenDto.recipientName) && recipientAddress.equals(semenDto.recipientAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, colorB, amount, placeOfDrawing, date, others, recipientName, recipientAddress);
    }

    @Override
    public int compareTo(Semen s) {
        if (date.isBefore(s.date))
            return 1;
        else if (date.isAfter(s.date))
            return -1;
        int colorCompare = color.compareTo(s.color);
        if (colorCompare != 0)
            return colorCompare;
        return colorB.compareTo(s.colorB);
    }
    @Override
    public String toString() {
        return "Semen{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", colorB='" + colorB + '\'' +
                ", amount=" + amount +
                ", placeOfDrawing='" + placeOfDrawing + '\'' +
                ", date=" + date +
                ", others='" + others + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                '}';
    }
}
