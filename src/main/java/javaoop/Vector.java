package javaoop;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double lengthModuleVector() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getScalarMultiplication(Vector vector1, Vector vector2) {
        return vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY() + vector1.getZ() * vector2.getZ();
    }

    public static List<Vector> getRandomVectors(int quantity) {
        List<Vector> vectors = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            double x = new Random().nextDouble();
            double y = new Random().nextDouble();
            double z = new Random().nextDouble();
            vectors.add(new Vector(x, y, z));
        }
        return vectors;
    }

}
