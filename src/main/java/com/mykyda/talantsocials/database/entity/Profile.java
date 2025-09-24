package com.mykyda.talantsocials.database.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mykyda.talantsocials.database.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "profile")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private UUID userId;

    @Column(unique = true, nullable = false)
    private String tag;

    //Address !!

    @Column(nullable = false)
    private String displayName;

    @Column
    private String currentOccupation;

    @Column
    private String profilePictureUrl;

    @Column
    private String bannerPictureUrl;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ProfileStatus status = ProfileStatus.NEWBIE;

    @Column
    private Double employeeRating;

    @Lob
    @Column(columnDefinition = "text")
    private String bioMarkdown;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<LanguageSkill> languageSkills;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profile")
    private PostPreference postPreference;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<JobSkill> jobsSkills;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
    @JsonIgnore
    private List<Like> likes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
    @JsonIgnore
    private List<Comment> comments;
}