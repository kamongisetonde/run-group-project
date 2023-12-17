package com.sethondrunninggroop.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String type;
    private String photoUrl;
    @CreationTimestamp
    private LocalDateTime createOn;
    @UpdateTimestamp
    private LocalDateTime updateOn;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
    // Getter and Setter methods for the 'club' field
    public Club getClub() {
        return club;
    }
    public void setClub(Club club) {
        this.club = club;
    }
}
