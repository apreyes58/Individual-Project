package com.example.individualproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FilmService {
    @Autowired private Top5FilmRepo top5;
    @Autowired private FilmSearchRepo search;

    public List<Film> topFive()
    {
        List<Object[]> objects = top5.getTopFive();
        List<Film> bestFilms = new ArrayList<>();

        for (Object[] film: objects)
        {
            String id = String.valueOf(film[0]);
            String title = String.valueOf(film[1]);
            String desc = String.valueOf(film[2]);
            String length = String.valueOf(film[3]);
            String rating = String.valueOf(film[4]);
            String rented = String.valueOf(film[5]);
            String category = String.valueOf(film[6]);

            bestFilms.add(new Film(id, title, desc, length, rating, rented, category, null));
        }
        return bestFilms;
    }

    public List<Film> getSearch()
    {
        List<Object[]> objects = search.getFilmSearch();
        List<Film> searchFilms = new ArrayList<>();
        for (Object[] film: objects)
        {
            String id = String.valueOf(film[0]);
            String title = String.valueOf(film[1]);
            String description = String.valueOf(film[2]);
            String length = String.valueOf(film[3]);
            String rating = String.valueOf(film[4]);
            String category = String.valueOf(film[5]);
            String rented = String.valueOf(film[6]);
            String actorList = (String) film[7];
            List<String> actors = Arrays.asList(actorList.split(", "));
            searchFilms.add(new Film(id, title, description, length, rating, rented, category, actors));
        }
        return searchFilms;
    }
}
