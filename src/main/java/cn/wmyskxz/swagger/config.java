package cn.wmyskxz.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

      // 这是控制开关
@EnableSwagger2     // 这是用了 swagger2
@EnableWebMvc   // 这是因为工程用的 springmvc
@Configuration
public class config {
    /**
     * Every Docket bean is picked up by the swagger-mvc framework - allowing for multiple swagger groups i.e. same code base multiple swagger resource listings.
     */
    @Bean
    public Docket customDocket() {
        String basePackage = "cn.wmyskxz.controller";
        return new Docket(DocumentationType.SWAGGER_2)
                .select()            //select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
                .apis(RequestHandlerSelectors.basePackage(basePackage)) //扫描指定包内所有Controller定义的Api，并产生文档内容（除了被@ApiIgnore指定的请求）。
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()); //用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("她的睫毛，弯的嘴角，用眼神对我拍照").build();
    }

}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
