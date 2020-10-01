package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

public class ProductRepositry {
    private Product[] products = new Product[0];

    public Product[] findAll(){
        return products;
    }

    public Product findById(int id) {
        for (Product item : products) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById (int id){
        if (findById(id) == null) {throw new NotFoundException ("Element with id: " + id + " not found");
        }

            int length = products.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : products) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            products = tmp;

    }

    public void save(Product product){
        int length = products.length+1;
        Product[] tmp = new Product[length];
        System.arraycopy(products,0,tmp,0,products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }
}
