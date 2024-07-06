package com.example.checkout.service

import com.example.checkout.model.Product
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.io.ClassPathResource
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class FileService(@Qualifier("reactiveRedisTemplate") private val redisTemplate: ReactiveRedisTemplate<String, String> ) {
    private val objectMapper = jacksonObjectMapper()

    @PostConstruct
    fun loadProductToRedis() {
        val resource = ClassPathResource("products.json")
        val products: List<Product> = objectMapper.readValue(resource.inputStream)

        products.forEach { product ->
            redisTemplate.opsForValue().set("product:${product.id}", objectMapper.writeValueAsString(product)).subscribe()
        }
    }

    fun getProductFromRedis(productId: Long): Mono<Product> {
        return redisTemplate.opsForValue().get("product:$productId").map {
            objectMapper.readValue(it, Product::class.java)
        }
    }
}