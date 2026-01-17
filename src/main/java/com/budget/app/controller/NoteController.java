package com.budget.app.controller;

import com.budget.app.dto.CreateNoteRequest;
import com.budget.app.dto.NoteResponse;
import com.budget.app.persistence.entity.NoteEntity;
import com.budget.app.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteResponse create(@Valid @RequestBody CreateNoteRequest request) {
        NoteEntity note = service.create(request.title(), request.content());
        return toResponse(note);
    }

    @GetMapping
    public List<NoteResponse> findAll() {
        return service.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public NoteResponse findById(@PathVariable UUID id) {
        return toResponse(service.findById(id));
    }

    private NoteResponse toResponse(NoteEntity note) {
        return new NoteResponse(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt()
        );
    }
}
