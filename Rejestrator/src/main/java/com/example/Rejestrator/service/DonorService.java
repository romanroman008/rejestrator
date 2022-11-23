package com.example.Rejestrator.service;

import com.example.Rejestrator.info.Alerts;
import com.example.Rejestrator.model.Donor;
import com.example.Rejestrator.repository.DonorRepository;
import com.example.Rejestrator.repository.SemenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {
    private final DonorRepository donorRepository;



    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }


    public List<Donor> getAllDonors(){
        List<Donor> donorList=donorRepository.findAll();
       return donorList;
    }
    @Transactional
    public void updateDonor(Donor donor,Long id){
        Optional<Donor> optional=donorRepository.findById(id); //chuj wie
        Donor donorFromBase=optional.get();

        if(!donor.getSemenList().isEmpty())
        {

        }
        if(donor.getSemenList().isEmpty()&&donorFromBase.getSemenList().isEmpty()){

        }
        else {
            donor.setSemenList(donorFromBase.getSemenList());
        }


        donorRepository.delete(donorFromBase);
        donorRepository.save(donor);
        Alerts.donorUpdatedInfo(donorFromBase.getTag());
    }

    @Transactional
    public void updateSemenList(Donor donor){
        Optional<Donor> optional=donorRepository.findDonorByTag(donor.getTag()); //chuj wie
        Donor donorFromBase=optional.get();
        donorRepository.delete(donorFromBase);
        donorRepository.save(donor);
    }

    public Donor findDonorById(Long id){
       Optional<Donor> optional = donorRepository.findById(id);
       if(optional.isPresent()) {
           Donor donor = optional.get();
           return donor;
       }
       else throw new NullPointerException("Nie ma dawcy o tym id");
    }

    @Transactional
    public Donor findDonorByTag(String tag) {
        Optional<Donor> optionalDonor=donorRepository.findDonorByTag(tag);
        if(checkIfPresent(tag)){
           return optionalDonor.get();
        }
        else
            throw new NullPointerException("Nie ma takiego dawcy");


    }


   public boolean checkIfPresent(String tag){

       return donorRepository.existsDonorByTag(tag);


    }


    @Transactional
    public void saveDonor(Donor donor){
        if(!checkIfPresent(donor.getTag())) {
            donorRepository.save(donor);
            Alerts.donorSavedInfo(donor.getTag());
        }else{
          Alerts.donorAlreadyExist();
        }


    }
    @Transactional
    public void deleteDonor(Donor donor) {

        donorRepository.delete(donor);


    }




}
