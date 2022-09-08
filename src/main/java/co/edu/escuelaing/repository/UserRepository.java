package co.edu.escuelaing.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.escuelaing.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{$or: [{'name': {$regex: ?0, $options:'i'}}, {'lastName': {$regex: ?0, $options:'i'}}]}")
    List<User> findUsersWithNameOrLastNameLike(String name);

    @Query("{'createdAt' : { $gte: ?0} }")
    public List<User> findUsersCreatedAfter(Date from);

    @Query("{'email' : ?0}")
    User findByEmail(String email);
}
