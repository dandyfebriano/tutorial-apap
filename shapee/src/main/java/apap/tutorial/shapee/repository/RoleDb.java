package apap.tutorial.shapee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tutorial.shapee.model.RoleModel;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long>{

} 