package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    /*
    CV
    Egy önéletrajzot reprezentáló osztályt kell létrehozni, melyben van egy név,
    valamint skillek (hogy mihez ért az illető).
    A skill egy névvel és egy számmal (szint) rendelkezik, utóbbi 1 - 5 között.

    Az önéletrajz a Cv osztály pár metódussal, a skill a Skill osztály.

    A skillek megadása a nevével, valamint a szintjével történik, pl. programming (5).

    A findSkillLevelByName() a skill neve alapján visszaadja annak szintjét.
     */


    private String name;

    private Skill skill;

    private List<Skill> skillList = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public Cv(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    /*
    // ConcurrentModificationException
    public List<Skill> addSkills(String name, int level, List<Skill> skillList) {
        for (Skill s: skillList) {
            if (!s.getName().equals(name)) {
                skillList.add(new Skill(name, level));
            }
        }
        return skillList;
    }

     */

    public int findSkillLevelByName(List<Skill> skillList, String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name!");
        }
        int find = 0;
        for (Skill s: skillList) {
            if (s.getName().equals(name)) {
                find = s.getLevel();
            }
        }
        return find;
    }

    public String getName() {
        return name;
    }

    public Skill getSkill() {
        return skill;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public static void main(String[] args) {
        Cv cv = new Cv("John Doe");
        Skill skill1 = new Skill("engineer", 5);
        Skill skill2 = new Skill("car driver", 4);
        Skill skill3 = new Skill("sport man", 2);
        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill1);
        skillList.add(skill2);
        skillList.add(skill3);

        System.out.println(cv.findSkillLevelByName(skillList,"sport man"));

        // System.out.println(cv.addSkills("teacher", 5, skillList));
    }
}
