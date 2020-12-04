package stringmethods.filename;

public class FileNameManipulator {
    public String findLastCharacter(String str) {
        int i = str.length();
        // char c = (char) str.substring(i-1, i-1);
        String c = str.substring(i-1);
        return c;
    }

    public String findFileExtension(String fileName) {
        int i = fileName.indexOf(".");
        String fileExtension = fileName.substring(i+1);
        return fileExtension;
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (fileName.endsWith(ext)) {
            return true;
        }
        return false;
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        searchedFileName.equals(actualFileName);
        return true;
    }

    public String changeExtensionToLowerCase(String fileName) {
        int i = fileName.indexOf(".");
        String givenName = fileName.substring(0, i);
        String extensionToLoweCase = fileName.substring(i+1).toLowerCase();
        return givenName.concat("." + extensionToLoweCase);
    }

    public String replaceStringPart(String fileName, String present, String target) {
        String repleacedFileName = null;
        if (fileName.contains(present)) {
            repleacedFileName = fileName.replace(present, target);
        }
        return repleacedFileName;
    }


    public static void main(String[] args) {
        System.out.println(new FileNameManipulator().findLastCharacter("Utósó karakter"));
        System.out.println(new FileNameManipulator().findFileExtension("HelloWord.java"));
        System.out.println(new FileNameManipulator().identifyFilesByExtension("exe", "HelloWord.html"));
        System.out.println(new FileNameManipulator().compareFilesByName("aw.mp4", "aw.mp4"));
        System.out.println(new FileNameManipulator().changeExtensionToLowerCase("HelloWord.XML"));
        System.out.println(new FileNameManipulator().replaceStringPart
                                                        ("HelloWord.java", "java", "class"));

        /*
        r
        java
        false
        true
        HelloWord.xml
        HelloWord.class
         */
    }

}
