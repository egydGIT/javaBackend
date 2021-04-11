package stringmethods.filename;

public class FileNameManipulator {
    public Character findLastCharacter(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        }
        int i = str.trim().length();
        //String c = str.substring(i-1);
        Character c = str.charAt(i-1);
        return c;
    }

    public String findFileExtension(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        int i = fileName.trim().lastIndexOf(".");
        if (i < 1 || i == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        String fileExtension = fileName.substring(i+1);
        return fileExtension;
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (isEmpty(fileName) || isEmpty(ext)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        int i = fileName.trim().lastIndexOf(".");
        if (i < 1 || i == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.trim().endsWith(ext.trim());
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (isEmpty(searchedFileName) || isEmpty(actualFileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return searchedFileName.trim().equalsIgnoreCase(actualFileName.trim());
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        int i = fileName.trim().lastIndexOf(".");
        if (i < 1 || i == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        String givenName = fileName.substring(0, i);
        String extensionToLoweCase = fileName.substring(i+1).toLowerCase();
        return givenName.concat("." + extensionToLoweCase);
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        String repleacedFileName = null;
        if (fileName.contains(present)) {
            return repleacedFileName = fileName.replace(present, target);
        }
        return fileName;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
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
