package com.qr_club.controller;

import com.qr_club.dto.QrCheckResponseDto;
import com.qr_club.model.Participant;
import com.qr_club.service.QrService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/qr")
@AllArgsConstructor
public class QrController {
    private final QrService service;

    @PostMapping("/check")
    public QrCheckResponseDto check(@RequestParam UUID uuid) {

        Participant participant = service.checkQR(uuid);

        return new QrCheckResponseDto(
                participant.getLastName(),
                participant.getFirstName(),
                participant.getPatronymic()
        );
    }
}
