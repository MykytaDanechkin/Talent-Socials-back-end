package com.mykyda.talantsocials.database.entity;

import com.mykyda.talantsocials.database.id.LikeId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@Builder
@Table(name = "likes")
@NoArgsConstructor
@AllArgsConstructor
public class Like {

    @EmbeddedId
    private LikeId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("profileId")
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column
    @Builder.Default
    private Timestamp createdAt = Timestamp.from(Instant.now());
}
