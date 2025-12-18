package com.ecommerce.ecommerceProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="addresses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min=5, message = "Street name must be atleast 5 Characters")
    private String street;

    @NotBlank
    @Size(min=5, message = "Building name must be atleast 5 Characters")
    private String buildingName;

    @NotBlank
    @Size(min=4, message = "City name must be atleast 4 Characters")
    private String city;

    @NotBlank
    @Size(min=2, message = "State name must be atleast 2 Characters")
    private String state;

    @NotBlank
    @Size(min=2, message = "Country name must be atleast 2 Characters")
    private String country;

    @NotBlank
    @Size(min=6, message = "Pincode name must be atleast 6 Characters")
    private String pincode;
    @ToString.Exclude
@ManyToMany(mappedBy = "addresses")
    private List<User> users =new ArrayList<>();

}
