package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.entities.Creator;
import ma.xproce.inventoryservice.entities.Video;
import ma.xproce.inventoryservice.repo.CreatorRepository;
import ma.xproce.inventoryservice.repo.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(CreatorRepository creatorRepository, VideoRepository videoRepository){
        return args -> {
            Creator creator1 = new Creator();
            creator1.setName("OTHMAN ABID");
            creator1.setEmail("othmanabid2001@gamil.com");

            Creator creator2 = new Creator();
            creator2.setName("SALIM SALIM");
            creator2.setEmail("salimsalim@gmail.com");

            Creator creator3 = new Creator();
            creator2.setName("CRISTIANO RONALDO");
            creator2.setEmail("cristianoronaldo@gmail.com");

            Video video1 = new Video();
            video1.setName("Grand Theft Auto VI Trailer 1");
            video1.setUrl("https://www.youtube.com/watch?v=QdBZY2fkU-0&pp=ygUEZ3RhNg%3D%3D");
            video1.setDescription("GTA 6");
            video1.setDatePublication(LocalDate.now());
            video1.setCreator(creator1);

            Video video2 = new Video();
            video2.setName("Galaxy S23 Ultra: Official Introduction Film | Samsung");
            video2.setUrl("https://www.youtube.com/watch?v=BSYsXVFzmKA");
            video2.setDescription("Samsung S23");
            video2.setDatePublication(LocalDate.now());
            video2.setCreator(creator2);

            Video video3 = new Video();
            video3.setName("Cristiano Ronaldo ● The Greatest of All Time");
            video3.setUrl("https://www.youtube.com/watch?v=-mFOj3Vfm1A&pp=ygURY3Jpc3RpYW5vIHJvbmFsZG8%3D");
            video3.setDescription("Cristiano Ronaldo");
            video3.setDatePublication(LocalDate.now());
            video3.setCreator(creator3);

            try {
                creatorRepository.saveAll(List.of(creator1, creator2,creator3));
                videoRepository.saveAll(List.of(video1, video2,video3));

                logger.info("successful!");

                logger.info("Creators:");
                creatorRepository.findAll().forEach(creator -> logger.info(creator.toString()));

                logger.info("\nVideos:");
                videoRepository.findAll().forEach(video -> logger.info(video.toString()));
            } catch (Exception e) {
                logger.error("Error!!", e.getMessage());
                e.printStackTrace();
            }
        };
    }

}
