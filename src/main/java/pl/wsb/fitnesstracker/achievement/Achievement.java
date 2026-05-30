package pl.wsb.fitnesstracker.achievement;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "achievement")
@Getter
@NoArgsConstructor()
@ToString
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "earnedAt", nullable = false)
    private LocalDateTime earnedAt;

    public Achievement(
            final String name,
            final LocalDateTime earnedAt
    ) {
        this.name = name;
        this.earnedAt = earnedAt;
    }
}
