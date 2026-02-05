package com.qrclub.controller;


import com.qrclub.dto.ParticipantCreateDto;
import com.qrclub.dto.ParticipantDto;
import com.qrclub.dto.ParticipantUpdateDto;
import com.qrclub.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/participant")
@RequiredArgsConstructor
public class ParticipantController {
    private final ParticipantService service;
    @PutMapping("/{uuid}")
    public ParticipantDto updateParticipant(@PathVariable UUID uuid,@RequestBody ParticipantUpdateDto dto) {
        return service.updateParticipant(uuid,dto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteParticipant(@PathVariable UUID uuid) {
        service.deleteParticipant(uuid);
    }

    @PostMapping
    public ParticipantDto saveParticipant(@RequestBody ParticipantCreateDto dto) {
        return  service.create(dto);
    }
}
