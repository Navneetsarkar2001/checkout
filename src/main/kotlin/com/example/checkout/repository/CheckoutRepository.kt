package com.example.checkout.repository

import com.example.checkout.model.Checkout
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CheckoutRepository : ReactiveCrudRepository<Checkout, Long>