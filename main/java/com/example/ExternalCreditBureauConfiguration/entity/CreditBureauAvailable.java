package com.example.ExternalCreditBureauConfiguration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl5")
public class CreditBureauAvailable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "creditBureauAvailable")
//    private CreditBureauMiddleConfiguration creditBureauMiddleConfiguration;

//    private CreditBureauAmountConfigurationLink creditBureauAmountConfigurationLink;
}
