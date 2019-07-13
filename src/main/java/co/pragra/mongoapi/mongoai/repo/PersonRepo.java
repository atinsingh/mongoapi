package co.pragra.mongoapi.mongoai.repo;

import co.pragra.mongoapi.mongoai.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends MongoRepository<Person, String> {
}
