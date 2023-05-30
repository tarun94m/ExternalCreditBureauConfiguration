package com.example.ExternalCreditBureauConfiguration.DTO;

import com.example.ExternalCreditBureauConfiguration.entity.CreditBureauConfiguration;
import com.example.ExternalCreditBureauConfiguration.entity.CustomerCategory;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCategoryLinkDto {
    private Long id;
    private CustomerCategoryDTO customerCategoryDTO;

}
