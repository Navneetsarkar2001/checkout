package com.example.checkout.repository

import com.example.checkout.model.Product
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ProductRepository : ReactiveCrudRepository<Product, Long>