package com.qr_club.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ParticipantDto{
    private final String lastName;
    private final String firstName;
    private final String patronymic;
}
