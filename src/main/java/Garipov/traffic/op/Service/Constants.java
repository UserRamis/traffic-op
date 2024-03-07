package Garipov.traffic.op.Service;

public enum Constants {
    CHAR_EXAMPLES(new char[] {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'}),
    NUM_APPENDER_SINGLE("0"),
    NUM_APPENDER_DOUBLE("00"),
    NUM_APPENDER_REG("116RUS");

    private final Object value;

    Constants(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}