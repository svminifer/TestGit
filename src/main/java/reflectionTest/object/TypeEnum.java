package reflectionTest.object;


import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum TypeEnum {
    BOY(1),
    GIRL(2),
    ;
    private int id;

    TypeEnum(int id) {
        this.id = id;
    }

    private final static Map<Integer, TypeEnum> map = Stream.of(TypeEnum.values()).collect(Collectors.toMap(TypeEnum::getId, e -> e));

    public TypeEnum getById(int id) {
        return map.get(id);
    }

}
