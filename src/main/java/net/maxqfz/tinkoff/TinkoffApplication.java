package net.maxqfz.tinkoff;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TinkoffApplication {

    public static void main(String args[]) {
        SpringApplication.run(TinkoffApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(ApplicationRepository repository) {
        return (args) -> {
            //Adding demo data
            repository.save(new ApplicationEntity(1, LocalDate.parse("2017-05-04"), "WrongProduct"));
            repository.save(new ApplicationEntity(1, LocalDate.parse("2017-05-09"), "RightProduct"));
            repository.save(new ApplicationEntity(1, LocalDate.parse("2017-05-03"), "WrongProduct"));
            repository.save(new ApplicationEntity(2, LocalDate.parse("2017-01-01"), "RightProduct"));
            repository.save(new ApplicationEntity(3, LocalDate.parse("2017-04-14"), "WrongProduct"));
            repository.save(new ApplicationEntity(3, LocalDate.parse("2017-05-04"), "RightProduct"));
        };
    }
}