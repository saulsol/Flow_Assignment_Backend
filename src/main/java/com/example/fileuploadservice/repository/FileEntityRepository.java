package com.example.fileuploadservice.repository;

import com.example.fileuploadservice.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<FileEntity, Long> {

}
