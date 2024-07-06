package com.example.checkout.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("checkout")
data class Checkout(
    @Id
    val id: Long? = null,
    val productId: Long,
    val quantity: Int
)
