package com.gestion_ressource.micro_respo.repository;

import com.gestion_ressource.micro_respo.model.Printer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrinterRepository extends MongoRepository<Printer, String> {
}
