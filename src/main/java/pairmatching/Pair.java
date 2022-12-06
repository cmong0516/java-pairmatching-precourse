package pairmatching;

import java.util.ArrayList;
import java.util.List;
import pairmatching.constans.Level;

public class Pair {
    List<Crew> pairCrew;

    public Pair(Crew c1, Crew c2, Level level) {
        this.pairCrew = new ArrayList<>();
        pairCrew.add(c1);
        pairCrew.add(c2);

        validIsAlreadyPair(c1, c2, level);

        c1.addMatchedCrew(level,c2);
        c2.addMatchedCrew(level,c1);

    }

    public Pair(Crew c1,Crew c2,Crew c3,Level level) {
        this.pairCrew = new ArrayList<>();
        pairCrew.add(c1);
        pairCrew.add(c2);
        pairCrew.add(c3);

        validIsAlreadyPair(c1, c2, c3, level);

        c1.addMatchedCrew(level,c2);
        c1.addMatchedCrew(level,c2);
        c2.addMatchedCrew(level,c1);
        c2.addMatchedCrew(level,c3);
        c3.addMatchedCrew(level,c1);
        c3.addMatchedCrew(level,c2);

    }

    public List<Crew> getPairCrew() {
        return pairCrew;
    }

    public void validIsAlreadyPair(Crew c1, Crew c2, Level level) {
        if (c1.getMatchedCrew().get(level) != null && c1.getMatchedCrew().get(level).equals(c2)) {
            throw new RuntimeException("[ERROR] ");
        }
    }

    public void validIsAlreadyPair(Crew c1, Crew c2, Crew c3, Level level) {
        if (c1.getMatchedCrew().get(level) != null && c1.getMatchedCrew().get(level).equals(c2) || c1.getMatchedCrew().get(level).equals(c3)) {
            throw new RuntimeException("[ERROR] ");
        }
        if (c2.getMatchedCrew().get(level) != null && c2.getMatchedCrew().get(level).equals(c1) || c1.getMatchedCrew().get(level).equals(c3)) {
            throw new RuntimeException("[ERROR] ");
        }
        if (c3.getMatchedCrew().get(level) != null && c3.getMatchedCrew().get(level).equals(c1) || c1.getMatchedCrew().get(level).equals(c2)) {
            throw new RuntimeException("[ERROR] ");
        }
    }
}
