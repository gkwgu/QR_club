package com.qr_club.service.impl;

import com.qr_club.dto.ParticipantCreateDto;
import com.qr_club.model.Participant;
import com.qr_club.repository.ParticipantRepository;
import com.qr_club.service.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    private ParticipantRepository repository;
    @Override
    public Participant saveParticipant(Participant participant) {
        participant.setQrUuid(UUID.randomUUID());
        return repository.save(participant);
    }

    @Override
    public Participant updateParticipant(Participant participant) {
        return repository.save(participant);
    }

    @Override
    @Transactional
    public void deleteParticipant(UUID uuid) {
        repository.deleteByQrUuid(uuid);
    }

    @Override
    public Participant create(ParticipantCreateDto dto) {

        Participant participant = new Participant();
        participant.setLastName(dto.getLastName());
        participant.setFirstName(dto.getFirstName());
        participant.setPatronymic(dto.getPatronymic());

        participant.setQrUuid(UUID.randomUUID());

        return repository.save(participant);
    }
}
