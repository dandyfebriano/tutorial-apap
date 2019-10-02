package apap.tutorial.shapee.repository;

import apap.tutorial.shapee.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductDb extends JpaRepository<ProductModel, Long>{
    List<ProductModel> findByStoreModelId(Long storeId);
    void deleteById(Long id);
}