package com.niit.onlinecollaboration.initializer;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.onlinecollaboration.config.HibernateConfig;
import com.niit.onlinecollaboration.config.MvcConfig;
import com.niit.onlinecollaboration.config.RootConfig;
import com.niit.onlinecollaboration.filter.CORSfilter;

public class MVCWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
    protected Class[] getRootConfigClasses() {
        return new Class[] {RootConfig.class,HibernateConfig.class};
    }

    @Override
    protected Class[] getServletConfigClasses() {
        return new Class[] {MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters(){
    	
    	return new Filter[] {new CORSfilter()};
    }
	
	
}
