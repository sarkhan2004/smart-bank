package az.sarkhan.smartbank;

import org.springframework.boot.SpringApplication;

public class TestSmartBankApplication {

    public static void main(String[] args) {
        SpringApplication.from(SmartBankApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
