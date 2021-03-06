package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepositry;

public class ProductManager {
    private ProductRepositry repository = new ProductRepositry();

    public ProductManager(ProductRepositry repositry){
        this.repository = repositry;
    }

    public void add (Product product){
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];

        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
       return result;
    }

}
