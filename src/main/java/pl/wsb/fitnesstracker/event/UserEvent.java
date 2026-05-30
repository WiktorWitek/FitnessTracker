package pl.wsb.fitnesstracker.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_event")
@Getter
@Setter
@NoArgsConstructor
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    public UserEvent(
            final String status,
            final LocalDateTime registrationDate
    ) {
        this.status = status;
        this.registrationDate = registrationDate;
    }
}