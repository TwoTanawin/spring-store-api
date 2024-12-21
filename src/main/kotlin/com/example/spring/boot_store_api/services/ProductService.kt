package com.example.spring.boot_store_api.services

import com.example.spring.boot_store_api.models.Product
import com.example.spring.boot_store_api.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ProductService (private val productRepository: ProductRepository) {

    //Get all product
    fun getAllProduct():List<Product> = productRepository.findAll()

    //Get By Id
    fun getProductById(id: Int): Optional<Product> = productRepository.findById(id)

    //Create
    fun createProduct(product: Product): Product = productRepository.save(product)

    //Update
    fun updateProduct(id: Int, updateProduct: Product): Product{
        return if(productRepository.existsById(id)){
            updateProduct.id = id
            productRepository.save(updateProduct)
        }
        else {
            throw RuntimeException("Product not found id:$id")
        }
    }

    //delete
    fun deleteProduct(id:Int){
        return if(productRepository.existsById(id)){
            productRepository.deleteById(id)
        }
        else{
            throw RuntimeException("Product not found id:$id")
        }
    }
}