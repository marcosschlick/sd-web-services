package event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EventRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Event("Aniversário de 202 anos de Sant’Ana do Livramento",
                    "Show gratuito de Fernando & Sorocaba em comemoração aos 202 anos da cidade, com os maiores sucessos do sertanejo como Madri, Bala de Prata e Delegada.",
                    LocalDateTime.of(2025, 7, 30, 20, 0),
                    -30.8949337284416, -55.5360128889534)));
            log.info("Preloading " + repository.save(new Event("9° Fronteira Festival Binacional de Enogastronomia",
                    "Maior evento enogastronômico do Sul do Brasil e Uruguai, unindo cultura, educação e turismo para fortalecer os laços entre Livramento e Rivera através dos sabores da fronteira.",
                    LocalDateTime.of(2025, 8, 6, 9, 0),
                    -30.89687510475323, -55.53424007668622)));
            log.info("Preloading " + repository.save(new Event("IV Semana Binacional de Inovação da Área B",
                    "Quarta edição do evento binacional que reúne universidades, governos, empresas e comunidade para promover o desenvolvimento territorial através da cooperação e inovação, com participantes internacionais.",
                    LocalDateTime.of(2025, 9, 29, 18, 0),
                    -30.89687510475323, -55.53424007668622)));
            log.info("Preloading " + repository.save(new Event("5º Oktoberfest da Marchi Pizzaria",
                    "Uma festa alemã de rua com música ao vivo, chopp gelado, gastronomia e Espaço Kids, em um evento sustentável onde você leva seu próprio copo.",
                    LocalDateTime.of(2025, 11, 1, 17, 0),
                    -30.887951229615123, -55.531081445818074)));
            log.info("Preloading " + repository.save(new Event("12º ChoriCeva",
                    "Um festival gastronômico e cultural na fronteira Brasil-Uruguai que celebra os sabores locais com choripan, cervejas artesanais e música ao vivo.",
                    LocalDateTime.of(2025, 11, 15, 18, 0),
                    -30.896195327429446, -55.535213662812524)));
        };
    }
}