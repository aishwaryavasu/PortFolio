import java.util.ArrayList;
import java.util.Comparator;


public class PortFolio {

    ArrayList<Row> records = new ArrayList<>();

    public PortFolio(ArrayList<Row> inputRows) {
        this.records = inputRows;
    }

    public void computeRowList(){

    }

    private Row mergeRow (Row rowa, Row rowb){
        return  new Row(rowa.start, rowb.end, rowa.statusCode, rowb.transferCode);
    }

    public void squashList(){
        //update records with the squashed list
        records.sort(Comparator.comparing(value -> value.start));
        ArrayList<Row> squashedRecords = new ArrayList<>();
        Row current = records.get(0);

        squashedRecords.add(current);
        for (int i = 1; i < records.size(); i++) {
            current = squashedRecords.get(squashedRecords.size()-1);
//            System.out.println(current.end +1 + " - " + records.get(i).start);
            if (current.end +1 == records.get(i).start &&
                    current.statusCode.equals(records.get(i).statusCode) &&
                    current.transferCode.equals(records.get(i).transferCode) ){
                squashedRecords.remove(squashedRecords.size()-1);
                squashedRecords.add(mergeRow(current, records.get(i)));

            } else {
                //squashedRecords.add(current);
                squashedRecords.add(records.get(i));
            }


        }

        records = squashedRecords;
        records.forEach(val-> System.out.println(val.start + " | " + val.end + " | " + val.statusCode + " | " + val.transferCode));
    }


    public static void main(String[] srgs){
        ArrayList<Row> records = new ArrayList<>();
        records.add(new Row(1 , 9999, "A", "1"));
        records.add(new Row(10000 , 11999, "C", "2"));
        records.add(new Row(12000 , 12343, "C", "2"));
        records.add(new Row(12344 , 12345, "C", "2"));
        records.add(new Row(12346 , 100000, "C", "2"));
        PortFolio portFolio = new PortFolio(records);
        portFolio.squashList();

    }

}
