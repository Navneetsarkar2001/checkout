package com.example.checkout.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("product")
data class Product(
    @Id
    val id: Long? = null,
    val name: String,
    val price: Double
)