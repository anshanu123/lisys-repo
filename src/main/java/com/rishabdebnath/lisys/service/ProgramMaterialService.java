package com.rishabdebnath.lisys.service;

import com.rishabdebnath.lisys.model.ProgramMaterial;
import com.rishabdebnath.lisys.repository.ProgramMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramMaterialService {

    @Autowired
    private ProgramMaterialRepository programMaterialRepository;

    public void saveMaterial(ProgramMaterial programMaterial, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] fileContent = file.getBytes();
            programMaterial.setMaterialFile(fileContent);
        }
        programMaterialRepository.save(programMaterial);
    }

    public List<ProgramMaterial> getAllMaterials() {
        return programMaterialRepository.findAll();
    }

    public Optional<ProgramMaterial> findById(Long id) {
        return programMaterialRepository.findById(id);
    }

    public void deleteMaterial(Long id) {
        programMaterialRepository.deleteById(id);
    }
}
