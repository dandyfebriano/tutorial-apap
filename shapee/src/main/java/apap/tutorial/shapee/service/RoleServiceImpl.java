package apap.tutorial.shapee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.shapee.model.RoleModel;
import apap.tutorial.shapee.repository.RoleDb;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDb roleDb;

    @Override
    public List<RoleModel> findAll() {
        return roleDb.findAll();
    }


}