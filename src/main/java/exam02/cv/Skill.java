package exam02.cv;

public class Skill {

    private String skillName;

    private SkillLevel skillLevel;

    public Skill(String skillName, SkillLevel skillLevel) {
        this.skillName = skillName;
        this.skillLevel = skillLevel;
    }

    public String getSkillName() {
        return skillName;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    @Override
    public String toString() {
        return skillName + "(" + skillLevel + ")";
    }


}
