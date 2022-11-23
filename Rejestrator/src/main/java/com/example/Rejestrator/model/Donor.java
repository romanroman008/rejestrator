package com.example.Rejestrator.model;

import org.checkerframework.common.aliasing.qual.Unique;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;


@Entity
       // (name="donor")
public class Donor implements Serializable {
    private static final long serialVersionUID = -7533996434173519473L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Unique
    private String tag;
    private String numberOfCertificate;
    private String studbookName;
    private String donorBreedName;
    private String name;
    private String growerName;
    private String growerAddress;
    private String ownerName;
    private String ownerAddress;
    private String method;
    private String placeOfBirth;
    private LocalDate timeOfBirth;
    String motherNumber;
    String motherName;
    String fatherNumber;
    String fatherName;
    String grandfatherFatherNumber;
    String grandfatherFatherName;
    String grandmotherFatherNumber;
    String grandmotherFatherName;
    String grandfatherMotherNumber;
    String grandfatherMotherName;
    String grandmotherMotherNumber;
    String grandmotherMotherName;
    //@Column(name="number_book")
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.ALL})
    @JoinColumn(name="donor_id")
    private List<Semen> semenList= new ArrayList<>();

    public Donor(){}

    public Donor(@Unique String tag, String numberOfCertificate, String studbookName, String donorBreedName, String name, String growerName, String growerAddress, String ownerName, String ownerAddress, String method, String placeOfBirth, LocalDate timeOfBirth, String motherNumber, String motherName, String fatherNumber, String fatherName, String grandfatherFatherNumber, String grandfatherFatherName, String grandmotherFatherNumber, String grandmotherFatherName, String grandfatherMotherNumber, String grandfatherMotherName, String grandmotherMotherNumber, String grandmotherMotherName) {
        this.tag = tag;
        this.numberOfCertificate = numberOfCertificate;
        this.studbookName = studbookName;
        this.donorBreedName = donorBreedName;
        this.name = name;
        this.growerName = growerName;
        this.growerAddress = growerAddress;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.method = method;
        this.placeOfBirth = placeOfBirth;
        this.timeOfBirth = timeOfBirth;
        this.motherNumber = motherNumber;
        this.motherName = motherName;
        this.fatherNumber = fatherNumber;
        this.fatherName = fatherName;
        this.grandfatherFatherNumber = grandfatherFatherNumber;
        this.grandfatherFatherName = grandfatherFatherName;
        this.grandmotherFatherNumber = grandmotherFatherNumber;
        this.grandmotherFatherName = grandmotherFatherName;
        this.grandfatherMotherNumber = grandfatherMotherNumber;
        this.grandfatherMotherName = grandfatherMotherName;
        this.grandmotherMotherNumber = grandmotherMotherNumber;
        this.grandmotherMotherName = grandmotherMotherName;
    }

    public Donor(String numberOfCertificate, String studbookName, String donorBreedName, String tag) {
        this.numberOfCertificate = numberOfCertificate;
        this.studbookName = studbookName;
        this.donorBreedName = donorBreedName;
        this.tag = tag;
       }


    public Long getId() {
        return id;
    }

    public String getNumberOfCertificate() {
        return numberOfCertificate;
    }

    public void setNumberOfCertificate(String numberOfCertificate) {
        this.numberOfCertificate = numberOfCertificate;
    }

    public String getStudbookName() {
        return studbookName;
    }

    public void setStudbookName(String studbookName) {
        this.studbookName = studbookName;
    }

    public String getDonorBreedName() {
        return donorBreedName;
    }

    public void setDonorBreedName(String donorBreedName) {
        this.donorBreedName = donorBreedName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    public List<Semen> getSemenList() {
        return semenList;
    }

    public void setSemenList(List<Semen> semenList) {
        this.semenList = semenList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrowerName() {
        return growerName;
    }

    public void setGrowerName(String growerName) {
        this.growerName = growerName;
    }

    public String getGrowerAddress() {
        return growerAddress;
    }

    public void setGrowerAddress(String growerAddress) {
        this.growerAddress = growerAddress;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public LocalDate getTimeOfBirth() {
        return timeOfBirth;
    }

    public void setTimeOfBirth(LocalDate timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }

    public String getMotherNumber() {
        return motherNumber;
    }

    public void setMotherNumber(String motherNumber) {
        this.motherNumber = motherNumber;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherNumber() {
        return fatherNumber;
    }

    public void setFatherNumber(String fatherNumber) {
        this.fatherNumber = fatherNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGrandfatherFatherNumber() {
        return grandfatherFatherNumber;
    }

    public void setGrandfatherFatherNumber(String grandfatherFatherNumber) {
        this.grandfatherFatherNumber = grandfatherFatherNumber;
    }

    public String getGrandfatherFatherName() {
        return grandfatherFatherName;
    }

    public void setGrandfatherFatherName(String grandfatherFatherName) {
        this.grandfatherFatherName = grandfatherFatherName;
    }

    public String getGrandmotherFatherNumber() {
        return grandmotherFatherNumber;
    }

    public void setGrandmotherFatherNumber(String grandmotherFatherNumber) {
        this.grandmotherFatherNumber = grandmotherFatherNumber;
    }

    public String getGrandmotherFatherName() {
        return grandmotherFatherName;
    }

    public void setGrandmotherFatherName(String grandmotherFatherName) {
        this.grandmotherFatherName = grandmotherFatherName;
    }

    public String getGrandfatherMotherNumber() {
        return grandfatherMotherNumber;
    }

    public void setGrandfatherMotherNumber(String grandfatherMotherNumber) {
        this.grandfatherMotherNumber = grandfatherMotherNumber;
    }

    public String getGrandfatherMotherName() {
        return grandfatherMotherName;
    }

    public void setGrandfatherMotherName(String grandfatherMotherName) {
        this.grandfatherMotherName = grandfatherMotherName;
    }

    public String getGrandmotherMotherNumber() {
        return grandmotherMotherNumber;
    }

    public void setGrandmotherMotherNumber(String grandmotherMotherNumber) {
        this.grandmotherMotherNumber = grandmotherMotherNumber;
    }

    public String getGrandmotherMotherName() {
        return grandmotherMotherName;
    }

    public void setGrandmotherMotherName(String grandmotherMotherName) {
        this.grandmotherMotherName = grandmotherMotherName;
    }
    public void addSemen(Semen semen){
        semenList.add(semen);
    }
    public void deleteSemen(Semen semen){

        Iterator<Semen> itr =semenList.iterator();
        while (itr.hasNext()){
            Semen x=itr.next();
            if (x.equals(semen)){
                itr.remove();
                return;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donor donor = (Donor) o;
        return Objects.equals(id, donor.id) && Objects.equals(tag, donor.tag) && Objects.equals(numberOfCertificate, donor.numberOfCertificate) && Objects.equals(studbookName, donor.studbookName) && Objects.equals(donorBreedName, donor.donorBreedName) && Objects.equals(name, donor.name) && Objects.equals(growerName, donor.growerName) && Objects.equals(growerAddress, donor.growerAddress) && Objects.equals(ownerName, donor.ownerName) && Objects.equals(ownerAddress, donor.ownerAddress) && Objects.equals(method, donor.method) && Objects.equals(placeOfBirth, donor.placeOfBirth) && Objects.equals(timeOfBirth, donor.timeOfBirth) && Objects.equals(motherNumber, donor.motherNumber) && Objects.equals(motherName, donor.motherName) && Objects.equals(fatherNumber, donor.fatherNumber) && Objects.equals(fatherName, donor.fatherName) && Objects.equals(grandfatherFatherNumber, donor.grandfatherFatherNumber) && Objects.equals(grandfatherFatherName, donor.grandfatherFatherName) && Objects.equals(grandmotherFatherNumber, donor.grandmotherFatherNumber) && Objects.equals(grandmotherFatherName, donor.grandmotherFatherName) && Objects.equals(grandfatherMotherNumber, donor.grandfatherMotherNumber) && Objects.equals(grandfatherMotherName, donor.grandfatherMotherName) && Objects.equals(grandmotherMotherNumber, donor.grandmotherMotherNumber) && Objects.equals(grandmotherMotherName, donor.grandmotherMotherName) && Objects.equals(semenList, donor.semenList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tag, numberOfCertificate, studbookName, donorBreedName, name, growerName, growerAddress, ownerName, ownerAddress, method, placeOfBirth, timeOfBirth, motherNumber, motherName, fatherNumber, fatherName, grandfatherFatherNumber, grandfatherFatherName, grandmotherFatherNumber, grandmotherFatherName, grandfatherMotherNumber, grandfatherMotherName, grandmotherMotherNumber, grandmotherMotherName, semenList);
    }
}
