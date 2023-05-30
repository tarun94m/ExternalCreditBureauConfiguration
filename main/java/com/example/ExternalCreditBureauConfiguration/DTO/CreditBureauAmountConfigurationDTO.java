package com.example.ExternalCreditBureauConfiguration.DTO;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditBureauAmountConfigurationDTO {
    private Long id;
    private Integer fromAmount;
    private Integer toAmount;
//    private CreditBureauConfigurationDTO creditBureauConfigurationDTO;

    private List<CreditBureauAmountDTO> creditBureauAmountDTOS;
}
