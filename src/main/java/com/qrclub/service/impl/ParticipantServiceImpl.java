package com.qrclub.service.impl;

import com.qrclub.dto.ParticipantCreateDto;
import com.qrclub.dto.ParticipantDto;
import com.qrclub.dto.ParticipantUpdateDto;
import com.qrclub.mapper.ParticipantMapper;
import com.qrclub.model.ParticipantEntity;
import com.qrclub.model.QRCodeEntity;
import com.qrclub.repository.ParticipantRepository;
import com.qrclub.repository.QrCodeRepository;
import com.qrclub.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    private final ParticipantRepository repository;
    private final ParticipantMapper mapper;
    private final QrCodeRepository qrCodeRepository;
    @Override
    @Transactional
    public ParticipantDto updateParticipant(UUID uuid, ParticipantUpdateDto dto) {
        QRCodeEntity qrCode = qrCodeRepository.findByQrUuid(uuid)
                .orElseThrow(() -> new RuntimeException("QR-код не найден"));

        ParticipantEntity participant = qrCode.getParticipant();
        mapper.updateEntity(participant, dto);
        return mapper.toDto(participant);
    }

    @Override
    @Transactional
    public void deleteParticipant(UUID uuid) {
        QRCodeEntity qrCode = qrCodeRepository.findByQrUuid(uuid)
                .orElseThrow(() -> new RuntimeException("QR-код не найден"));

        repository.delete(qrCode.getParticipant());
    }

    @Override
    public ParticipantDto create(ParticipantCreateDto dto) {
        ParticipantEntity participant = mapper.toEntity(dto);

        QRCodeEntity qrCode = new QRCodeEntity();
        qrCode.setQrUuid(UUID.randomUUID());

        qrCode.setParticipant(participant);
        participant.setQrCode(qrCode);

        ParticipantEntity saved = repository.save(participant);

        return mapper.toDto(saved);
    }
}
