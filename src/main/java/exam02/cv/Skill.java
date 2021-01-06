package exam02.cv;

public class Skill {

    private String name;
    private int level;

    // private SkillLevel skillLevel;


    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return name + "(" + level + ")";
    }


}
