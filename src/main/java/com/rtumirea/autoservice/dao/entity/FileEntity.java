package com.rtumirea.autoservice.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Table(name = "file")
@Entity
@NoArgsConstructor
public class FileEntity {
    @Id
    @Column(name = "file_id")
    private UUID fileId;
    @Column(name = "file_type")
    private String fileType;
    @Lob
    @Column(name = "file_data")
    private byte[] fileData;
}
