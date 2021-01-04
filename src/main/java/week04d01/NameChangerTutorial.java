package week04d01;

public class NameChangerTutorial {          // Kristóf
    private String fullName;

    public NameChangerTutorial(String fullName) {
        if (fullName == null || fullName.trim().equals("")) {
            throw new IllegalArgumentException("Invalid name" + fullName);
        }
        this.fullName = fullName;
    }

    public void changeFirstName(String firstname){
        String [] temp = fullName.split(" ");
        fullName = new StringBuilder(firstname).append(" " + temp[1]).toString();     // átírtam a sorrendet
    }

    public String getFullName() {
        return fullName;
    }


}
