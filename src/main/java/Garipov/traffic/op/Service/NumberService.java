package Garipov.traffic.op.Service;

import Garipov.traffic.op.Repositiry.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Random;

@Service
public class NumberService {

    private NumberRepository numberRepo;

    @Autowired
    public void setNumberRepo(NumberRepository numberRepo) {
        this.numberRepo = numberRepo;
    }

    public LinkedHashSet<String> getNumbers() {
        return numberRepo.getNumbers();
    }

    private final Random randomizer = new Random();

    private final char[] charExamples = (char[]) Constants.CHAR_EXAMPLES.getValue();
    private final String NUM_APPENDER_SINGLE = (String) Constants.NUM_APPENDER_SINGLE.getValue();
    private final String NUM_APPENDER_DOUBLE = (String) Constants.NUM_APPENDER_DOUBLE.getValue();
    private final String NUM_APPENDER_REG = (String) Constants.NUM_APPENDER_REG.getValue();
    private final int MAX_CHAR_POSITION = charExamples.length - 1;

    private final StringBuilder carNumber = new StringBuilder();

    private int firstCharPosition;
    private int secondCharPosition;
    private int thirdCharPosition;
    private int numberDigits;

    public String addNextNumber() {
        while (true) {
            carNumber.delete(0, carNumber.length());
            if (numberDigits > 999) {
                numberDigits = 0;
                thirdCharPosition++;
                if (thirdCharPosition > MAX_CHAR_POSITION) {
                    thirdCharPosition = 0;
                    secondCharPosition++;
                }
                if (secondCharPosition > MAX_CHAR_POSITION) {
                    secondCharPosition = 0;
                    firstCharPosition++;
                }
                if (firstCharPosition > MAX_CHAR_POSITION) throw new RuntimeException("Номера закончились!");
            }
            carNumber.append(charExamples[firstCharPosition]);
            if (numberDigits < 10) carNumber.append(NUM_APPENDER_DOUBLE);
            else if (numberDigits < 100) carNumber.append(NUM_APPENDER_SINGLE);
            carNumber.append(numberDigits++)
                    .append(charExamples[secondCharPosition])
                    .append(charExamples[thirdCharPosition])
                    .append(NUM_APPENDER_REG);
            if (numberRepo.addNumber(carNumber.toString())) return carNumber.toString();
        }
    }

    public String addRandomNumber() {
        while (true) {
            carNumber.delete(0, carNumber.length());
            carNumber.append(charExamples[randomizer.nextInt(MAX_CHAR_POSITION)]);
            int randomDigits = randomizer.nextInt(999);
            if (randomDigits < 10) carNumber.append(NUM_APPENDER_DOUBLE);
            else if (randomDigits < 100) carNumber.append(NUM_APPENDER_SINGLE);
            carNumber.append(randomDigits)
                    .append(charExamples[randomizer.nextInt(MAX_CHAR_POSITION)])
                    .append(charExamples[randomizer.nextInt(MAX_CHAR_POSITION)])
                    .append(NUM_APPENDER_REG);
            if (numberRepo.addNumber(carNumber.toString())) return carNumber.toString();
        }
    }
}
