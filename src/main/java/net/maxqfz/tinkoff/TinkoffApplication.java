package net.maxqfz.tinkoff;

import javafx.application.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinkoffApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(TinkoffApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception
    {
        DatabaseService.init();
    }

    public static void log(String info)
    {
        log.info(info);
    }
}