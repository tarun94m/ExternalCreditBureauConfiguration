package com.example.ExternalCreditBureauConfiguration.DTO;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditBureauConfigurationDTO {
    private Long id;
    private Boolean isLoanApproved;
    private Boolean isLoanDisbursed;
    private List<CustomerCategoryLinkDto> customerCategoryLinkDto;
    private List<StateLinkDTO> stateLinkDTO;
    private ProductIdDTO productIdDTO;
    private LoanTypeDTO loanTypeDTO;
    private List<CreditBureauAmountConfigurationDTO> creditBureauAmountConfigurationDTOS;
    private List<CreditBureauMiddleConfigurationDTO> creditBureauMiddleConfigurationDTOS;
}
