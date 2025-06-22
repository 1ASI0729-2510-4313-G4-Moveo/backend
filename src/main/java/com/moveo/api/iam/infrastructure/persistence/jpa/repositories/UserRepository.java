package com.moveo.api.iam.infrastructure.persistence.jpa.repositories;

import com.moveo.api.iam.domain.model.aggregate.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsernameAndEmailAndPasswordAndTypeAndPhoneNumber(String username, String email, String password, String type,  String phoneNumber);
    List<User> Id(Long id);

}
