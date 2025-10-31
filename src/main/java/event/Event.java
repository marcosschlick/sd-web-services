package event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
class Event {

    private @Id
    @GeneratedValue Long id;

    private String name;
    private String description;
    LocalDateTime date;
    private Double lat;
    private Double lon;

    Event() {
    }

    Event(String name, String description, LocalDateTime date, Double lat, Double lon) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + this.id + ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' + ", date='" + this.date.getDayOfMonth() + "/" + this.date.getMonthValue() + '\'' +
                ", hour='" + this.date.getHour() + ":" + this.date.getMinute() + '\'' +
                ", lat='" + this.lat + '\'' + ", lon='" + this.lon + '}';
    }
}