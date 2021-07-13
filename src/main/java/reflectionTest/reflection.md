[toc]

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

## 学习参考

[java获取包下被指定注解的类](https://www.cnblogs.com/ggband/p/11668879.html)

[java获取全部子类或接口的全部实现](https://www.cnblogs.com/linkenpark/p/11383355.html)

[Java高性能反射工具包ReflectASM](https://www.cnblogs.com/juetoushan/p/7724793.html)