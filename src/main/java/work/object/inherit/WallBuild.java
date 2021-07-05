package work.object.inherit;

import lombok.*;

/**
 * 具有属性的建筑
 */
@Getter
@Setter
@NoArgsConstructor
public class WallBuild extends Building {
    private int blood;

    public WallBuild(long id, int type, String name, int blood) {
        super(id, type, name);
        this.blood = blood;
    }

    public WallBuild(int blood) {
        this.blood = blood;
    }
}
