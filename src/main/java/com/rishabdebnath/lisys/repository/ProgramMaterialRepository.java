package com.rishabdebnath.lisys.repository;

import com.rishabdebnath.lisys.model.ProgramMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramMaterialRepository extends JpaRepository<ProgramMaterial, Long> {
}
