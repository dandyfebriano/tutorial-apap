package apap.tutorial.shapee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.repository.StoreDb;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
    @Autowired
    StoreDb storeDb;

    @Override
    public StoreModel getStoreById(Long id) {
        return storeDb.findById(id).get();
    }

    @Override
    public void addStore(StoreModel storeModel) {
        storeDb.save(storeModel);
    }

    @Override
    public List<StoreModel> getStoreList() {
        return storeDb.findAll();
    }

    @Override
    public StoreModel changeStore(StoreModel store) {
        // Mengambil objek store yang akan diubah dari database
        StoreModel targetStore = storeDb.findById(store.getId()).get();

        // Mengubah atribut
        targetStore.setNama(store.getNama());
        targetStore.setKeterangan(store.getKeterangan());
        storeDb.save(targetStore);
        return targetStore;
    }

    @Override
    public void deleteStore(Long idStore){
        storeDb.deleteById(idStore);
    }
    @Override
    public StoreModel getStoreByIdLink(Long idStore){
        List<StoreModel> listStore = getStoreList();
        for(StoreModel store : listStore) {
            if(store.getId().equals(idStore)){
                return store;
            }
        }
        return null;
    }

}