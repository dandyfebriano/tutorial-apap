package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.ProductModel;
import apap.tutorial.shapee.repository.ProductDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDb productDb;

    @Override
    public void addProduct(ProductModel product){
        productDb.save(product);
    }

    @Override
    public List<ProductModel> findAllProductByStoreId(Long storeId){
        return productDb.findByStoreModelId(storeId);
    }

    @Override
    public ProductModel changeProduct(ProductModel product) {
        // Mengambil objek store yang akan diubah dari database
        ProductModel targetProduct = productDb.findById(product.getId()).get();

        // Mengubah atribut
        targetProduct.setNama(product.getNama());
        targetProduct.setHarga(product.getHarga());
        targetProduct.setStok(product.getStok());
        targetProduct.setDeskripsi(product.getDeskripsi());
        productDb.save(targetProduct);
        return targetProduct;
    }

    @Override
    public ProductModel getProductById(Long idProduct) {
        if(productDb.findById(idProduct).isPresent()){
            return productDb.findById(idProduct).get();
        }
        return null;
    }

    @Override
    public void deleteProduct(ProductModel product){
        productDb.delete(product);
    }

	@Override
	public List<ProductModel> getListProductOrderByHargaAsc(Long id) {
		return productDb.findByStoreModelIdOrderByHargaAsc(id);
    }
 
    
}