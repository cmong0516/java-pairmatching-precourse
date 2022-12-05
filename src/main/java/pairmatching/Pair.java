package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    List<Crew> pairCrew;

    public Pair(Crew c1,Crew c2) {
        this.pairCrew = new ArrayList<>();
        pairCrew.add(c1);
        pairCrew.add(c2);
    }

    public Pair(Crew c1,Crew c2,Crew c3) {
        this.pairCrew = new ArrayList<>();
        pairCrew.add(c1);
        pairCrew.add(c2);
        pairCrew.add(c3);
    }

    public List<Crew> getPairCrew() {
        return pairCrew;
    }
}
