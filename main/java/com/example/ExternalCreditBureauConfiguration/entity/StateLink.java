package com.example.ExternalCreditBureauConfiguration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private States state;

    @ManyToOne(fetch = FetchType.LAZY)
    private CreditBureauConfiguration creditBureauConfiguration;
}
