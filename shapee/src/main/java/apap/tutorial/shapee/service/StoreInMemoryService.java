/**package apap.tutorial.shapee.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import apap.tutorial.shapee.model.StoreModel;

public class StoreInMemoryService implements StoreService {
    private List<StoreModel> listStore;

    public StoreInMemoryService() {
        listStore = new ArrayList<>();
    }

    @Override
    public void addStore(StoreModel store) {
        listStore.add(store);
    }

    @Override
    public List<StoreModel> getStoreList() {
        return listStore;
    }

    @Override
    public Optional<StoreModel> getStoreById(Long idStore) {
        for(StoreModel store : listStore) {
            if(store.getId().equals(idStore)){
                return store;
            }
        }
        return null;
    }

    @Override
    public void deleteStore(Long idStore){
        for(StoreModel store : listStore){
            if(store.getId().equals(idStore)){
                listStore.remove(store);
            }
        }
    }

    @Override
    public StoreModel changeStore(StoreModel storeModel) {
        // TODO Auto-generated method stub
        return null;
    }
}**/