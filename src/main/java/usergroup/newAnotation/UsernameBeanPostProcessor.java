package usergroup.newAnotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;


import java.lang.reflect.Field;

@Component
public class UsernameBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for ( Field field: fields ) {
               Username username = field.getAnnotation(Username.class);
            if(username!=null) {
                String name = username.name();
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, name);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
    }
