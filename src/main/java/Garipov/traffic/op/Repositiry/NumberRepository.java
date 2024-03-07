package Garipov.traffic.op.Repositiry;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

@Component
public class NumberRepository {

    private LinkedHashSet<String> storageOfNumbers;


    @PostConstruct
    public void init() {
        storageOfNumbers = new LinkedHashSet<>();
    }


    public LinkedHashSet<String> getNumbers () {
        return storageOfNumbers;
    }

    public boolean addNumber(String carNumber) {
        return storageOfNumbers.add(carNumber);
    }
}