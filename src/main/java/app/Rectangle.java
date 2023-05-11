package app;

import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import lombok.Getter;
import misc.*;
import org.w3c.dom.css.Rect;

import java.util.Objects;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle {
    public void paint(Canvas canvas, CoordinateSystem2i windowCS, CoordinateSystem2d ownCS) {
        try (Paint p = new Paint()) {
            p.setColor(getColor());
            // левая верхняя вершина
            Vector2i pointA = windowCS.getCoords(posA, ownCS);
            // правая нижняя
            Vector2i pointC = windowCS.getCoords(posB, ownCS);

            // рассчитываем опорные точки прямоугольника
            Vector2i pointB = new Vector2i(pointA.x, pointC.y);
            Vector2i pointD = new Vector2i(pointC.x, pointA.y);

            // рисуем его стороны
            canvas.drawLine(pointA.x, pointA.y, pointB.x, pointB.y, p);
            canvas.drawLine(pointB.x, pointB.y, pointC.x, pointC.y, p);
            canvas.drawLine(pointC.x, pointC.y, pointD.x, pointD.y, p);
            canvas.drawLine(pointD.x, pointD.y, pointA.x, pointA.y, p);
        }
    }

    /**
     * Получить цвет точки по её множеству
     *
     * @return цвет точки
     */
    public int getColor() {
        return switch (rectangleSet) {
            case FIRST_SET -> Misc.getColor(0xAA, 0x00, 0x00, 0xFF);
            case SECOND_SET -> Misc.getColor(0xAA, 0x00, 0xFF, 0x0);
        };
    }

    /**
     * Множества
     */
    public enum RectangleSet {
        /**
         * Первое
         */
        FIRST_SET,
        /**
         * Второе
         */
        SECOND_SET
    }

    /**
     * Множество, которому принадлежит прямоугольник
     */
    protected final RectangleSet rectangleSet;

    /**
     * Конструктор прямоугольника
     *
     * @param posA    положение прямоугольника
     * @param posB    положение прямоугольника
     * @param setType множество, которому она принадлежит
     */
    public Rectangle(Vector2d posA, Vector2d posB, RectangleSet setType) {
        this.posA = posA;
        this.posB = posB;
        this.rectangleSet = setType;
    }

    @Getter
    private final Vector2d posA;
    @Getter
    private final Vector2d posB;

    public boolean checkcross(Rectangle b) {
        // a.posA.x - точка
        if ((this.posA.x >= min(b.posA.x, b.posB.x)) && (this.posA.x <= max(b.posA.x, b.posB.x)) && (this.posA.y >= min(b.posA.y, b.posB.y)) && (this.posA.x <= max(b.posA.y, b.posB.y))) {
            return true;
        }
        if ((this.posB.x >= min(b.posA.x, b.posB.x)) && (this.posB.x <= max(b.posA.x, b.posB.x)) && (this.posB.y >= min(b.posA.y, b.posB.y)) && (this.posB.x <= max(b.posA.y, b.posB.y)))
            return true;
        if ((b.posA.x >= min(this.posA.x, this.posB.x)) && (b.posA.x <= max(this.posA.x, this.posB.x)) && (b.posA.y >= min(this.posA.y, this.posB.y)) && (b.posA.x <= max(this.posA.y, this.posB.y))) {
            return true;
        }
        if ((b.posB.x >= min(this.posA.x, this.posB.x)) && (b.posB.x <= max(this.posA.x, this.posB.x)) && (b.posB.y >= min(this.posA.y, this.posB.y)) && (b.posB.x <= max(this.posA.y, this.posB.y)))
            return true;
        return false;
    }

    ;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(posA, rectangle.posA) && Objects.equals(posB, rectangle.posB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posA, posB);
    }

}
