package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.rest.StoreDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StoreRestService{
    StoreModel createStore(StoreModel store);
    List<StoreModel> retrieveListStoreModel();
    StoreModel getStoreByIdStore(Long idStore);
    StoreModel changeStore(Long idStore,StoreModel storeModdelUpdate);
    void deleteStore(Long idStore);
    Mono<String> getStatus(Long idStore);
    Mono<StoreDetail> postStatus();
}