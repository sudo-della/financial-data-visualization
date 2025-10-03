package com.example.financial_data_visualization;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name); // this checks if the user exists
}
