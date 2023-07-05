import org.slf4j.LoggerFactory;

import static java.util.Objects.isNull;

import org.slf4j.Logger;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Horse {
    Logger logger = LoggerFactory.getLogger("[Horse]");
    private final String name;
    private final double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        if (isNull(name)) {
           logger.error( "Name is null");
            throw new IllegalArgumentException("Name cannot be null.");
        } else if (name.isBlank()) {
            logger.error(" Name is blank");
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (speed < 0) {
            logger.error(" Speed is negative");
            throw new IllegalArgumentException("Speed cannot be negative.");
        }
        if (distance < 0) {
            logger.error(" Distance is negative");
            throw new IllegalArgumentException("Distance cannot be negative.");
        }

        this.name = name;
        this.speed = speed;
        this.distance = distance;
        logger.debug("Создание Horse , имя " + this.name +" ,скорость " +this.speed );
    }

    public Horse(String name, double speed) {
        this(name, speed, 0);
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void move() {
        distance += speed * getRandomDouble(0.2, 0.9);
    }

    public static double getRandomDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }
}
