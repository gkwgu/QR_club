package com.qrclub.mapper;

import com.qrclub.dto.ParticipantCreateDto;
import com.qrclub.dto.ParticipantDto;
import com.qrclub.dto.ParticipantUpdateDto;
import com.qrclub.model.ParticipantEntity;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {
    public ParticipantEntity toEntity(ParticipantCreateDto dto) {
        ParticipantEntity entity = new ParticipantEntity();
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setPatronymic(dto.getPatronymic());
        return entity;
    }

    public ParticipantDto toDto(ParticipantEntity entity) {
        return new ParticipantDto(
                entity.getLastName(),
                entity.getFirstName(),
                entity.getPatronymic()
        );
    }

    public void updateEntity(ParticipantEntity entity, ParticipantUpdateDto dto) {
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setPatronymic(dto.getPatronymic());
    }
}
