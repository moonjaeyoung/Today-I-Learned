package data_structure.hashtable;

/**
 * @Author : Hyunwoong
 * @When : 2018-09-18 오후 12:54
 * @Homepage : https://github.com/gusdnd852
 */
public class Test {
    public static void main(String[] args) {
        HTable table = new HTableImpl(5);

        table.put("ddd", "ddddd");

        System.out.println(table.get("ddd"));
        System.out.println(table.get("eee"));

    }
}
