package com.example.ExternalCreditBureauConfiguration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditBureauConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean isLoanApproved;
    private Boolean isLoanDisbursed;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "creditBureauConfiguration")
//    @JoinColumn(name="customer_category_link_id")
    private List<CustomerCategoryLink> customerCategoryLinkList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "creditBureauConfiguration")
//    @JoinColumn(name="stateLink_id")
    private List<StateLink> stateLink;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="loan_type_id")
    private LoanType loanType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="product_type_id")
    private ProductId productId;

    @OneToMany(mappedBy = "creditBureauConfiguration",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CreditBureauAmountConfiguration> creditBureauAmountConfigurations;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "creditBureauConfiguration")
    private List<CreditBureauMiddleConfiguration> creditBureauMiddleConfiguration;
}
