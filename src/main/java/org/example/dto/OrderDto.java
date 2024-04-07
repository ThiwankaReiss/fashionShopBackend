package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.OrderDetailsEntity;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Double totalPrice;
    private Double discountedPrice;
    private Long customerId;
    private String date;
    private String time;
    private List<OrderDetailsEntity> list;
}
