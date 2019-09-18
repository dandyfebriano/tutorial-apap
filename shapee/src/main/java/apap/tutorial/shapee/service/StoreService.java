package apap.tutorial.shapee.service;

import java.util.List;
import apap.tutorial.shapee.model.StoreModel;

public interface StoreService{
    //method untuk nambah store
    void addStore(StoreModel store);
    //method untuk mendapatkan data semua store yang tersimpan
    List<StoreModel> getStoreList();
    //method untuk mendapatkan data store berdasarkan id
    StoreModel getStoreById(String idStore);
    //method untuk menghapus store
    void deleteStore(String idStore);
    
}