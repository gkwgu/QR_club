package com.qrclub.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ParticipantCreateDto{
    private final String lastName;
    private final String firstName;
    private final String patronymic;
}

