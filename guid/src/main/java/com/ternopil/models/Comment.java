package com.ternopil.models;

import com.ternopil.models.enums.CommentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "rating")
    private double rating;

    @Column(name = "written")
    private LocalDateTime written;

    @Column(name = "is_approved")
    CommentStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
}