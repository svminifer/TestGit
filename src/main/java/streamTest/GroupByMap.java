package streamTest;


import java.util.*;
import java.util.stream.Collectors;


//版权声明：本文为CSDN博主「weixin_39614675」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/weixin_39614675/article/details/111863457
public class GroupByMap {

	public static void main(String[] args) {

		// list分组后按照某个字段求和

		List<User> users = new ArrayList();

		users.add(new User("tom", "bb", "cc", 1001));

		users.add(new User("tom", "bb", "cc", 414));
		users.add(new User("tom", "bb", "cc", 5014));

		users.add(new User("jerry", "dd", "ee", 30254));

		users.add(new User("jerry", "dd", "ee", 250));
		//Map<String, LongSummaryStatistics> collect = users.stream().collect(Collectors.groupingBy(user -> user.getName(), Collectors.summarizingLong(user -> user.scope)));
		//collect.forEach((k, v) -> {
		//	System.out.println(k + " " + v.getSum());
		//});
		Map<String, Object> collect = users.stream()
				.collect(Collectors.groupingBy(User::getName, Collectors.collectingAndThen(Collectors.toList(), u -> sortUser(u))));
		System.out.println();
	}

	public static List<User> sortUser(List<User> u) {
		u.sort((o1, o2) -> (int) (o1.getScope() - o2.getScope()));
		return u;
	}

	//运行结果
	//
	//User{name='jerry', phone='dd', address='ee', scope=70}
	//
	//User{name='tom', phone='bb', address='cc', scope=150}

	/**
	 * 分组后取list的第一个
	 */
	public static void MapgroupByAndGetOne() {
		//List<User> arrayList = new ArrayList<>();
		//Map<String, User> userMap = arrayList.stream().filter(user -> user.getPhone() == "123")
		//		.collect(Collectors.groupingBy(User::getName, Collectors.collectingAndThen(Collectors.toList(), users -> users.get(0))));
	}

	/**
	 * 分组后排序
	 */
	public static void MapGroupByAndSort() {
		//List<SeasonLevelWrapper> wrapperList = containerManager.getAll(SeasonLevelWrapper.class);
		//seasonLevelMap = wrapperList.stream()
		//		.collect(Collectors.groupingBy(SeasonLevelWrapper::getLayerTypeID, Collectors.collectingAndThen(Collectors.toList(), seasonLevelWrappers -> sortWrapper(seasonLevelWrappers))));
	}

	//public List<SeasonLevelWrapper> sortWrapper(List<SeasonLevelWrapper> wrapperList) {
	//	wrapperList.sort(Comparator.comparingInt(SeasonLevelConfig::getId));
	//	return wrapperList;
	//}
}


class User {

	public String name;

	public String phone;

	public String address;

	public int scope;

	public User(String name, String phone, String address) {

		this.name = name;

		this.phone = phone;

		this.address = address;
	}

	public User(String name, String phone, String address, int scope) {

		this.name = name;

		this.phone = phone;

		this.address = address;

		this.scope = scope;
	}

	@Override

	public String toString() {

		return "User{" +

				"name='" + name + '\'' +

				", phone='" + phone + '\'' +

				", address='" + address + '\'' +

				", scope=" + scope +

				'}';
	}

	@Override

	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		return Objects.equals(name, user.name) &&

				Objects.equals(phone, user.phone) &&

				Objects.equals(address, user.address) &&

				Objects.equals(scope, user.scope);
	}

	@Override

	public int hashCode() {

		return Objects.hash(name, phone, address);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

}



