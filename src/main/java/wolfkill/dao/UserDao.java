package wolfkill.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import wolfkill.domain.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>, QueryDslPredicateExecutor<User> {

}
