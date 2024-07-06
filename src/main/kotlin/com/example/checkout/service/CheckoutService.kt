package com.example.checkout.service

import com.example.checkout.model.Checkout
import com.example.checkout.repository.CheckoutRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CheckoutService(private val checkoutRepository: CheckoutRepository) {
    fun getAllCheckout(): Flux<Checkout> = checkoutRepository.findAll()
    fun getCheckoutById(id: Long): Mono<Checkout> = checkoutRepository.findById(id)
    fun saveCheckout(checkout: Checkout): Mono<Checkout> = checkoutRepository.save(checkout)
}