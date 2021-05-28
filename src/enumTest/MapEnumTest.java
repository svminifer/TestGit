package enumTest;

public class MapEnumTest {
    /**
     * 四季枚举
     */
    private enum SimpleEnum {
        SPRING,
        SUMMER,
        AUTUMN,
        WINTER
    }


    private enum TYPE {
        FIREWALL("firewall"),
        SECRET("secretMac"),
        BALANCE("f5");

        private String typeName;

        TYPE(String typeName) {
            this.typeName = typeName;

        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        /**
         * 根据类型的名称，返回对应的枚举实例
         *
         * @param typeName
         * @return
         */
        public static TYPE fromTypeName(String typeName) {
            for (TYPE type : TYPE.values()) {
                if (type.typeName.equals(typeName)) return type;
            }
            return null;
        }
    }

    private static void forEnum() {
        for (SimpleEnum simpleEnum : SimpleEnum.values()) {
            System.out.println(simpleEnum + " ordinal " + simpleEnum.ordinal());
        }
        System.out.println("---------------------------");
        for (TYPE type : TYPE.values()) {
            System.out.println("type=" + type + " type.name=" + type.name() + " typeName=" + type.getTypeName());
        }
    }

    private static void useEnumInJava() {
        String typeName = "f5";
        TYPE type = TYPE.fromTypeName(typeName);
        if (TYPE.BALANCE.equals(type)) {
            System.out.println("根据字符串获得的枚举类型实例跟枚举常量一致");
        } else {
            System.out.println("大师兄代码错误");
        }
    }

    public static void main(String[] args) {
        forEnum();
        useEnumInJava();

        TYPE type = TYPE.fromTypeName("f5");
        System.out.println(type.getTypeName());
    }
}
