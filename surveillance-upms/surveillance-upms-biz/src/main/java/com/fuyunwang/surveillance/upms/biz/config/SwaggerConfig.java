package com.fuyunwang.surveillance.upms.biz.config;

import com.fuyunwang.surveillance.upms.biz.prop.ChuoyueSystemSwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Date: 2020/10/4 16:32
 * @Author: FuyunWang
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Autowired
    private ChuoyueSystemSwaggerProperties chuoyueSystemSwaggerProperties;

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fuyunwang.surveillance.upms.biz.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(securityScheme(chuoyueSystemSwaggerProperties)))
                .securityContexts(Collections.singletonList(securityContext(chuoyueSystemSwaggerProperties)));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "surveillance-upms-biz api",
                "Chuoyue即绰约——凌波绰约无尘俗 不羡群芳自展颜",
                "2.0.0",
                null,
                new Contact("FuyunWang", "https://github.com/fuyunwang/video_surveillance2021", "2375872953@qq.com"),
                "MIT License", "https://github.com/fuyunwang/video_surveillance2021/blob/main/LICENSE", Collections.emptyList());
    }

    private SecurityScheme securityScheme(ChuoyueSystemSwaggerProperties swagger) {
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant("http://localhost:10086/surveillance/auth/oauth/token");

        return new OAuthBuilder()
                .name("chuoyue_oauth_swagger")
                .grantTypes(Collections.singletonList(grantType))
                .scopes(Arrays.asList(scopes(swagger)))
                .build();
    }

    private SecurityContext securityContext(ChuoyueSystemSwaggerProperties swagger) {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("chuoyue_oauth_swagger", scopes(swagger))))
                .forPaths(PathSelectors.any())
                .build();
    }

    private AuthorizationScope[] scopes(ChuoyueSystemSwaggerProperties swagger) {
        return new AuthorizationScope[]{
                new AuthorizationScope("test", "")
        };
    }
}
