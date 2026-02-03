package com.qr_club.service;

import com.qr_club.model.Participant;

import java.util.UUID;

public interface QrService {
    Participant checkQR(UUID uuid);

}
