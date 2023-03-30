package com.dmdev.week5.Collections2.Task1;

import java.util.*;

public class Cinema {
    private Map<Integer, List<Film>> filmsByYear = new LinkedHashMap<>();
    private Map<Integer, List<Film>> filmsByMonth = new LinkedHashMap<>();
    private Map<String, List<Film>> filmsByGenre = new LinkedHashMap<>();
    private List<Film> allFilms = new ArrayList<>();

    public void addFilm(Film film) {
        if (allFilms.contains(film)) {
            System.out.println("Film already exists in the cinema");
            return;
        }

        int year = film.getYear();
        List<Film> filmsOfYear = filmsByYear.getOrDefault(year, new ArrayList<>());
        filmsOfYear.add(film);
        filmsByYear.put(year, filmsOfYear);

        int month = film.getMonth();
        List<Film> filmsOfMonth = filmsByMonth.getOrDefault(month, new ArrayList<>());
        filmsOfMonth.add(film);
        filmsByMonth.put(month, filmsOfMonth);

        String genre = film.getGenre();
        List<Film> filmsOfGenre = filmsByGenre.getOrDefault(genre, new ArrayList<>());
        filmsOfGenre.add(film);
        filmsByGenre.put(genre, filmsOfGenre);

        allFilms.add(film);
    }

    public List<Film> getFilmsByYear(int year) {
        return filmsByYear.getOrDefault(year, new ArrayList<>());
    }

    public List<Film> getFilmsByYearAndMonth(int year, int month) {
        List<Film> filmsOfYear = filmsByYear.getOrDefault(year, new ArrayList<>());
        List<Film> filmsOfYearAndMonth = new ArrayList<>();
        for (Film film : filmsOfYear) {
            if (film.getMonth() == month) {
                filmsOfYearAndMonth.add(film);
            }
        }
        return filmsOfYearAndMonth;
    }

    public List<Film> getFilmsByGenre(String genre) {
        return filmsByGenre.getOrDefault(genre, new ArrayList<>());
    }

    public List<Film> getTop10FilmsByRating() {
        List<Film> allFilmsCopy = new ArrayList<>(allFilms);
        allFilmsCopy.sort(Comparator.comparing(Film::getRating).reversed());
        return allFilmsCopy.subList(0, 10);
    }
}
