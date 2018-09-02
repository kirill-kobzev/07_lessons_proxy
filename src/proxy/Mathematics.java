package proxy;

import proxy.annotations.ClearData;
import proxy.annotations.Logged;

import java.util.ArrayList;
import java.util.List;

public interface Mathematics {

    List list = new ArrayList();

    @Logged
    @ClearData
    public int summator();


    public List<Integer> splitter(int del);


    public void delElement(int el);
}
