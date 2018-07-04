package one.packet.trainning;

public class DraftClass {
    private int number;
    private String str;
    final static public int MAX_SIZE = 1;  //final <=> const
    static int smthUsefulll;        //static - одна переменная на все объекты, хранится в одной и той же ячейке помяяти
                                    //часто статик переменные - констранты final

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    public void function(){
        System.out.println("Go fuck yourself!");
    }

}
