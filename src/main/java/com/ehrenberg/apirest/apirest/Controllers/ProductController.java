package com.ehrenberg.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehrenberg.apirest.apirest.Entities.Product;
import com.ehrenberg.apirest.apirest.Repositories.ProductRepository;




@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productoRepository;

    @GetMapping
    public List<Product> GetAllProducts(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product producto){
        return productoRepository.save(producto);
    }
    

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        Product producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));
        
        producto.setName(productDetails.getName());
        producto.setPrice(productDetails.getPrice());

        return productoRepository.save(producto);

    }
    
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        Product producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));
        productoRepository.delete(producto);
        return "El producto con el id " + id + " fue eliminado correctamente.";
    }
    

}
