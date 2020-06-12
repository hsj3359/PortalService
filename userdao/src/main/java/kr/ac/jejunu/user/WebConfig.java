package kr.ac.jejunu.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import java.util.List;


@Configuration
@EnableWebMvc
@ComponentScan("kr.ac.jejunu.user")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        configurer.mediaType("js", MediaType.APPLICATION_JSON).mediaType("x", MediaType.APPLICATION_XML);
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> conveters){
        conveters.add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.enableContentNegotiation(new MappingJackson2XmlView());
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new UserInertceptor()).addPathPatterns("/**/*");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/static/");

    }
}
