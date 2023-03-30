package com.dmdev.week5.Collections2.Task1;

import java.util.Objects;

public class Film {
    private int id;
    private String title;
    private int year;
    private int month;
    private String genre;
    private double rating;

    public Film(int id, String title, int year, int month, String genre, double rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.month = month;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id &&
                year == film.year &&
                month == film.month &&
                Double.compare(film.rating, rating) == 0 &&
                Objects.equals(title, film.title) &&
                Objects.equals(genre, film.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, month, genre, rating);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Year: " + year + ", Month: " + month + ", Genre: " + genre + ", Rating: " + rating;
    }
}



