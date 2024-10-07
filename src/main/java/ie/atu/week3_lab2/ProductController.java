package ie.atu.week3_lab2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> products = new ArrayList<>();
    public ProductController() {
        products.add(new Product("Tv", "made by sony", 899, 100));
        products.add(new Product("Radio", "made by samsung", 99, 101));
        products.add(new Product("example1", "test1", 99, 102));
        products.add(new Product("example2", "test2", 99, 103));
        products.add(new Product("example3", "test3", 99, 104));
        products.add(new Product("example4", "test4", 99, 105));
        products.add(new Product("example5", "test5", 99, 106));
        products.add(new Product("example6", "test6", 99, 107));
        products.add(new Product("example7", "test7", 99, 108));
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return products;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product){
        products.add(product);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List> editProduct(@PathVariable int id, @RequestBody Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
            }
        }
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List> removeProduct(@PathVariable int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            }
        }
        return ResponseEntity.ok(products);
    }
}
