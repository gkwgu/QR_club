package com.qrclub.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ParticipantDto{
    private final String lastName;
    private final String firstName;
    private final String patronymic;
}
