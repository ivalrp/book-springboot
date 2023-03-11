package com.subrutin.catalog.config;

import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.sql.DataSource;
import java.lang.reflect.Method;

@Component
public class DataSourceProxyBeanProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSource){
            ProxyFactory factory = new ProxyFactory(bean);
            factory.setProxyTargetClass(true);
            factory.addAdvice(new ProxyDataSourceInterceptor((DataSource)bean));
            return factory.getProxy();
        }
        return bean;
    }

    private static class ProxyDataSourceInterceptor implements MethodInterceptor{
        private final DataSource dataSource;

        private ProxyDataSourceInterceptor(DataSource dataSource) {
            super();
            this.dataSource = ProxyDataSourceBuilder.create(dataSource).countQuery().logQueryBySlf4j(SLF4JLogLevel.INFO).build();
        }

        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            Method proxyMethod = ReflectionUtils.findMethod(dataSource.getClass(), methodInvocation.getMethod().getName());
            if (proxyMethod != null){
                return proxyMethod.invoke(dataSource, methodInvocation.getArguments());
            }
            return methodInvocation.proceed();
        }
    }
}
