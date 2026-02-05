package com.qrclub.service;

import com.qrclub.dto.QrCheckResponseDto;

import java.util.UUID;

public interface QrService {
    QrCheckResponseDto checkQR(UUID uuid);

}
