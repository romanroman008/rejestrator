package com.example.Rejestrator.controllers;

import com.example.Rejestrator.enums.prevType;
import com.example.Rejestrator.model.Donor;

public class Bufor {

    prevType prev;
    prevType prevPrev;
    Donor prevDonor;

    public Bufor() {
    }

    public Bufor(prevType prev) {
        this.prev = prev;
    }

    public Bufor(prevType prev, Donor donor) {
        this.prev = prev;
        this.prevDonor = donor;
    }

    public prevType getPrev() {
        return prev;
    }

    public void setPrev(prevType prev) {
        this.prev = prev;
    }

    public Donor getDonorDto() {
        return prevDonor;
    }

    public void setDonorDto(Donor donor) {
        this.prevDonor = donor;
    }

    public prevType getPrevPrev() {
        return prevPrev;
    }

    public void setPrevPrev(prevType prevPrev) {
        this.prevPrev = prevPrev;
    }
}
