package pairmatching.constans;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드",FileRoot.BACKEND_FILE_ROOT),
    FRONTEND("프론트엔드",FileRoot.FRONTEND_FILE_ROOT);

    private final String name;
    private final FileRoot fileRoot;

    Course(String name, FileRoot fileRoot) {
        this.name = name;
        this.fileRoot = fileRoot;
    }

    public String getName() {
        return name;
    }

    public FileRoot getFileRoot() {
        return fileRoot;
    }

    public static Course findCourse(String name) {

        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }
}
