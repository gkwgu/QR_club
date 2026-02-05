package com.qrclub.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class ParticipantUpdateDto {
    private final String lastName;
    private final String firstName;
    private final String patronymic;
}
