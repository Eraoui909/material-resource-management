package com.gestion_ressource.micro_respo.repository;

import com.gestion_ressource.micro_respo.model.Printer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PrinterRepository extends MongoRepository<Printer, String> {
    @Query("{ 'CPU': { $exists: false } }")
    List<Printer> getAllPrinters();
}
