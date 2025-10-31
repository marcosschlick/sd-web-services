package event;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    EventService(EventRepository repository) {
        this.repository = repository;
    }

    Event create(Event event) {
        return repository.save(event);
    }

    List<Event> findAll() {
        return repository.findAll();
    }

    Event findById( Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    List<Event> findUpcomingEvents(LocalDate date) {
        return repository.findAllByDateGreaterThan(date.atStartOfDay());
    }

    List<Event> findPastEvents(LocalDate date) {
        return repository.findAllByDateLessThan(date.atStartOfDay());
    }

    Event update(Event updatedEvent, Long id) {
        Event event = repository.findById(id).orElseThrow(() -> new EventNotFoundException(id));

        if (updatedEvent.getName() != null) {
            event.setName(updatedEvent.getName());
        }
        if (updatedEvent.getDescription() != null) {
            event.setDescription(updatedEvent.getDescription());
        }
        if (updatedEvent.getDate() != null) {
            event.setDate(updatedEvent.getDate());
        }
        if (updatedEvent.getLat() != null) {
            event.setLat(updatedEvent.getLat());
        }
        if (updatedEvent.getLon() != null) {
            event.setLon(updatedEvent.getLon());
        }

        return repository.save(event);
    }

    void delete(Long id) {
        repository.deleteById(id);
    }

}
