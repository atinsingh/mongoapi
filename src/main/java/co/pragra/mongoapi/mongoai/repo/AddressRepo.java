package co.pragra.mongoapi.mongoai.repo;

import co.pragra.mongoapi.mongoai.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends MongoRepository<Address, String> {
}
