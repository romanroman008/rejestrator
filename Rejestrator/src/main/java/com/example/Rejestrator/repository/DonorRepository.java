package com.example.Rejestrator.repository;

import com.example.Rejestrator.model.Donor;
import com.example.Rejestrator.model.Semen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    Optional<Donor> findDonorByTag(String tag);

    boolean existsDonorByTag(String tag);

    @Modifying
    @Query("UPDATE Donor d SET d.semenList= ?2 WHERE d.tag= ?1")
    void updateDonorSemenList(String tag, List<Semen> list);

}
