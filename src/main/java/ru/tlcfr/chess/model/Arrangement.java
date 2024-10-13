package ru.tlcfr.chess.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "arrangements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arrangement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "pieces")
    private List<Piece> pieces;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;
}
