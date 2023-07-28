package com.stackroute.organizerservice.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("event")
public class Event {
    @Id
    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventVenue;
    private LocalDate eventDate;
    private String startTime;
    private String endTime;
    private Double eventAmount;
    private Integer eventCapacity;
    private String userName;
    private String userEmail;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return eventId == event.eventId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }
}
