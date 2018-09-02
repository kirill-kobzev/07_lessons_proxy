package proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GenerateArray generateArray = new GenerateArray();
        int[] arr = generateArray.GenerateArray(10);
        List<Integer> list = new ArrayList<Integer>();
        for(int ar: arr){
            list.add(ar);
        }

        Mathematics mathemetics = new MathBox(list);
        ProxyMathBox proxyMathBox = new ProxyMathBox(mathemetics);
        Mathematics mathematics = (Mathematics) Proxy.newProxyInstance(Mathematics.class.getClassLoader(),
                new Class[]{Mathematics.class}, proxyMathBox);

        mathematics.summator();

    }
}
