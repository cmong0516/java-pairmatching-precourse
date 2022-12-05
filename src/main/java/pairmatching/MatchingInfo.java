package pairmatching;

import java.util.Objects;
import pairmatching.constans.Course;
import pairmatching.constans.Mission;

public class MatchingInfo {
    private Course course;
    private Mission mission;

    public MatchingInfo(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
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
        return getCourse() == that.getCourse() && getMission() == that.getMission();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getMission());
    }
}
