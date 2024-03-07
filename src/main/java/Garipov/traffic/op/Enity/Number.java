package Garipov.traffic.op.Enity;

public class Number {
    private String id;
/** Так как в задании не ссылаются на то, что нужно сохранять в БД,
 но в дальнейшем можно сюда добавить связь с БД, а также добавить
 допольнительные поля(фото авто, вин номер, цвет и тд..
 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Number(String id) {
        this.id = id;
    }

    public Number() {
    }
}

