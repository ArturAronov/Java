package Earthquake;

public class DistanceFilter implements Filter {
    private final Location givenLoc;
    private final float maxDist;

    public DistanceFilter(Location loc, float max) {
        givenLoc = loc;
        maxDist = max;
    }

    public boolean satisfies(QuakeEntry qe) {
        Location quakeLoc = qe.getLocation();
        float dist = givenLoc.distanceTo(quakeLoc);
        return dist < maxDist;
    }
}