package mobileService.repository;

import mobileService.entity.Mobile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MobileRepository extends MongoRepository<Mobile,String> {
}
