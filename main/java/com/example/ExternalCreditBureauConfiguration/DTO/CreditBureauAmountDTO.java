package com.example.ExternalCreditBureauConfiguration.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditBureauAmountDTO {
    private Long id;

    private CreditBureauAvailableDTO creditBureauAvailableDTO;
}
