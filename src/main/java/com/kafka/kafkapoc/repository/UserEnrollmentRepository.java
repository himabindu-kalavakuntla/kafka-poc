package com.kafka.kafkapoc.repository;

import com.kafka.kafkapoc.domain.UserEnrollment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEnrollmentRepository extends MongoRepository<UserEnrollment, String> {
}
