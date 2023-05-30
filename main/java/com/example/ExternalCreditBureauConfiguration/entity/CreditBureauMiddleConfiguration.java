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
public class CreditBureauMiddleConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean cbReportNeeded;
    private int enquiryValidity;
    private Boolean manualEnquiryAllowed;
    private int allowEnquiry;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="Credit_bureau_available_id")
    private CreditBureauAvailable creditBureauAvailable;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="credit_bureau_configuration_id")
    private CreditBureauConfiguration creditBureauConfiguration;
}
