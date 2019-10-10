package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService{
    void addProduct(ProductModel product);
    List<ProductModel> findAllProductByStoreId(Long storeId);
    ProductModel changeProduct(ProductModel productModel);
    ProductModel getProductById(Long idProduct);
    void deleteProduct(ProductModel product);
    List<ProductModel> getListProductOrderByHargaAsc(Long idStore);
}