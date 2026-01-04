package org.practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length =  200)
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
