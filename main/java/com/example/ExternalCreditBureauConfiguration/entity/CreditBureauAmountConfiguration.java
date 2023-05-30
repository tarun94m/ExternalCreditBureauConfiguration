package com.example.ExternalCreditBureauConfiguration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Credit_Bureau_amount_config")
public class CreditBureauAmountConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer fromAmount;
    private Integer toAmount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="credit_bureau_configuration_id" )
    private CreditBureauConfiguration creditBureauConfiguration;

//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name="credit_bureau_avaliable_id")
//    private List<CreditBureauAvailable> creditBureauAvailable;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "creditBureauAmountConfigurations")
    private List<CreditBureauAmountLink> creditBureauAmountLinks;
}
