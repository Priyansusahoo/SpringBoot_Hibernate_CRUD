package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
@Data // Getters and Setters are automatically created
@NoArgsConstructor
@AllArgsConstructor
public class EntityClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("lastName")
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;

//    @OneToMany(mappedBy = "entityClass", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    @JsonProperty("permanentAddress")
//    private AddressClass permanentAddress;

    @OneToMany(mappedBy = "entityClass", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty("addressList")
    private List<AddressClass> addressList;
}
