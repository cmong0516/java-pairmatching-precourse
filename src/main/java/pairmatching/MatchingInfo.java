package pairmatching;

import java.util.Objects;
import pairmatching.constans.Course;
import pairmatching.constans.Level;
import pairmatching.constans.Mission;

public class MatchingInfo {
    private Course course;
    private Mission mission;
    private Level level;

    public MatchingInfo(Course course, Mission mission, Level level) {
        this.course = course;
        this.mission = mission;
        this.level = level;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchingInfo that = (MatchingInfo) o;
        return getCourse() == that.getCourse() && getMission() == that.getMission() && level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getMission(), level);
    }
}
