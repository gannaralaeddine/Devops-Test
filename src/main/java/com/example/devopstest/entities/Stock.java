package com.example.devopstest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;

    private String libelleStock;

    private Integer qte;

    private Integer qteMin;

    @OneToMany(mappedBy = "stock")
    @JsonIgnore
    private Set<Product> products;

    public Stock(String libelleStock, Integer qte, Integer qteMin) {
        super();
        this.libelleStock = libelleStock;
        this.qte = qte;
        this.qteMin = qteMin;
    }

}
