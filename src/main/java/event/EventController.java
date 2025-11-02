package event;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
class EventController {

    private final EventService service;

    EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    Event create(@RequestBody Event event) {
        return service.create(event);
    }

    @GetMapping
    List<Event> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    Event getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/date/{date}")
    List<Event> getEventsByDay(@PathVariable LocalDate date) {
        return service.findByDay(date);
    }

    @GetMapping("/date-range")
    List<Event> getEventsByDateRange(@RequestParam LocalDate start, LocalDate end) {
        return service.findEventsInDateRange(start, end);
    }

    @GetMapping("/upcoming-from")
    List<Event> getUpcomingEventsFrom(@RequestParam LocalDate date) {
        return service.findEventsFromDate(date);
    }

    @GetMapping("/before-date")
    List<Event> getEventsBefore(@RequestParam LocalDate date) {
        return service.findEventsUntilDate(date);
    }

    @PutMapping("/{id}")
    Event update(@RequestBody Event event, @PathVariable Long id) {
        return service.update(event, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }
}