package com.inthedraw.inthedrawservice.repository.user;

import com.inthedraw.inthedrawservice.entity.raffle.RaffleEntity;
import com.inthedraw.inthedrawservice.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmailAndPassword(String email, String password);
}
