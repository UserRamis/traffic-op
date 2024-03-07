package Garipov.traffic.op.Enity;

public class Number {
    private long id;
/** Так как в задании не ссылаются на то, что нужно сохранять в БД,
 но в дальнейшем можно сюда добавить связь с БД, а также добавить
 допольнительные поля(фото авто, вин номер, цвет и тд..
 */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Number(long id) {
        this.id = id;
    }

    public Number() {
    }
}

