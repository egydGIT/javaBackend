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
/*
    public ConcatName(String dr, String brown, String familyName, String givenName) {
        this.title = title;
        this.familyName = familyName;
        this.middleNames = middleNames;
        this.givenName = givenName;
    }

 */


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
/*
    public String concatNameHungarianStyle() {
        // ugyanez, csak más a sorrend
        // konkatenáció: + operátorral vagy .concat() metódussal
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
        ConcatName concatName1 = new ConcatName(Title.DR, "Brown", "James", "Jack");
        System.out.println(concatName1.concatNameWesternStyle());

        ConcatName concatName2 = new ConcatName(MRS, "  Smith   ", "", "    Judith");
        System.out.println(concatName2.concatNameWesternStyle());

        ConcatName concatName3 = new ConcatName(MR, "Brown", "", "");
        System.out.println(concatName3.concatNameWesternStyle());
    }
}
