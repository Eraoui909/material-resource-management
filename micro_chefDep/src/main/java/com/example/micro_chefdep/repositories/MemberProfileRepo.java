package com.example.micro_chefdep.repositories;

import com.example.micro_chefdep.models.MemberProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberProfileRepo extends MongoRepository<MemberProfile,String> {
}
