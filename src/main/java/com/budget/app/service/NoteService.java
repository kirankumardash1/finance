package com.budget.app.service;

import com.budget.app.persistence.entity.NoteEntity;
import com.budget.app.persistence.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public NoteEntity create(String title, String content) {
        NoteEntity note = new NoteEntity(
                UUID.randomUUID(),
                title,
                content,
                Instant.now()
        );
        return repository.save(note);
    }

    public List<NoteEntity> findAll() {
        return repository.findAll();
    }

    public NoteEntity findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));
    }
}
