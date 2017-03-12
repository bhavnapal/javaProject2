package com.bp.onlinecollaboration.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bp.onlinecollaboration.config.MvcConfig;

public class MVCWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	 @Override
     protected Class<?>[] getRootConfigClasses() {
         return new Class[] {};
     }

     @Override
     protected Class<?>[] getServletConfigClasses() {
         return new Class[] {MvcConfig.class};
     }

     @Override
     protected String[] getServletMappings() {
         return new String[] {"/"};
     }

 }
