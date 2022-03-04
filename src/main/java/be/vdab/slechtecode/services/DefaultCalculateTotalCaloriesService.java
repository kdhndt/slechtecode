package be.vdab.slechtecode.services;

import be.vdab.slechtecode.domain.Food;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DefaultCalculateTotalCaloriesService implements CalculateTotalCaloriesService {
    private int numberOfCalories;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void add(Food[] arrayOfFood) {
        Arrays.stream(arrayOfFood).forEach(food -> {
            update(food.getCarbs(), food.getFat(), food.getProtein(), food.getEnergy());
        });
    }

    public void update(Double carbs, Double fat, Double protein, Double energy) {
        if (carbs == null) {
            throw new NullPointerException();
        }
        try {
            numberOfCalories += ((carbs * fat * protein) / energy);
        } catch (ArithmeticException e) {
            logger.error("Wiskundige fout");
        }
    }

    public double total() {
        return numberOfCalories;
    }
}
