import java.util.ArrayList;

public class BackLog {
    private ArrayList <String> log = new ArrayList<>();
    private int id;

    BackLog () { }

    BackLog (int id) {
        this.id = id;
        this.log = log;
    }

    public void setId (int id) {
        this.id = id;
    }

    public ArrayList <String> getLog(int id) {
       return log ;
    }

    public void setInLog (String info) {
        log.add(info) ;
    }

    public void printLog () {

        System.out.println("По счёту ID " + id + " были совершены следующие операции "); ;
        System.out.println("Номер" + "\t\t\t\t  Дата" + "\t\t\t\t\t\t  Тип операции\n"+
                            "операции"  + "\t\t\t операции"  );

        for(int i = 0; i < log.size(); i++){
        System.out.println("№   " + (i+1) +" "+ getLog(id).get(i));
    }

    }
}
