package com.dmdev.week5.Collections2.Task1.utils;

import com.dmdev.week5.Collections2.Task1.Cinema;
import com.dmdev.week5.Collections2.Task1.Film;

import java.util.List;

public class CinemaActions {

    public static void printFilmsIn2021(Cinema cinema) {
        System.out.println("Films in 2021:");
        List<Film> filmsIn2021 = cinema.getFilmsByYear(2021);
        for (Film film : filmsIn2021) {
            System.out.println(film);
        }
        System.out.println();
    }

    public static void printFilmsInNov2021(Cinema cinema) {
        System.out.println("Films in November 2021:");
        List<Film> filmsInNov2021 = cinema.getFilmsByYearAndMonth(2021, 11);
        for (Film film : filmsInNov2021) {
            System.out.println(film);
        }
        System.out.println();
    }

    public static void printActionFilms(Cinema cinema) {
        System.out.println("Action films:");
        List<Film> actionFilms = cinema.getFilmsByGenre("Action");
        for (Film film : actionFilms) {
            System.out.println(film);
        }
        System.out.println();
    }

    public static void printTop10FilmsByRating(Cinema cinema) {
        System.out.println("Top 10 films by rating:");
        List<Film> top10Films = cinema.getTop10FilmsByRating();
        for (Film film : top10Films) {
            System.out.println(film);
        }
        System.out.println();
    }
}
