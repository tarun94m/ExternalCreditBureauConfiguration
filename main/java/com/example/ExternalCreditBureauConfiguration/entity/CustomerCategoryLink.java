package com.example.ExternalCreditBureauConfiguration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl1")
public class CustomerCategoryLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customerCategory_id")
    private CustomerCategory customerCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    private CreditBureauConfiguration creditBureauConfiguration;
}
