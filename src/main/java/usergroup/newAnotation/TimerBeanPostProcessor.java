package usergroup.newAnotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.SocketUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class TimerBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass =  bean.getClass();
        if  (beanClass.isAnnotationPresent(Timer.class) )
            map.put(beanName, beanClass);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass!= null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("Начало");
                    Long start = System.nanoTime();
                    Object retVal = method.invoke(bean, args);
                    System.out.println("Конец");
                    Long finish = System.nanoTime();
                    System.out.println(finish - start);
                    return retVal;
                }
            });
        }

        return bean;
    }
}
