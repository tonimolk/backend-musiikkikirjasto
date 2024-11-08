package s24.backend;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s24.backend.domain.Genre;
import s24.backend.domain.GenreRepository;
import s24.backend.domain.Song;
import s24.backend.domain.SongRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
@Bean
	public CommandLineRunner demo(SongRepository songrepository, GenreRepository genrerepository) {
		return (args) -> {
			Genre genre1 = new Genre("Rock", null);
			Genre genre2 = new Genre("Pop", null);
			Genre genre3 = new Genre("Rap", null);
			
			genrerepository.save(genre1);
			genrerepository.save(genre2);
			genrerepository.save(genre3);

			songrepository.save(new Song("Rock rock", "Rokkari", 2024, 3.00, genre1 ));
			songrepository.save(new Song("Rap rap", "Rappari", 2024, 3.00, genre2 ));
		};
	}

}

