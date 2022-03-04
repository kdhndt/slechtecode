package be.vdab.slechtecode.domain;

public class Food {
    double carbs;
    double fat;
    double protein;
    double energy;

    public Food(double carbs, double fat, double protein, double energy) {
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
        this.energy = energy;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }

    public double getEnergy() {
        return energy;
    }
}
