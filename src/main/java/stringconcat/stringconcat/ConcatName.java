package stringconcat.stringconcat;

import java.util.List;

import static stringconcat.stringconcat.Title.MR;
import static stringconcat.stringconcat.Title.MRS;

public class ConcatName {
    private Title title;
    private String familyName;
    private String middleName;
    // private List<String> middleNames;
    private String givenName;

    public ConcatName(Title title, String familyName, String middleName, String givenName) {
        this.title = title;
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public ConcatName(String familyName, String middleName, String givenName) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public ConcatName(String familyName, String middleName, String givenName, Title title) {
        this(familyName, middleName, givenName);
        this.title = title;
    }

    public String concatNameWesternStyle() {
        String nameString;
        if (isEmpty(title.getTitleString())) {
            nameString = "";
        } else {
            nameString = title.getTitleString().trim() + ". ";
        }

        if (isEmpty(givenName)) {
            throw new IllegalArgumentException("Given name must be filled!");
        } else {
            nameString = nameString.concat(givenName.trim()) + " ";
        }

        if (isEmpty(middleName)) {
            nameString = nameString;
        }
        else {
            nameString = nameString.concat(middleName.trim()) + " ";
        }
/*
        if (middleNames.size() != 0 ) {
            for (String m : middleNames) {
                nameString += (m.trim() + " ");
            }
            return nameString;
        } else {
            nameString = nameString;
        }

 */

        if (isEmpty(familyName)) {
            throw new IllegalArgumentException("Family name must be filled!");
        } else {
            nameString = nameString.concat(familyName.trim());
        }

        return nameString;
    }

    public String concatNameHungarianStyle() {
        String nameString;
        if (isEmpty(givenName) || isEmpty(familyName)) {
            throw new IllegalArgumentException("Family name and given name must be filled!");
        } else {
            nameString = title.getTitleString().trim() + ". " + familyName.trim();
        }
        if (isEmpty(middleName)) {
            nameString = nameString + " " + givenName.trim();
        }
        else {
            nameString = nameString + " " + middleName.trim() + " " + givenName.trim();
        }
        return nameString;
    }

    public String concatNameWesternStyle2() {                       // Solution

        String nameString;

        if (title != null) {
            nameString = title.getTitleString();
            nameString = nameString.concat(" ");
            nameString = nameString.concat(givenName);
        } else {
            nameString = givenName;
        }
        nameString = nameString.concat(" ");
        if (middleName != null && !"".equals(middleName)) {
            nameString = nameString.concat(middleName);
            nameString = nameString.concat(" ");
        }
        nameString = nameString.concat(familyName);

        return nameString;
    }

    public String concatNameHungarianStyle2() {                     // Solution

        String nameString;

        if (title != null) {
            nameString = title.getTitleString();
            nameString += " ";
            nameString += familyName;
        } else {
            nameString = familyName;
        }

        nameString += " ";

        if (middleName != null && !"".equals(middleName)) {
            nameString += middleName;
            nameString += " ";
        }
        nameString += givenName;

        return nameString;
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
        ConcatName concatName1 = new ConcatName(Title.DR, "Brown", "James", "Jack");
        System.out.println(concatName1.concatNameWesternStyle());
        System.out.println(concatName1.concatNameHungarianStyle());

        ConcatName concatName2 = new ConcatName(MRS, "  Smith   ", "", "    Judith");
        System.out.println(concatName2.concatNameWesternStyle());
        System.out.println(concatName2.concatNameHungarianStyle());

        ConcatName concatName3 = new ConcatName(MR, "Brown", "", "");
        // System.out.println(concatName3.concatNameWesternStyle());
        System.out.println(concatName3.concatNameHungarianStyle());
    }
}
