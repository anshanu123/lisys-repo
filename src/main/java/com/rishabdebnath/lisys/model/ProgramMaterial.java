package com.rishabdebnath.lisys.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "program_material")
public class ProgramMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long eventId;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] materialFile;

    public ProgramMaterial() {}

    public ProgramMaterial(Long eventId, byte[] materialFile) {
        this.eventId = eventId;
        this.materialFile = materialFile;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public byte[] getMaterialFile() {
        return materialFile;
    }

    public void setMaterialFile(byte[] materialFile) {
        this.materialFile = materialFile;
    }
}
