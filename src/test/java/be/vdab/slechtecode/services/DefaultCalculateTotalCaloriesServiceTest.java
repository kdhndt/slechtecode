package be.vdab.slechtecode.services;

import be.vdab.slechtecode.domain.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultCalculateTotalCaloriesServiceTest {
    private DefaultCalculateTotalCaloriesService service;
    private Food food1;
    private Food food2;

    @BeforeEach
    void beforeEach() {
        service = new DefaultCalculateTotalCaloriesService();
        food1 = new Food(10, 15, 12, 20);
        food2 = new Food(5, 8, 6, 10);
    }

    @Test
    void berekenTotaal() {
        var food1Calories = (food1.getCarbs() * food1.getFat() * food1.getProtein()) / food1.getEnergy();
        var food2Calories = (food2.getCarbs() * food2.getFat() * food2.getProtein()) / food2.getEnergy();
        Food[] myArray = {food1, food2};
        service.add(myArray);
        assertThat(service.total()).isEqualTo(food1Calories + food2Calories);
    }

}