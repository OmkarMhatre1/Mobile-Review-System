package userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import userservice.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
