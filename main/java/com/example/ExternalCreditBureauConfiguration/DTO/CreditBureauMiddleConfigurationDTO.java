package com.example.ExternalCreditBureauConfiguration.DTO;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditBureauMiddleConfigurationDTO {
    private Long id;
    private Boolean cbReportNeeded;
    private Integer enquiryValidity;
    private Boolean manualEnquiryAllowed;
    private Integer allowEnquiry;
   private CreditBureauAvailableDTO creditBureauAvailableDTO;
}
