package ie.atu.week3_lab2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> products = new ArrayList<>();
    public ProductController() {
        products.add(new Product("Tv", "made by sony", 899, 100));
        products.add(new Product("Radio", "made by samsung", 99, 101));
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return products;
    }
}
