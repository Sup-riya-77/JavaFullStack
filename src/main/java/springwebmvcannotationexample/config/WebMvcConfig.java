package springwebmvcannotationexample.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
@Configuration
@EnableWebMvc
@ComponentScan("springwebmvcannotationexample")
public class WebMvcConfig implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		//
		vr.setViewClass(JstlView.class);
		// set location of views.
		vr.setPrefix("/");
 
		// set the extension of views.
		vr.setSuffix(".jsp");
 
		return vr;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry){
		registry.jsp("/",".jsp").cache(true);
	}
	
}
 