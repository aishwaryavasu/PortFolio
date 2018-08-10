public class Range {
    int start;
    int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public boolean hasIntersection(Range otherRange){
        Range larger = otherRange;
        Range smaller = this;
        if(otherRange.start>this.start){
            smaller = otherRange;
            larger = this;
        }
        if(smaller.start>=larger.start && smaller.start<=larger.end || smaller.end>=larger.start && smaller.end<=larger.end)
            return true;
        return false;
    }
}
