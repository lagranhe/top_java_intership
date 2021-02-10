package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MealRepositoryImpl implements MealRepository{



    public static final List<Meal> meals = new CopyOnWriteArrayList<>(
            Arrays.asList(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                    new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                    new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                    new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                    new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                    new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                    new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410))
    );

    @Override
    public List<Meal> getList() {
        return meals;
    }

    @Override
    public Meal get(int id) {
        for (Meal meal : meals){
            if (meal.getId() == id) {
                return meal;
            }
        }
        return null;
    }

    @Override
    public void create(Meal meal) {
        meals.add(new Meal(meal.getDateTime(), meal.getDescription(), meal.getCalories()));
    }

    @Override
    public void update(Meal oldMeal, Meal newMeal) {
        for (Meal mealsFromList : meals){
            if (oldMeal.getId() == mealsFromList.getId()) {
                mealsFromList.setCalories(newMeal.getCalories());
                mealsFromList.setDateTime(newMeal.getDateTime());
                mealsFromList.setDescription(newMeal.getDescription());
                return;
            }
        }
    }

    @Override
    public void delete(Meal meal) {
        meals.remove(meal);
    }
}
