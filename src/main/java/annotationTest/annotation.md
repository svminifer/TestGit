# annotation 注解

## 疑惑

1. 运行期，是否可以动态修改注解的值，并获取动态值？

   答：目前好像不能
2. 是否可以使用注解去限制方法的参数个数、类型等，若有限制，则让其编译期报错？

   答：需要自己写一个编译时执行的注解处理器，然后添加到编译步骤里去。[参考](https://bbs.csdn.net/topics/391960157)
3. 为什么 @Override 就可以实现编译期的检测？

   答：idea-setting-java compiler-annotation processing#enable project specific settings