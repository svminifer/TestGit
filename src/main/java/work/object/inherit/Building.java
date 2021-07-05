package work.object.inherit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 建筑
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    private long id;
    private int type;
    private String name;

}
