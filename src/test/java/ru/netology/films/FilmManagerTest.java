package ru.netology.films;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
Менеджер должен уметь выполнять следующие операции:
Добавление нового фильма.
Вывод всех фильмов в порядке добавления (findAll).
Вывод максимально лимит* штук последних добавленных фильмов в обратном от добавления порядке (findLast).
 */
public class FilmManagerTest {
    FilmManager manager = new FilmManager();

    @Test //1 все фильмы

    public void allFilms() {
        manager.addFilm("Name_1");
        manager.addFilm("Name_2");
        manager.addFilm("Name_3");
        manager.addFilm("Name_4");
        manager.addFilm("Name_5");
        manager.addFilm("Name_6");
        manager.addFilm("Name_7");

        String[] actual = manager.findAll();
        String[] expected = {"Name_1", "Name_2", "Name_3", "Name_4", "Name_5", "Name_6", "Name_7"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //2 добавить только 1 фильм

    public void addOnlyOneFilm() {
        manager.addFilm("Name_1");

        String[] actual = manager.findAll();
        String[] expected = {"Name_1"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //3 ничего не добавляем

    public void noFilms() {

        String[] actual = manager.findAll();
        String[] expected = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //4 вывод 5 последних фильмов из пяти

    public void limitFilmsWhen5() {
        manager.addFilm("Name_1");
        manager.addFilm("Name_2");
        manager.addFilm("Name_3");
        manager.addFilm("Name_4");
        manager.addFilm("Name_5");

        String[] actual = manager.findLast();
        String[] expected = {"Name_5", "Name_4", "Name_3", "Name_2", "Name_1"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //5 вывод 5 последних фильмов, когда кол-во меньше 5

    public void limitFilmsWhen3() {
        manager.addFilm("Name_1");
        manager.addFilm("Name_2");
        manager.addFilm("Name_3");

        String[] actual = manager.findLast();
        String[] expected = {"Name_3", "Name_2", "Name_1"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //6 вывод 5 последних фильмов, когда кол-во больше 5

    public void limitFilmsWhen10() {
        manager.addFilm("Name_1");
        manager.addFilm("Name_2");
        manager.addFilm("Name_3");
        manager.addFilm("Name_4");
        manager.addFilm("Name_5");
        manager.addFilm("Name_6");
        manager.addFilm("Name_7");
        manager.addFilm("Name_8");
        manager.addFilm("Name_9");
        manager.addFilm("Name_10");

        String[] actual = manager.findLast();
        String[] expected = {"Name_10", "Name_9", "Name_8", "Name_7", "Name_6"};

        Assertions.assertArrayEquals(expected, actual);
    }
}