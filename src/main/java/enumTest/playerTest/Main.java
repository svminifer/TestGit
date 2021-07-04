package enumTest.playerTest;


public class Main {

	public static void main(String[] args) {
		Player player1 = new Player();
		Player player2 = new Player();

		player1.setId(1);
		player1.setName("shi");

		player2.setId(2);
		player2.setName("zhang");

		SkillEffectEnum skillEffectEnum = SkillEffectEnum.get(1);
		skillEffectEnum.executeEffect(player1,player2);


	}

}
