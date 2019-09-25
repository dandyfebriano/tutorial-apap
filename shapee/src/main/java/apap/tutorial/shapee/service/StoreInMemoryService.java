package apap.tutorial.shapee.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import apap.tutorial.shapee.model.StoreModel;

@Service
public class StoreInMemoryService implements StoreService {
    private List<StoreModel> listStore;

    public StoreInMemoryService() {
        listStore = new ArrayList<>();
    }

    @Override
    public void addStore(StoreModel store){
        listStore.add(store);
    }

    @Override
    public List<StoreModel> getStoreList(){
        return listStore;
    }

    @Override
    public StoreModel getStoreById(String idStore) {
        for(StoreModel store : listStore){
            if(store.getId().equals(idStore)){
                return store;
            }
        }
        return null;
    }

    @Override
    public void deleteStore(String idStore){
        for(StoreModel store : listStore){
            if(store.getId().equals(idStore)){
                listStore.remove(store);
            }
        }
    }
}