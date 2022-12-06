package pairmatching;

import java.util.HashMap;
import java.util.Map;
import pairmatching.constans.Course;
import pairmatching.constans.Level;

public class Crew {
    private String name;
    private Course course;
    private Map<Level,Crew> matchedCrew;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
        this.matchedCrew = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addMatchedCrew(Level level,Crew crew) {
        getMatchedCrew().put(level, crew);
    }

    public Map<Level, Crew> getMatchedCrew() {
        return matchedCrew;
    }
}
