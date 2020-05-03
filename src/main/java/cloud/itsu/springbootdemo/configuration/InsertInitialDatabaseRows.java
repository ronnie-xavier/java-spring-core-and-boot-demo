//package cloud.itsu.springbootdemo.configuration;
//
//import cloud.itsu.springbootdemo.entity.TvSeriesEntity;
//import cloud.itsu.springbootdemo.repository.TVSeriesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class InsertInitialDatabaseRows implements CommandLineRunner {
//
//    @Autowired
//    TVSeriesRepository tvSeriesRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("hi from full commandline runner");
//        tvSeriesRepository.save(new TvSeriesEntity(2000, "test series 3"));
//        tvSeriesRepository.save(new TvSeriesEntity(2001, "test series 4"));
//    }
//}
