package proxy;

import proxy.annotations.ClearData;
import proxy.annotations.Logged;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class ProxyMathBox implements InvocationHandler {

    private Mathematics mathematics;
    private static final Logger logger = Logger.getLogger(ProxyMathBox.class.getName());

    public ProxyMathBox(Mathematics mathematics) {
        this.mathematics = mathematics;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.isAnnotationPresent(Logged.class)) {
            logger.info("Аннотация Logger работает у вызванного метода "+ method.getName());
        }

        if(method.isAnnotationPresent(ClearData.class)) {
            Field field = mathematics.getClass().getDeclaredField("list");
            field.setAccessible(true);
            field.set(mathematics, null);
            System.out.println("У вызванного через прокси метода " + method.getName() + " работает аннотация ClearData");
            System.out.println("Лист очищен");
        }
        return method.invoke(mathematics, args);
    }
}
