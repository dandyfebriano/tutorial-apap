package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.ProductModel; // sesuaikan dengan nama package anda
import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.repository.ProductDb; // sda
import apap.tutorial.shapee.repository.StoreDb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class ProductServiceImplTest{
    @InjectMocks
    ProductService productService = new ProductServiceImpl();
    StoreService storeService = new StoreServiceImpl();

    @Mock
    ProductDb productDb;

    @Test
    public void whenAddValidProductItShouldCallProductRepositorySave() {
        ProductModel newProduct = new ProductModel();
        newProduct.setNama("seiba");
        newProduct.setDeskripsi("seiba produkku");
        newProduct.setHarga(BigInteger.valueOf(10000));
        newProduct.setStok(BigInteger.valueOf(0));
        productService.addProduct(newProduct);
        verify(productDb, times(1)).save(newProduct);
        }

    @Test
    public void whenGetProductListCalledItShouldReturnAllProduct() {
        StoreModel newStore = new StoreModel();
        newStore.setId((Long) 1L);
        newStore.setNama("seiba");
        newStore.setKeterangan("seiba tokoku");
        newStore.setFollowers(0);
        List<ProductModel> allProductInTheDatabase = new ArrayList<>();
        for (int loopTimes = 3 ; loopTimes > 0; loopTimes--) {
            ProductModel product = new ProductModel();
            product.setStoreModel(newStore);
            allProductInTheDatabase.add(product);
        }
        when(productService.findAllProductByStoreId((Long)1L)).thenReturn(allProductInTheDatabase);
        List<ProductModel> dataFromServiceCall = productService.findAllProductByStoreId((Long)1L);
        assertEquals(3, dataFromServiceCall.size());
        verify(productDb, times(1)).findByStoreModelId((Long)1L);
    }

    @Test
    public void whenChangeProductCalledItShouldChangeProductData() {
        ProductModel updatedData = new ProductModel();
        updatedData.setNama("Rose");
        updatedData.setId((Long) 1L);
        updatedData.setStok(BigInteger.valueOf(10));
        updatedData.setDeskripsi("Dummy");
        updatedData.setHarga(BigInteger.valueOf(10000));
        when(productDb.findById(1L)).thenReturn(Optional.of(updatedData) );
        when(productService.changeProduct(updatedData)).thenReturn(updatedData);
        ProductModel dataFromServiceCall = productService.changeProduct(updatedData);
        assertEquals("Rose",dataFromServiceCall.getNama() );
        assertEquals((Long) 1L, dataFromServiceCall.getId());
        assertEquals(BigInteger.valueOf(10), dataFromServiceCall.getStok());
        assertEquals(BigInteger.valueOf(10000), dataFromServiceCall.getHarga());
        assertEquals("Dummy",dataFromServiceCall.getDeskripsi());
        }
    
    @Test
    public void whenGetProductByIdCalledByExistingDataItShouldReturnCorrectData() {
        ProductModel returnedData = new ProductModel();
        returnedData.setNama("Rose");
        returnedData.setId((Long) 1L);
        returnedData.setStok(BigInteger.valueOf(2));
        returnedData.setHarga(BigInteger.valueOf(10000));
        returnedData.setDeskripsi("Dummy");

        when(productDb.findById(1L)).thenReturn(Optional.of(returnedData));
        ProductModel dataFromServiceCall =productService.getProductById(1L);
        verify(productDb, times(2)).findById(1L);
        assertNotNull(dataFromServiceCall);
        ProductModel dataFromOptional = dataFromServiceCall;
        assertEquals("Rose", dataFromOptional.getNama());
        assertEquals((Long) 1L, dataFromOptional.getId());
        assertEquals(BigInteger.valueOf(2), dataFromOptional.getStok());
        assertEquals(BigInteger.valueOf(10000), dataFromOptional.getHarga());
        assertEquals("Dummy",  dataFromOptional.getDeskripsi());
    }

    @Test
    public void whenGetProductListByHargaCalledItShouldReturnAllProductByHarga() {
        StoreModel newStore = new StoreModel();
        newStore.setId((Long) 1L);
        newStore.setNama("seiba");
        newStore.setKeterangan("seiba tokoku");
        newStore.setFollowers(0);
        List<ProductModel> allProductInTheDatabase = new ArrayList<>();
        for (int loopTimes = 3 ; loopTimes > 0; loopTimes--) {
            ProductModel product = new ProductModel();
            product.setHarga(BigInteger.valueOf(10 - loopTimes));
            product.setStoreModel(newStore);
            allProductInTheDatabase.add(product);
        }
        when(productService.getListProductOrderByHargaAsc((Long)1L)).thenReturn(allProductInTheDatabase);
        List<ProductModel> dataFromServiceCall = productService.getListProductOrderByHargaAsc((Long)1L);
        assertEquals(3, dataFromServiceCall.size());
        verify(productDb, times(1)).findByStoreModelIdOrderByHargaAsc((Long)1L);
    }

    @Test
    public void whenDeleteProductCalledItShouldBeEmpty(){
        ProductModel product = new ProductModel();
        product.setId(1L);
        productService.addProduct(product);

        productService.deleteProduct(product);

        assertNull(productService.getProductById(1L));
    }
}