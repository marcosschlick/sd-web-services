package event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByDateLessThan(LocalDateTime day);

    List<Event> findAllByDateGreaterThan(LocalDateTime day);
}