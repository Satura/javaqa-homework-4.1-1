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
//        Product[] allProducts = repositry.findAll();
//        int length = 0;
//        boolean isItThere = false;
//
//        //вычисляем сколько совпадений имеется
//        for (Product product : allProducts) {
//            if (matches(product,text)){
//                length++;
//                isItThere = true;
//            }
//        }
//
//        Product[] result = new Product[length];
//
//        if (isItThere) {
//            for (int i = 0; i < allProducts.length; i++){
//                for (int j = 0; j < result.length; j++) {
//                    if (matches(allProducts[i], text)) {
//                        result[j] = allProducts[i];
//                    }
//                }
//            }
//        }

        Product[] result = new Product[0];

        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
       return result;
    }

    public boolean matches(Product product, String search) {

        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getBrand().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }

        if (product.getName().equalsIgnoreCase(search)) {
            return  true;
        } else {
            return false;
        }

    }

}
