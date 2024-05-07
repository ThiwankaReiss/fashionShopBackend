package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrockDto {
    private Long id;
    private Long customerId;
    private String beltColor;
    private String buckelColor;
    private String topColor;
    private String bottomColor;
    private String topDecalImage;
    private double decalScale;
    private String bottomTextureImage;
    private double imageRepeate;
}
