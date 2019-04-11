package com.vocabulary;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * @author Huang Da Ren
 */
@Configuration
@ComponentScan(basePackages = "com.vocabulary", excludeFilters = {
		@ComponentScan.Filter(Controller.class)
})
@Import(ServletConfig.class)
public class AppConfig {


}
