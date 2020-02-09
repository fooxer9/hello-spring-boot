package com.fooxer.orm.springorm;

import com.fooxer.orm.springorm.entities.Artist;
import com.fooxer.orm.springorm.repository.ArtRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.boot.SpringApplication.*;


@SpringBootApplication
public class SpringOrmApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = run(SpringOrmApplication.class, args);
        ArtRepository repository = context.getBean(ArtRepository.class);

// save a couple of customers
// repository.save(new Places("Mirea", "Mirea","Mirea"));
// repository.save(new Places("Mirea1", "Mirea1","Mirea1"));


// fetch all customers
        Iterable<Artist> placess = repository.findAll();

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Artist places : placess) {
            System.out.println(places.getArt_fullName());
        }
    }

}
