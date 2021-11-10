package com.fullcycle.fccatalogo.domain.entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Video extends BaseEntity {

    private String title;
    private String description;
    private Integer yearLaunched;
    private Boolean opened;
    private String rating;
    private Float duration;
    private List<Category> categories = new ArrayList<>();
    private List<Genre> genres = new ArrayList<>();
    private List<CastMember> castMembers = new ArrayList<>();
    private List<VideoFile> videoFiles = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public Video(UUID id, String title, String description, Integer yearLaunched, Boolean opened) {
        super.setId(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setOpened(opened);
    }

    public Video(String title, String description, Integer yearLaunched, Boolean opened) {
        super.generateUUID();
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setOpened(opened);
    }

    public Video(String title, String description, Integer yearLaunched, Boolean opened, String rating, Float duration) {
        super.generateUUID();
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setOpened(opened);
        this.setRating(rating);
        this.setDuration(duration);
    }

    public Video(String title, String description, Integer yearLaunched, Float duration) {
        super.generateUUID();
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setDuration(duration);
    }

    public Video(String title, String description, Integer yearLaunched, Float duration, List<VideoFile> videoFiles) {
        super.generateUUID();
        super.generateUUID();
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setDuration(duration);
        this.setVideoFiles(videoFiles);
    }


    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title is marked non-null but is null");
        }
        if (title.length() == 0) {
            throw new IllegalArgumentException("title is marked non-blank but is null");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearLaunched() {
        return yearLaunched;
    }

    public void setYearLaunched(Integer yearLaunched) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (yearLaunched > currentYear) {
            throw new IllegalArgumentException("");
        }

        this.yearLaunched = yearLaunched;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        this.duration = Float.valueOf(decimalFormat.format(duration));
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        if (categories == null) {
            throw new IllegalArgumentException("categories is marked non-null but is null");
        }
        this.categories = categories;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        if (genres == null) {
            throw new IllegalArgumentException("genres is marked non-null but is null");
        }
        this.genres = genres;
    }

    public List<CastMember> getCastMembers() {
        return castMembers;
    }

    public void setCastMembers(List<CastMember> castMembers) {
        if (castMembers == null) {
            throw new IllegalArgumentException("castMembers is marked non-null but is null");
        }
        this.castMembers = castMembers;
    }

    public void addCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("category is marked non-null but is null");
        }
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("category is marked non-null but is null");
        }
        this.categories.removeIf(c -> this.categories.contains(category));
    }

    public void addGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("genre is marked non-null but is null");
        }
        this.genres.add(genre);
    }

    public void removeGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("genre is marked non-null but is null");
        }
        this.genres.removeIf(c -> this.genres.contains(genre));
    }


    public void addCastMember(CastMember castMember) {
        if (castMember == null) {
            throw new IllegalArgumentException("castMember is marked non-null but is null");
        }
        this.castMembers.add(castMember);
    }

    public void removeCastMember(CastMember castMember) {
        if (castMember == null) {
            throw new IllegalArgumentException("castMember is marked non-null but is null");
        }
        this.castMembers.removeIf(c -> this.castMembers.contains(castMember));
    }

    public List<VideoFile> getVideoFiles() {
        return videoFiles;
    }

    public void setVideoFiles(List<VideoFile> videoFiles) {
        if (videoFiles == null) {
            throw new IllegalArgumentException("videoFiles is marked non-null but is null");
        }
        this.videoFiles = videoFiles;
    }

    public Video createVideoWithFiles(String title, String description, Integer yearLaunched, Float duration, List<Category> categories,
        List<Genre> genres, List<CastMember> castMembers, List<VideoFile> videoFiles) {
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setDuration(duration);
        this.setCategories(categories);
        this.setGenres(genres);
        this.setCastMembers(castMembers);
        this.setVideoFiles(videoFiles);

        return this;
    }

    public Video createVideoWithoutFile(String title, String description, Integer yearLaunched, Float duration, List<Category> categories,
        List<Genre> genres, List<CastMember> castMembers) {
        this.setTitle(title);
        this.setDescription(description);
        this.setYearLaunched(yearLaunched);
        this.setDuration(duration);
        this.setCategories(categories);
        this.setGenres(genres);
        this.setCastMembers(castMembers);

        return this;
    }
}
