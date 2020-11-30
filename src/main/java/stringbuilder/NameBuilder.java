package stringbuilder;

import stringconcat.stringconcat.Title;

public class NameBuilder {
    private Title title;
    private String familyName;
    private String middleName;
    private String givenName;

    public NameBuilder(Title title, String familyName, String middleName, String givenName) {
        this.title = title;
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        StringBuilder sb = new StringBuilder();
        if (isEmpty(givenName) || isEmpty(familyName)) {
            throw new IllegalArgumentException("Family name and given name must be filled!");
        }
        if (title != null) {
            sb.append(title.getTitleString()).append(". ").append(givenName.trim()).append(" ");
        } else {
            sb.append(givenName.trim()).append(" ");
        }
        if (middleName!= null) {
            sb.append(middleName.trim()).append(" ").append(familyName.trim());
        } else {
            sb.append(familyName.trim());
        }
        return sb.toString();
    }
/*
    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {

    }

    public String insertTitle(String name, Title title, String where) {

    }

    public String deleteNamePart(String name, String delete) {

    }
 */


    public Title getTitle() {
        return title;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGivenName() {
        return givenName;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static void main(String[] args) {
        NameBuilder nameBuilder = new NameBuilder(Title.DR, "Brown", "James", "Jack");

        System.out.println(nameBuilder.concatNameWesternStyle
                ("Brown", "James", "Jack", Title.DR));
        System.out.println(nameBuilder.concatNameWesternStyle
                ("    Brown", "     ", "  Kate   ", Title.MRS));
    }
}
