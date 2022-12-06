package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.constans.Course;
import pairmatching.constans.Function;
import pairmatching.constans.Level;
import pairmatching.constans.Mission;
import pairmatching.constans.OverRapMatching;

public class MatchingController {
    private final Input input;
    private final Output output;
    private final List<String> backend;
    private final List<String> frontend;
    private final Map<MatchingInfo, List<Pair>> matchingMap;
    private int tryCount;


    public MatchingController() {
        FileScanner fileScanner = new FileScanner();
        this.input = new Input();
        this.output = new Output();
        this.backend = fileScanner.getBackEndCrews();
        this.frontend = fileScanner.getFrontEndCrews();
        this.matchingMap = new HashMap<>();
        this.tryCount = 0;
    }

    public void run() {

        while (true) {
            String functionInput = functionInput();

            if (functionInput.equals(Function.PAIR_MATCHING.getFunction())) {
                String courseLevelMissionInput = courseLevelMissionInput();

                boolean alreadyCheck = isAlreadyCheck(courseLevelMissionInput);
                boolean reMatching = isReMatching(alreadyCheck);

                if (alreadyCheck && !reMatching) {
                    continue;
                }

                matching(courseLevelMissionInput);
            }

            if (functionInput.equals(Function.FAIR_INQUIRY.getFunction())) {
                String inquiryCourseLevelMissionInput = courseLevelMissionInput();
                List<Pair> pairs = getMatchingMap().get(makeMatchingInfo(inquiryCourseLevelMissionInput));
                try {
                    output.printPairResult(pairs);

                } catch (NullPointerException e) {
                    System.out.println("[ERROR] 조회하신 매칭 정보가 존재하지 않습니다.");
                }

            }

            if (functionInput.equals(Function.PAIR_CLEAR.getFunction())) {
                matchingMap.clear();
                output.printClear();
            }

            if (functionInput.equals(Function.THE_END.getFunction())) {
                break;
            }
        }


    }

    public void matching(String courseLevelMissionInput) {
        String[] split = courseLevelMissionInput.split(",");
        MatchingInfo matchingInfo = makeMatchingInfo(courseLevelMissionInput);
        List<Crew> crews = makeCrewList(Course.findCourse(split[0].trim()));
        List<Pair> pairs = makePair(crews, Level.findByName(split[1].trim()));
        output.printPairResult(pairs);

        getMatchingMap().put(matchingInfo, pairs);

    }


    public MatchingInfo makeMatchingInfo(String courseLevelMissionInput) {
        String[] split = courseLevelMissionInput.split(",");
        return new MatchingInfo(Course.findCourse(split[0].trim()),
                Mission.findByName(split[2].trim()), Level.findByName(split[1].trim()));
    }

    public List<Pair> makePair(List<Crew> crews, Level level) {
        List<Pair> result = new ArrayList<>();
        int crewsSize = crews.size();
        if (crews.size() % 2 == 1) {
            crewsSize -= 3;
        }

        while (true) {
            try {
                for (int i = 0; i < crewsSize; i += 2) {
                    result.add(new Pair(crews.get(i), crews.get(i + 1), level));
                }

                if (crews.size() % 2 == 1) {
                    result.add(
                            new Pair(crews.get(crewsSize - 1), crews.get(crewsSize - 2), crews.get(crewsSize - 3), level));
                }
                break;
            } catch (IllegalStateException e) {
                System.out.println("[ERROR] ");
                tryCount++;
                crews = Randoms.shuffle(crews);
                if (tryCount == 3) {
                    throw new RuntimeException("매칭에 3회 실패하였습니다.");
                }

            }
        }


        return result;
    }

    public boolean isReMatching(boolean alreadyCheck) {
        if (alreadyCheck) {
            String overRapMatchingInput = overRapMatchingInput();
            return overRapMatchingInput.equals(OverRapMatching.YES.getValue());
        }
        return false;
    }


    public String functionInput() {

        String functionInput = "";
        while (true) {
            try {
                output.printFunction();
                functionInput = this.input.input();
                System.out.println();
                Validator.validFunctionInput(functionInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] ");
            }

        }
        return functionInput;
    }

    public String courseLevelMissionInput() {

        String courseLevelMission = "";
        while (true) {
            try {
                output.printCourseLevelMission();
                courseLevelMission = this.input.input();
                System.out.println();
                Validator.validCourseLevelMission(courseLevelMission);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] ");
            }

        }
        return courseLevelMission;
    }

    public String overRapMatchingInput() {

        String overRapMatchingInput = "";
        while (true) {
            try {
                output.printOverRapMatching();
                overRapMatchingInput = this.input.input();
                System.out.println();
                Validator.validOverRapMatchingInput(overRapMatchingInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] ");
            }

        }
        return overRapMatchingInput;
    }

    public List<Crew> makeCrewList(Course course) {
        List<Crew> crews = new ArrayList<>();

        if (course.equals(Course.BACKEND)) {
            for (String crew : backend) {
                crews.add(new Crew(crew, course));
            }
        }

        if (course.equals(Course.FRONTEND)) {
            for (String crew : frontend) {
                crews.add(new Crew(crew, course));
            }
        }

        return crews;
    }

    public boolean isAlreadyCheck(String courseLevelMission) {
        String[] split = courseLevelMission.split(",");
        MatchingInfo matchingInfo = new MatchingInfo(Course.findCourse(split[0].trim()),
                Mission.findByName(split[2].trim()), Level.findByName(split[1].trim()));
        return matchingMap.containsKey(matchingInfo);
    }

    public List<MatchingInfo> findMatchingInfoByLevel(String level) {
        List<MatchingInfo> matchingInfos = new ArrayList<>();
        for (MatchingInfo matchingMapKey : matchingMap.keySet()) {
            if (matchingMapKey.getLevel().equals(Level.findByName(level))) {
                matchingInfos.add(matchingMapKey);
            }
        }
        return matchingInfos;
    }

    public List<List<Pair>> findMatchings(List<MatchingInfo> findMatchingInfoByLevel) {
        List<List<Pair>> matchings = new ArrayList<>();
        for (MatchingInfo matchingInfo : findMatchingInfoByLevel) {
            matchings.add(matchingMap.get(matchingInfo));
        }

        return matchings;
    }

    public Map<MatchingInfo, List<Pair>> getMatchingMap() {
        return matchingMap;
    }
}
