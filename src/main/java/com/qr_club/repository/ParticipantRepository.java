package com.qr_club.repository;

import com.qr_club.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    Optional<Participant> findByQrUuid(UUID qrUuid);
    void deleteByQrUuid(UUID qrUuid);
}
