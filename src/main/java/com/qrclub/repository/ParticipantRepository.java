package com.qrclub.repository;

import com.qrclub.model.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Long> {

}
