package com.example.DDDSample.application.configuration;

import com.example.DDDSample.domain.service.HealthService;
import com.example.DDDSample.infastructure.repository.database.HealthRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // TODO Auto-generated method stub
        System.out.println("### Application Startup ###");
        // You can add your JPA check logic here (e.g., ProductService.isJpaWorking())

//        HealthService.isJpaWorking();
    }

}
