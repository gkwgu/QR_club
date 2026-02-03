package com.qr_club.service;

import com.qr_club.dto.ParticipantCreateDto;
import com.qr_club.model.Participant;

import java.util.UUID;

public interface ParticipantService {
    Participant saveParticipant(Participant participant);
    Participant updateParticipant(Participant participant);
    void deleteParticipant(UUID uuid);
    Participant create(ParticipantCreateDto dto);
}
