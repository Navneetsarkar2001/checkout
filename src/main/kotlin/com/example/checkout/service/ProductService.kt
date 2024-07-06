package com.example.checkout.service

import com.example.checkout.model.Product
import com.example.checkout.repository.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun getAllProducts(): Flux<Product> = productRepository.findAll()
    fun getProductById(id: Long): Mono<Product> = productRepository.findById(id)
    fun saveProduct(product: Product): Mono<Product> = productRepository.save(product)
}