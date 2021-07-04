package work.object.inherit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum BuildTypeEnum {
    Server(0),

    ECONOMICS(1),

    DEFEND(2) {
    },

    DECORATION(3),
    ;

    // Stream.of() 或 Arrays.stream()
    private static Map<Integer, BuildTypeEnum> buildTypeMap = Arrays.stream(BuildTypeEnum.values()).collect(Collectors.toMap(BuildTypeEnum::getType, e -> e));

    private int type;

    static BuildTypeEnum getById(int type) {
        return buildTypeMap.get(type);
    }

}
