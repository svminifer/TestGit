package work.object.inherit;


/**
 * <pre>
 * 对象的三大特性（继承、封装、多态）
 * 本例：
 *      建筑Building是超类，具有基本信息
 *      城墙WallBuild是派生类，除具有建筑的公有信息外，还具有自己的成员变量blood
 * 特性体现：
 *      继承：WallBuild继承Building
 *      封装：WallBuild和Building通过使用private私有修饰成员变量，提供公有的方法作为对外接口
 *      多态：
 *          Building building = null;
 *          WallBuild wall =(WallBuild) building 父类（Building)变量通过强制转换成子类(WallBuild)引用类型
 * 了解：枚举状态机--不同的建筑类型有不同的
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Building market = new Building(1L, 1, "市场");
        WallBuild wall = new WallBuild(2L, 2, "城墙", 1000);
        // 只有具有属性的建筑才会进行属性改变
        reduceAttr(market, 100);
        reduceAttr(wall, 100);

    }

    /**
     * 减少属性值
     *
     * @param building 建筑
     * @param value    减少值
     */
    static void reduceAttr(Building building, int value) {
        if (!(building instanceof WallBuild))
            return;
        WallBuild wallBuild = (WallBuild) building;
        int blood = wallBuild.getBlood() - value;
        blood = blood > 0 ? blood : 0;
        wallBuild.setBlood(blood);
        System.out.printf("%s：防御类属性值减少：%d 当前值： %d", wallBuild.getName(), value, blood);
    }


    void test() {
        //        List<Student> studentList = new ArrayList<>();
//
//        studentList.add(new Student("zhangsan1", "男", 12));
//        studentList.add(new Student("zhangsan2", "男", 12));
//        studentList.add(new Student("zhangsan3", "男", 12));
//        studentList.add(new Student("zhangsan4", "男", 12));
//
//        Map<String, Student> studentMap = studentList.stream().collect(Collectors.toMap(Student::getName, student -> student));
//
//        System.out.println(studentMap.size());
    }
}
