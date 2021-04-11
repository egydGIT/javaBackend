package stringmethods.filename;

public class FileNameManipulator {
    public String findLastCharacterMy(String str) {
        int i = str.length();
        // char c = (char) str.substring(i-1, i-1);
        String c = str.substring(i-1);
        return c;
    }

    public char findLastCharacter(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        }
        str = str.trim();

        return str.charAt(str.length() - 1);
    }

    public String findFileExtensionMy(String fileName) {
        int i = fileName.indexOf(".");
        String fileExtension = fileName.substring(i+1);
        return fileExtension;
    }

    public String findFileExtension(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        fileName = fileName.trim();
        int index = fileName.lastIndexOf('.');
        if (index < 1 || index == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid file name!");
        }

        return fileName.substring(index);
    }

    public boolean identifyFilesByExtensionMy(String ext, String fileName) {
        if (fileName.endsWith(ext)) {
            return true;
        }
        return false;
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (isEmpty(fileName) || isEmpty(ext)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        fileName = fileName.trim();
        ext = ext.trim();
        int index = fileName.lastIndexOf('.');
        if (index < 1 || index == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        return fileName.endsWith(ext);
    }

    public boolean compareFilesByNameMy(String searchedFileName, String actualFileName) {
        searchedFileName.equals(actualFileName);
        return true;
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (isEmpty(searchedFileName) || isEmpty(actualFileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return searchedFileName.trim().equalsIgnoreCase(actualFileName.trim());
    }

    public String changeExtensionToLowerCaseMy(String fileName) {
        int i = fileName.indexOf(".");
        String givenName = fileName.substring(0, i);
        String extensionToLoweCase = fileName.substring(i+1).toLowerCase();
        return givenName.concat("." + extensionToLoweCase);
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        fileName = fileName.trim();
        int index = fileName.lastIndexOf('.');
        if (index < 1 || index == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        String namePart = fileName.substring(0, index);
        String extension = fileName.substring(index).toLowerCase();
        return namePart + extension;
    }

    public String replaceStringPartMy(String fileName, String present, String target) {
        String repleacedFileName = null;
        if (fileName.contains(present)) {
            repleacedFileName = fileName.replace(present, target);
        }
        return repleacedFileName;
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }

        if (fileName.contains(present)) {
            return fileName.replace(present, target);
        }
        return fileName;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static void main(String[] args) {
        System.out.println(new FileNameManipulator().findLastCharacterMy("Utósó karakter"));
        System.out.println(new FileNameManipulator().findFileExtensionMy("HelloWord.java"));
        System.out.println(new FileNameManipulator().identifyFilesByExtensionMy("exe", "HelloWord.html"));
        System.out.println(new FileNameManipulator().compareFilesByNameMy("aw.mp4", "aw.mp4"));
        System.out.println(new FileNameManipulator().changeExtensionToLowerCaseMy("HelloWord.XML"));
        System.out.println(new FileNameManipulator().replaceStringPartMy
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
