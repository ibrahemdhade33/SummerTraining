package com.example.remoatecommandsexcuter;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories()

public class RemoateCommandsExcuterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RemoateCommandsExcuterApplication.class, args);

    }

//    @Bean
//    CommandLineRunner runner(ShowRepo briefRepo, CommandRepo commandRepo){
//        return args -> {
//            IpinterfaceBriefComp briefComp = new IpinterfaceBriefComp("GigabitEthernet0/0/0",
//                    "unassigned",true,"NVRAM","down","down") ;
//            IpinterfaceBriefComp briefComp1 = new IpinterfaceBriefComp("GigabitEthernet0/0/1",
//                    "unassigned",true,"NVRAM","down","down") ;
//            IpinterfaceBriefComp briefComp2 = new IpinterfaceBriefComp("GigabitEthernet0/0/7",
//                    "unassigned",true,"NVRAM","down","down") ;
//            List<IpinterfaceBriefComp> l = new ArrayList<>() ;
//            l.add(briefComp) ;
//            l.add(briefComp1) ;
//            l.add(briefComp2) ;
//
//
//            Show interfaceBrief = new IpInterfaceBrief(LocalDateTime.now(),l);
//            briefRepo.insert(interfaceBrief);
//            Command c = new Command("Show") ;
//            commandRepo.insert(c) ;
//        };
//    }
//@Bean
//public MappingMongoConverter mappingMongoConverter() {
//    DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
//    MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
//    // Don't save _class information in the mongo document
//    converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//    return converter;
//}
}
