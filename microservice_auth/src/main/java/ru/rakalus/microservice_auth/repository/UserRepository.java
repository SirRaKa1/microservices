package ru.rakalus.microservice_auth.repository;

import ru.rakalus.microservice_auth.domain.model.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,UUID> {

}
