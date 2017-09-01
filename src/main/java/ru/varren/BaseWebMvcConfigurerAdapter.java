package ru.varren;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by varren on 01.09.17.
 */
@Configuration
public class BaseWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        ResourceResolver resolver = new AdminResourceResolver();
        registry.addResourceHandler("/admin/**")
                .resourceChain(false)
                .addResolver(resolver);


        registry.addResourceHandler("/admin/")
                .resourceChain(false)
                .addResolver(resolver);
    }


    private class AdminResourceResolver implements ResourceResolver {
        private Resource index = new ClassPathResource("/react_build/index.html");

        @Override
        public Resource resolveResource(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
            return resolve(requestPath, locations);
        }

        @Override
        public String resolveUrlPath(String resourcePath, List<? extends Resource> locations, ResourceResolverChain chain) {
            Resource resolvedResource = resolve(resourcePath, locations);
            if (resolvedResource == null) {
                return null;
            }
            try {
                return resolvedResource.getURL().toString();
            } catch (IOException e) {
                return resolvedResource.getFilename();
            }
        }

        private Resource resolve(String requestPath, List<? extends Resource> locations) {

            if(requestPath == null) return null;

            if (!requestPath.startsWith("static")) {
                return index;
            }else{
                return new ClassPathResource("/react_build/" + requestPath);
            }
        }
    }
}
