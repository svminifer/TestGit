package enumTest.playerTest;


import java.util.HashMap;
import java.util.Map;


public enum SkillEffectEnum {

	HURT(1) {
		@Override
		public void executeEffect(Player attacker, Player targeter) {
			System.out.println(attacker.getName() + " hurt " + targeter.getName());
		}
	},
	CURE(2) {
		@Override
		public void executeEffect(Player attacker, Player targeter) {
			System.out.println(attacker.getName() + " cute " + targeter.getName());
		}
	};

	private int effectType;

	// 构造方法
	SkillEffectEnum(int effectType) {
		this.effectType = effectType;
	}

	// 抽象方法--行为
	public abstract void executeEffect(Player attacker, Player targeter);

	private static Map<Integer, SkillEffectEnum> SKILL_EFFECT_MAP = new HashMap<>();

	static {
		for (SkillEffectEnum skillEffectEnum : SkillEffectEnum.values()) {
			SKILL_EFFECT_MAP.put(skillEffectEnum.getEffectType(), skillEffectEnum);
		}
	}

	public static SkillEffectEnum get(int skillEffectType) {
		return SKILL_EFFECT_MAP.get(skillEffectType);
	}

	public int getEffectType() {
		return effectType;
	}

	public void setEffectType(int effectType) {
		this.effectType = effectType;
	}

}
