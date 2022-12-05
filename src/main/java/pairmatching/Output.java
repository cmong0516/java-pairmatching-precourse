package pairmatching;

import java.util.List;
import pairmatching.constans.OutputMessage;

public class Output {

    public void printFunction() {
        System.out.println(OutputMessage.SELECT_A_FEATURE.getMessage());
    }

    public void printCourseLevelMission() {
        System.out.println(OutputMessage.COURSE_LEVEL_MISSION.getMessage());
    }

    public void printOverRapMatching() {
        System.out.println(OutputMessage.ALREADY_MATCHING.getMessage());
    }

    public void printClear() {
        System.out.println(OutputMessage.MATCHING_CLEAR.getMessage());
    }

    public void printPairResult(List<Pair> pairs) {
        for (Pair pair : pairs) {
            StringBuilder sb = new StringBuilder();
            List<Crew> pairCrew = pair.getPairCrew();
            for (int i = 0; i < pairCrew.size(); i++) {
                sb.append(pairCrew.get(i).getName());
                if (i != pairCrew.size() - 1) {
                    sb.append(" : ");
                }

            }
            System.out.println(sb);
        }
    }
}
