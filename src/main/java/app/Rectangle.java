package app;

import lombok.Getter;import misc.Vector2d;
import org.w3c.dom.css.Rect;

import java.util.Objects;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle {
    @Getter
    private final Vector2d posA;
    @Getter
    private final Vector2d posB;

   public boolean checkcross ( Rectangle b) {
       Rectangle a = this;
        // a.posA.x - точка
        if ((a.posA.x >= min(b.posA.x, b.posB.x)) && (a.posA.x <= max(b.posA.x, b.posB.x)) && (a.posA.y >= min(b.posA.y, b.posB.y)) && (a.posA.x <= max(b.posA.y, b.posB.y))) {
            return true;
        }
        if ((a.posB.x >= min(b.posA.x, b.posB.x)) && (a.posB.x <= max(b.posA.x, b.posB.x)) && (a.posB.y >= min(b.posA.y, b.posB.y)) && (a.posB.x <= max(b.posA.y, b.posB.y)))
            return true;
        return false;
    };

    public Rectangle (Vector2d posA, Vector2d posB) {
        this.posA = posA;
        this.posB = posB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Rectangle circle = (Rectangle) o;
        return Objects.equals(posA, circle.posA) && Objects.equals(posB, circle.posB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posA, posB);
    }


}
