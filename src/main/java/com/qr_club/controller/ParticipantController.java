package com.qr_club.controller;


import com.qr_club.dto.ParticipantCreateDto;
import com.qr_club.dto.ParticipantDto;
import com.qr_club.model.Participant;
import com.qr_club.service.ParticipantService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ParticipantController {
    private final ParticipantService service;
    @PutMapping("/update_participant")
    public Participant updateParticipant(@RequestBody Participant participant)
    {return service.updateParticipant(participant);}

    @DeleteMapping("/delete_participant/{uuid}")
    public void deleteParticipant(@PathVariable UUID uuid)
    {service.deleteParticipant(uuid);}

    @PostMapping("/save_participant")
    public ParticipantDto saveParticipant(@RequestBody ParticipantCreateDto dto) {
        Participant participant = service.create(dto);
        return new ParticipantDto(
                participant.getLastName(),
                participant.getFirstName(),
                participant.getPatronymic()
        );
    }
}
