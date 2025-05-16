package com.eazybytes.accounts.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customer") // if using the same name mention in db no need to mention table annotation
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer extends BaseEnity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "customer_id")
    private Long customerId;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;
}
