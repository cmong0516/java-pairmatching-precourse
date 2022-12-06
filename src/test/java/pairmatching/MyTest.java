package pairmatching;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import pairmatching.constans.Course;
import pairmatching.constans.Function;
import pairmatching.constans.Level;
import pairmatching.constans.Mission;

public class MyTest {

    @Test
    public void test() {
        MatchingController controller = new MatchingController();
        Crew c1 = new Crew("아아", Course.BACKEND);
        Crew c2 = new Crew("라떼", Course.BACKEND);
        Crew c3 = new Crew("뜨아", Course.BACKEND);
        Pair pair = new Pair(c1, c2, Level.LEVEL1);

        List<Crew> pairCrew = pair.getPairCrew();

        Map<Level, Crew> matchedCrew = pairCrew.get(0).getMatchedCrew();

        Crew crew = matchedCrew.get(Level.LEVEL1);

        System.out.println("crew.getName() = " + crew.getName());
    }

}
