package pairmatching;

import pairmatching.constans.Course;
import pairmatching.constans.Function;
import pairmatching.constans.Level;
import pairmatching.constans.Mission;
import pairmatching.constans.OverRapMatching;

public class Validator {

    public static void validFunctionInput(String functionInput) {
        if (Function.findFuncion(functionInput) == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void validCourseLevelMission(String courseLevelMission) {
        String[] split = courseLevelMission.split(",");
        String course = split[0].trim();
        String level = split[1].trim();
        String mission = split[2].trim();

        if (Course.findCourse(course) == null) {
            throw new IllegalArgumentException();
        }

        if (Mission.findByName(mission) == null) {
            throw new IllegalArgumentException();
        }

        if (Level.findByName(level) == null) {
            throw new IllegalArgumentException();
        }

    }

    public static void validOverRapMatchingInput(String input) {
        if (OverRapMatching.findByValue(input) == null) {
            throw new IllegalArgumentException();
        }
    }

}
