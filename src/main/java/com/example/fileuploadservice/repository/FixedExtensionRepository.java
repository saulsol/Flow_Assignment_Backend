package com.example.fileuploadservice.repository;

import com.example.fileuploadservice.domain.Extension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixedExtensionRepository extends JpaRepository<Extension, Long> {
    @Query("SELECT e FROM Extension e WHERE e.isFixed = true")
    List<Extension> findFixedExtensions();
}
