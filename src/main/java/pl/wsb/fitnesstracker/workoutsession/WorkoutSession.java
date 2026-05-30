package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.fitnesstracker.training.api.Training;

import java.time.LocalDateTime;

@Entity
@Table(name = "workout_session")
@Getter
@Setter
@NoArgsConstructor
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name="startLatitude", nullable = false)
    private double startLatitude;

    @Column(name="startLongitude", nullable = false)
    private double startLongitude;

    @Column(name="endLatitude", nullable = false)
    private double endLatitude;

    @Column(name="endLongitude", nullable = false)
    private double endLongitude;

    @Column(name="altitude", nullable = false)
    private double altitude;

    public WorkoutSession (
            final LocalDateTime timestamp,
            final double startLatitude,
            final double startLongitude,
            final double endLatitude,
            final double endLongitude,
            final double altitude
    ) {
        this.timestamp = timestamp;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
        this.altitude = altitude;
    }
}
