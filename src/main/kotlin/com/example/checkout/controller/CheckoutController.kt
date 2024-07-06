package com.example.checkout.controller

import com.example.checkout.model.Checkout
import com.example.checkout.service.CheckoutService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/checkouts")
class CheckoutController(private val checkoutService: CheckoutService) {

    @GetMapping
    fun getAllCheckouts(): Flux<Checkout> = checkoutService.getAllCheckout()

    @GetMapping("/{id}")
    fun getCheckoutById(@PathVariable id: Long): Mono<Checkout> = checkoutService.getCheckoutById(id)

    @PostMapping
    fun createCheckout(@RequestBody checkout: Checkout): Mono<Checkout> = checkoutService.saveCheckout(checkout)
}