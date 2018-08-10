import java.util.List;

public class Row {
    int start;
    int end;
    String statusCode;
    String transferCode;

    public Row(int start, int end, String statusCode, String transferCode) {
        this.start = start;
        this.end = end;
        this.statusCode = statusCode;
        this.transferCode = transferCode;
    }

    public List<Row> modifyRow(Row input){
        return null;
    }

    private boolean hasIntersection(){
        return true;
    }
}
