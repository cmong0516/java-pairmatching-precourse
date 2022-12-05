package pairmatching.constans;

public enum FileRoot {
    BACKEND_FILE_ROOT("/Users/mong/Desktop/precourse/java-pairmatching-precourse/src/main/resources/backend-crew.md"),
    FRONTEND_FILE_ROOT("/Users/mong/Desktop/precourse/java-pairmatching-precourse/src/main/resources/frontend-crew.md");

    private final String fileRoot;

    FileRoot(String fileRoot) {
        this.fileRoot = fileRoot;
    }

    public String getFileRoot() {
        return fileRoot;
    }
}
