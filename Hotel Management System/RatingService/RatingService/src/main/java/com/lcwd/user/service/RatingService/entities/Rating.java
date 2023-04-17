package com.lcwd.user.service.RatingService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_rating")
public class Rating {
    @Id
    @Column(name="RatingID")
    private String ratingId;

    @Column(name="UserId")
    private String userId;

    @Column(name="HotelId")
    private String hotelId;

    @Column(name="Rating")
    private int rating;

    @Column(name="Feedback")
    private String feedback;
}