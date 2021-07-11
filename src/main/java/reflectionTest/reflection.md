# reflection

## 获取Class对象

方式：

1. 当知道全路径类名时

```java
Class str=Class.forName(”java.lang.String“);
```

2. 编译前知道要操作的类时

```java
class str =String.class;
```

3. 使用类对象的getClass方法

```java
String str=new String();
        Class strClass=str.getClass();
```

## 反射

获取Class对象之后，就可以通过相应的方法取获取类相关的属性以及方法，具体断点调试ReflectionTest。