package _00.init;
import javax.servlet.ServletContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
//*****componentScan的範圍
@ComponentScan(basePackages = { "_01", "_02", "_00", "_03", "_04", "social",
		"transportation","comment","restaurant","accommodation","attractions","member"})
public class WebAppConfig implements WebMvcConfigurer {

	@Autowired
	ServletContext context;

	@Autowired
	SessionFactory sessionFactory;

	// ***** 配置 Spring提供的 InternalResourceViewResolver 內部資源視圖解析器
	@Bean
	public ViewResolver jspViewResolver0() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class); // 可寫可不寫
		viewResolver.setPrefix("/WEB-INF/"); // *****頭尾一定要斜線
		viewResolver.setOrder(-20);
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
//	@Bean  
//    public ServerEndpointExporter serverEndpointExporter() {  
//        return new ServerEndpointExporter();  
//    }  
//	@Bean
//	public ViewResolver jspViewResolver2() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class); // 可寫可不寫
//		viewResolver.setPrefix("/WEB-INF/social/"); // *****頭尾一定要斜線
//		// ***** set order for multiple resolvers，
//		// rought solution: delta-order must be high
//		viewResolver.setOrder(20);
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}

	// *****萬一分派器找不到資源，由default servlet(專門處理靜態檔案)去處理
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		OpenSessionInViewInterceptor openSessionInViewInterceptor = new OpenSessionInViewInterceptor();
		openSessionInViewInterceptor.setSessionFactory(sessionFactory);
		registry.addWebRequestInterceptor(openSessionInViewInterceptor).addPathPatterns("/**");
	}
	
	 

	// 部署靜態資源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**").addResourceLocations("WEB-INF/social/");
		registry.addResourceHandler("/social/css/**").addResourceLocations("/WEB-INF/social/css/");
		registry.addResourceHandler("/social/fonts/**").addResourceLocations("/WEB-INF/social/fonts/");
		registry.addResourceHandler("/social/img/**").addResourceLocations("/WEB-INF/social/img/");
		registry.addResourceHandler("/social/js/**").addResourceLocations("/WEB-INF/social/js/");
		registry.addResourceHandler("/social/css/**").addResourceLocations("/WEB-INF/social/css/");
//		registry.addResourceHandler("/myImages/**").addResourceLocations("/WEB-INF/resources/images/");
	}
}
