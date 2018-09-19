package data_structure.hashtable;

import java.util.LinkedList;

/**
 * @Author : Hyunwoong
 * @When : 2018-09-18 오후 12:28
 * @Homepage : https://github.com/gusdnd852
 */
public class HTableImpl implements HTable {

    private LinkedList<Node>[] data;

    /**
     * 데이터의 규격으로 사용할 Node 클래스
     * Key , Value 의 쌍으로 이루어짐.
     */
    private class Node {
        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        void setValue(String value) {
            this.value = value;
        }
    }

    HTableImpl(int size) {
        this.data = new LinkedList[size];
    }

    /**
     * 키를 받아와서 해시코드를 리턴해주는 메소드 getHashCode(String key) : int
     * <p>
     * 내부구현 설명 :
     * 문자열로 된 키를 받아와서 모든 글자를 한개의 문자로 쪼갬.
     * 그리고 모든 캐릭터의 아스키코드 값을 더함으로써
     * 모든 문자열마다 각각 고유한 키를 가지게 함.
     *
     * @param key : 해시코드로 변환할 키
     * @return : 변환된 해시코드를 반환함.
     */
    private int getHashCode(String key) {
        int hashcode = 0;

        for (char c : key.toCharArray()) hashcode += c;

        return hashcode;
    }

    /**
     * 해시코드를 받아와서 LinkedList 의 사이즈만큼 나눠서 반환하는 메소드 convertToIndex(int hashcode) : int
     * <p>
     * 내부구현 설명:
     *
     * ㅁ
     * @param hashcode : 인덱스로 변환할 해시코드
     * @return : 변환된 인덱를 반환함.
     */
    private int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    /**
     * 리스트와 키를 받아와서 노드를 반환해주는 메소드 searchKey(LinkedList list, String key) : Node
     *
     * @param list : 검색할 리스트
     * @param key  : 검색할 키
     * @return : 검색한 노드를 반환함.
     */
    private Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) return null;

        for (Node node : list) if (node.key.equals(key)) return node;

        return null;
    }


    // 여기부터 사용자가 사용할 메소드

    /**
     * 사용자가 해시테이블에 데이터를 넣는 메소드 put(String Key , String value) : void
     * 사용자의 데이터는 키, 값의 쌍으로 이루어져야하며, 이를 파라미터로 사용.
     *
     * @param key   : 키로 사용할 문자열
     * @param value : 위 키에 매칭되는 값
     */

    public void put(String key, String value) {
        int index = convertToIndex(getHashCode(key));
        LinkedList<Node> list = data[index];

        if (list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }

        Node node = searchKey(list, key);

        if (node == null) list.addLast(new Node(key, value));
        else node.setValue(value);
    }

    /**
     * 사용자가 키를 입력하면 매칭되는 값(Value)를 반환하는 메소드 get(String key) : String
     *
     * @param key : 검색할 키
     * @return : 해당 키에 매칭되는 값(Value)을 리턴해줌.
     */
    public String get(String key) {
        int index = convertToIndex(getHashCode(key));
        LinkedList<Node> list = data[index];

        Node node = searchKey(list, key);

        return node == null ? "NOT FOUND" : node.value;
    }
}
