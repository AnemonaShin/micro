package cl.microshin.micro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.microshin.micro.model.User;

public interface IRepoUser extends JpaRepository<User, Integer> {
    
}