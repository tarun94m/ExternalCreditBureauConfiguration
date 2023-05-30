package com.example.ExternalCreditBureauConfiguration.DTO;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditBureauAvailableDTO {
    private Long id;
    private String name;
    private CreditBureauMiddleConfigurationDTO creditBureauMiddleConfigurationDTO;
}
