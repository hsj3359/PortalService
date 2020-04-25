package kr.ac.jejunu.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

public class DaoFactory {
    @Bean
    public UserDao getUserDao() {
        return new UserDao(connectionMaker());
    }


    @Bean
    public JejuConnectionMaker connectionMaker() {

        return new JejuConnectionMaker();
    }
}
