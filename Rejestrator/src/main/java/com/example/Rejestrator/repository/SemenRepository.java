package com.example.Rejestrator.repository;

import com.example.Rejestrator.model.Donor;
import com.example.Rejestrator.model.Semen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemenRepository extends JpaRepository<Semen,Long> {

}
