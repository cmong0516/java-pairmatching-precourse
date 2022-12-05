package pairmatching;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import pairmatching.constans.Course;
import pairmatching.constans.Function;
import pairmatching.constans.Level;
import pairmatching.constans.Mission;

public class MyTest {

    @Test
    public void test() {
        MatchingController controller = new MatchingController();
        List<Crew> crews = controller.makeCrewList(Course.BACKEND);
        List<Pair> pairs = controller.makePair(crews);

        Map<MatchingInfo, List<Pair>> matching = controller.matching("프론트엔드,레벨1,로또");

        MatchingInfo matchingInfo = controller.makeMatchingInfo("프론트엔드,레벨1,로또");

        List<Pair> pairs1 = matching.get(matchingInfo);

        for (Pair pair : pairs1) {
            System.out.println(pair.getPairCrew());
        }

    }

}
