package com.admin.admin.repositries;


import com.admin.admin.models.Enseignant;
import com.admin.admin.models.Role;
import com.admin.admin.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;

public interface UserRepo extends MongoRepository<User,String> {

    List<User> findByLaboratory(String name);
    List<User> findByDepartment(String name);
    List<User> findByAuthorities(Set<Role> auth);

}
