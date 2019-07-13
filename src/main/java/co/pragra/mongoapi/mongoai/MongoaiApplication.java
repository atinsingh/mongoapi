package co.pragra.mongoapi.mongoai;

import co.pragra.mongoapi.mongoai.domain.Address;
import co.pragra.mongoapi.mongoai.domain.Person;
import co.pragra.mongoapi.mongoai.repo.AddressRepo;
import co.pragra.mongoapi.mongoai.repo.PersonRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class MongoaiApplication {

    private PersonRepo repo;
    private AddressRepo addressRepo;

    public MongoaiApplication(PersonRepo repo, AddressRepo addressRepo) {
        this.repo = repo;
        this.addressRepo = addressRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoaiApplication.class, args);
    }

    @GetMapping("/persons")
    List<Person> getAllPerson(){
        return repo.findAll();
    }

    @Bean
    CommandLineRunner runner(){
        Address address = new Address();
        address.setAddressLine("Brampton");
        Address address1 =  this.addressRepo.save(address);

        return args -> {
            repo.save(new Person("Atin", Arrays.asList(address1)));
            repo.save(new Person("Vivek", Arrays.asList(address1)));
        };
    }
}
