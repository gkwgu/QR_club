package com.qrclub.controller;

import com.qrclub.dto.QrCheckResponseDto;
import com.qrclub.model.ParticipantEntity;
import com.qrclub.service.QrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/qr")
@RequiredArgsConstructor
public class QrController {
    private final QrService service;

    @PostMapping("/check/{uuid}")
    public QrCheckResponseDto check(@PathVariable UUID uuid) {
        return service.checkQR(uuid);
    }
}
