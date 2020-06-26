package cl.microshin.micro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.microshin.micro.model.User;

@Repository
public interface IRepoUser extends JpaRepository<User, Integer> {
    
}