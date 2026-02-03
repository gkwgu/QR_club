package com.qr_club.service.impl;

import com.qr_club.model.Participant;
import com.qr_club.repository.ParticipantRepository;
import com.qr_club.service.ParticipantService;
import com.qr_club.service.QrService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class QrServiceImpl implements QrService {
    private final ParticipantRepository repository;
    @Override
    @Transactional
    public Participant checkQR(UUID uuid) {

        Participant participant = repository.findByQrUuid(uuid)
                .orElseThrow(() -> new RuntimeException("QR недействителен"));

        participant.setQrUuid(UUID.randomUUID());

        return participant;
    }
}
