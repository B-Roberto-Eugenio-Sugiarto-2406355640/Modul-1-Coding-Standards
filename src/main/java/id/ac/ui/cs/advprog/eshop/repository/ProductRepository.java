package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        if (product.getProductId() == null || product.getProductId().isBlank()) {
            product.setProductId(UUID.randomUUID().toString());
        }
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        for (Product product : productData) {
            if (Objects.equals(product.getProductId(), productId)) {
                return product;
            }
        }
        return null;
    }

    public Product update(Product updatedProduct) {
        for (int i = 0; i < productData.size(); i++) {
            Product existingProduct = productData.get(i);
            if (Objects.equals(existingProduct.getProductId(), updatedProduct.getProductId())) {
                productData.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }

    public void delete(String productId) {
        productData.removeIf(product -> Objects.equals(product.getProductId(), productId));
    }
}