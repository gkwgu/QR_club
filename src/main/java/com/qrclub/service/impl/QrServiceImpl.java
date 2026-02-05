package com.qrclub.service.impl;

import com.qrclub.dto.QrCheckResponseDto;
import com.qrclub.model.ParticipantEntity;
import com.qrclub.model.QRCodeEntity;
import com.qrclub.repository.ParticipantRepository;
import com.qrclub.repository.QrCodeRepository;
import com.qrclub.service.QrService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QrServiceImpl implements QrService {
    private final ParticipantRepository repository;
    private final QrCodeRepository qrCodeRepository;
    @Override
    @Transactional
    public QrCheckResponseDto checkQR(UUID uuid) {

        QRCodeEntity qrCode = qrCodeRepository.findByQrUuid(uuid)
                .orElseThrow(() -> new RuntimeException("QR недействителен"));

        ParticipantEntity participant = qrCode.getParticipant();

        qrCode.setQrUuid(UUID.randomUUID());

        return new QrCheckResponseDto(
                participant.getLastName(),
                participant.getFirstName(),
                participant.getPatronymic()
        );
    }
}
