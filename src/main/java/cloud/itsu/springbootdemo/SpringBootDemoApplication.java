package cloud.itsu.springbootdemo;

import cloud.itsu.springbootdemo.entity.TvSeriesEntity;
import cloud.itsu.springbootdemo.repository.TVSeriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner insertDatabaseRows(TVSeriesRepository tvSeriesRepository) {
//		return args -> {
//			System.out.println("hi from short commandline runner");
//			tvSeriesRepository.save(new TvSeriesEntity(1000, "test series 1"));
//			tvSeriesRepository.save(new TvSeriesEntity(1001, "test series 2"));
//		};
//	}
//
//	@Bean
//	CommandLineRunner printContextBeans(ApplicationContext applicationContext) {
//		return args -> {
//			System.out.println("printing beans in Application Context");
//			String [] beansNames = applicationContext.getBeanDefinitionNames();
//			Arrays.sort(beansNames);
//			for (String beanName : beansNames) {
//				System.out.println("  " + beanName);
//			}
//			System.out.println("finished printing beans in Application Context");
//		};
//	}

}
