package proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MathBox implements Mathematics {


    private List<Integer> list = new ArrayList<Integer>();

    public MathBox(List list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return this.list;
    }

    public int summator(){

        int sum = 0;
        try {
            for (int i = 0; i < this.list.size(); i++) {
                sum = sum + (int) this.list.get(i);
            }
        }catch (NullPointerException ex){
            System.out.println("Вы попыталсись передать пустой лист");
        }

        return sum;
    }

    public List<Integer> splitter(int del){

        List<Integer> listSplit = new ArrayList<Integer>();
        try {
            for(int i = 0; i<this.list.size(); i++) {
                listSplit.add((int)this.list.get(i) / del);
            }
        }catch (NullPointerException ex){
            System.out.println("Вы попыталсись передать пустой лист");
        }

        return listSplit;

    }

    public void delElement(int el){
        try {
            for(int i = 0; i<this.list.size(); i++) {
                if((int)this.list.get(i) == el){
                    this.list.remove(i);
                    i = i - 1;
                }
            }
        }catch (NullPointerException ex){
            System.out.println("Вы попыталсись передать пустой лист");
        }
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(list, mathBox.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
