package com.dmdev.week5.Collections2.Task1;

import com.dmdev.week5.Collections2.Task1.utils.CinemaActions;

public class CinemaDemo {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.addFilm(new Film(1, "No Time to Die", 2021, 10, "Action", 8.7));
        cinema.addFilm(new Film(2, "Dune", 2021, 10, "Sci-Fi", 9.1));
        cinema.addFilm(new Film(3, "The French Dispatch", 2021, 10, "Comedy", 7.8));
        cinema.addFilm(new Film(4, "Antlers", 2021, 11, "Horror", 6.5));
        cinema.addFilm(new Film(5, "Red Notice", 2021, 11, "Action", 8.3));
        cinema.addFilm(new Film(6, "The Power of the Dog", 2021, 11, "Drama", 9.2));
        cinema.addFilm(new Film(7, "Home Sweet Home Alone", 2021, 11, "Comedy", 7.5));
        cinema.addFilm(new Film(8, "The Lost Daughter", 2021, 12, "Drama", 6.8));
        cinema.addFilm(new Film(9, "Spider-Man: No Way Home", 2021, 12, "Action", 8.6));
        cinema.addFilm(new Film(10, "Being the Ricardos", 2021, 12, "Drama", 9.3));
        cinema.addFilm(new Film(11, "The Northman", 2022, 1, "Action", 8.0));
        cinema.addFilm(new Film(12, "Scream", 2022, 1, "Horror", 8.9));
        cinema.addFilm(new Film(13, "Babylon", 2022, 1, "Drama", 9.4));
        cinema.addFilm(new Film(14, "Bullet Train", 2022, 2, "Action", 7.9));
        cinema.addFilm(new Film(15, "Argylle", 2022, 2, "Action", 8.5));
        cinema.addFilm(new Film(16, "Death on the Nile", 2022, 2, "Mystery", 9.2));
        cinema.addFilm(new Film(17, "The Bad Guys", 2022, 3, "Action", 8.1));
        cinema.addFilm(new Film(18, "Morbius", 2022, 3, "Action", 6.6));
        cinema.addFilm(new Film(19, "The Batman", 2022, 3, "Action", 8.4));
        cinema.addFilm(new Film(20, "Black Panther: Wakanda Forever", 2022, 3, "Action", 9.1));

        CinemaActions.printFilmsIn2021(cinema);
        CinemaActions.printFilmsInNov2021(cinema);
        CinemaActions.printActionFilms(cinema);
        CinemaActions.printTop10FilmsByRating(cinema);
    }
}
