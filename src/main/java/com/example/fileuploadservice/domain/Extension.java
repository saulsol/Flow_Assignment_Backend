package com.example.fileuploadservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "extentions")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Extension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=20)
    private String extensionName;

    private boolean isFixed; // 0 : 고정, 1 : 커스텀
}
