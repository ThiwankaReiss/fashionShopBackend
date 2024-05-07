package org.example.dto;

import lombok.Data;

@Data
public class DriveResponseDto {
    private int status;
    private String message;
    private String url;
}
