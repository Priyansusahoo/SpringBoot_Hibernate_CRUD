package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data // Getters and Setters are automatically created
@NoArgsConstructor
@AllArgsConstructor
public class AddressClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("addressId")
    private Long addressId;

    @JsonProperty("pincode")
    @Column(name = "pincode")
    private String pincode;

    @JsonProperty("city")
    @Column(name = "city")
    private String city;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private EntityClass entityClass;
}