package com.example.spring.boot_store_api.controllers

import com.example.spring.boot_store_api.models.Product
import com.example.spring.boot_store_api.services.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController (private val productService: ProductService) {
    @GetMapping
    fun getAllProduct() = productService.getAllProduct()

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): ResponseEntity<Product>{
        val product = productService.getProductById(id)
        return product.map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product>{
        val createProduct = productService.createProduct(product)
        return ResponseEntity(createProduct, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody product: Product): ResponseEntity<Product>{
        val updateProduct = productService.updateProduct(id, product)
        return ResponseEntity.ok(updateProduct)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Product>{
        productService.deleteProduct(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}