package stringbuilder;

public class NameBuilder {
    private Title title;
    private String familyName;
    private String middleName;
    private String givenName;

    public NameBuilder() {
    }

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
            sb.append(title.getTitleString()).append(" ").append(givenName.trim()).append(" ");
        } else {
            sb.append(givenName.trim()).append(" ");
        }

        if (middleName!= null && !"".equals(middleName)) {
            sb.append(middleName.trim()).append(" ").append(familyName.trim());
        } else {
            sb.append(familyName.trim());
        }
        return sb.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        StringBuilder nameString = new StringBuilder();

        if (title != null) {
            nameString.append(title.getTitleString()).append(" ").append(familyName);
        } else {
            nameString.append(familyName);
        }

        nameString.append(" ");

        if (middleName != null && !"".equals(middleName)) {
            nameString.append(middleName).append(" ");
        }
        nameString.append(givenName);

        return nameString.toString();
    }

    public String insertTitle(String name, Title title, String where) {         // Solution
        StringBuilder sb = new StringBuilder(name);
        int index = sb.indexOf(where);
        sb.insert(index + 1, (title.getTitleString() + " "));
        return sb.toString();
    }

    public String deleteNamePart(String name, String delete) {                   // Solution
        int index = name.indexOf(delete);

        StringBuilder sb = new StringBuilder(name);
        sb.delete(index, index + delete.length());

        return sb.toString();
    }


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
