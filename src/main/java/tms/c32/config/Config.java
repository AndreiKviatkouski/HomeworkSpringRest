package tms.c32.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tms.c32.entity.Operation;
import tms.c32.entity.User;


import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public List<Operation> operationList() {
        return new ArrayList<>();
    }

    @Bean
    public List<User> userList() {
        return new ArrayList<>();
    }

}
