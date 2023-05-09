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

   public boolean checkcross (Rectangle b) {
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
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(posA, rectangle.posA) && Objects.equals(posB, rectangle.posB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posA, posB);
    }

}
