package com.admin.admin.repositries;

import com.admin.admin.models.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepo extends MongoRepository<Department, String> {
}
