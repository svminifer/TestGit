public class BeanMapUtilByReflect {



	/**
	 * map转对象
	 * @param map
	 * @param beanClass
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T> T mapToBean(Map map, Class<T> beanClass) throws Exception {
		T object = beanClass.newInstance();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}
			field.setAccessible(true);
			if (map.containsKey(field.getName())) {
				field.set(object, map.get(field.getName()));
			}
		}
		return object;
	}
}