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

    @GetMapping("/upcoming")
    List<Event> getUpcomingEvents(@RequestParam LocalDate date) {
        return service.findUpcomingEvents(date);
    }

    @GetMapping("/past")
    List<Event> getPastEvents(@RequestParam LocalDate date) {
        return service.findPastEvents(date);
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