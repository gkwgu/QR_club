package com.qrclub.service;

import com.qrclub.dto.ParticipantCreateDto;
import com.qrclub.dto.ParticipantDto;
import com.qrclub.dto.ParticipantUpdateDto;
import com.qrclub.model.ParticipantEntity;

import java.util.UUID;

public interface ParticipantService {
    ParticipantDto updateParticipant(UUID uuid,ParticipantUpdateDto dto);
    void deleteParticipant(UUID uuid);
    ParticipantDto create(ParticipantCreateDto dto);
}
