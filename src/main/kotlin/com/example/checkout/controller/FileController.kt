package com.example.checkout.controller

import com.example.checkout.model.Product
import com.example.checkout.service.FileService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/redis-products")
class FileController(private val fileService: FileService) {

    @GetMapping("/{id}")
    fun getProductFromRedis(@PathVariable id: Long): Mono<Product> = fileService.getProductFromRedis(id)
}