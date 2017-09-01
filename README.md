Here you can find simple demo project for Spring hosting thymeleaf templates and react app under /admin/

For simple react app i used create-react-app and react router to test routes

The goal was to make site urls look like this

    /admin/static/** => react static folder only for existing files in /resources/react_build/static
    
    /admin/**        => react /resources/react_build/index.html for everything but /admin/static/**
    
    /**              =>  Theamleaf templates for everything else 
    In this demo it is IndexController and template will come from /resources/templates/index.thml

Project structure looks like this

    frontend
        build
        ... react code
        
    src
        main
            java
                ... java code
            resources
                react_build => symlink to /frontend/build
                templates
                    index.html

`react_build` is actually a symlink to /frontend/build created with

    cd src/main/resources/
    ln -s ../../../frontend/build/ react_build

The main part is in `BaseWebMvcConfigurerAdapter` inner class `AdminResourceResolver`.

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
         ... //custom ResourceResolver code
    }

I'm using this approach to forward  directory and every subdirectory to a single react/angular/any other js lib file


One thing to mention is that i'm using  gradle `com.moowork.node` plugin 
to build js before java app starts, so if you want to disable it,
just comment the last line in build.gradle `processResources.dependsOn 'webpack'`



    > gradle bootStart
    
will host app on localhost:8080 