package com.fuyunwang.surveillance.gateway.config;



import com.fuyunwang.surveillance.gateway.handler.SurveillanceGatewayExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.addOriginalRequestUrl;

/**
 * @Description: gateway添加统一前缀
 * @Author: FuyunWang
 * @Date: 2020/12/31 19:12
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
@ConditionalOnClass(WebFluxConfigurer.class)
@AutoConfigureBefore(WebFluxAutoConfiguration.class)
@EnableConfigurationProperties({ServerProperties.class, ResourceProperties.class})
public class SurveillanceGatewayConfig {

//    private static final String prefix = "/surveillance";
    private static final String prefix = "";
    private final ServerProperties serverProperties;
    private final ApplicationContext applicationContext;
    private final ResourceProperties resourceProperties;
    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;

    public SurveillanceGatewayConfig(ServerProperties serverProperties,
                                     ResourceProperties resourceProperties,
                                     ObjectProvider<List<ViewResolver>> viewResolversProvider,
                                     ServerCodecConfigurer serverCodecConfigurer,
                                     ApplicationContext applicationContext) {
        this.serverProperties = serverProperties;
        this.applicationContext = applicationContext;
        this.resourceProperties = resourceProperties;
        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SurveillanceGatewayExceptionHandler errorWebExceptionHandler(ErrorAttributes errorAttributes) {
        SurveillanceGatewayExceptionHandler exceptionHandler = new SurveillanceGatewayExceptionHandler(
                errorAttributes,
                this.resourceProperties,
                this.serverProperties.getError(),
                this.applicationContext);
        exceptionHandler.setViewResolvers(this.viewResolvers);
        exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
        exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
        return exceptionHandler;
    }
    @Bean
    @ConditionalOnMissingBean(value = ErrorAttributes.class, search = SearchStrategy.CURRENT)
    public DefaultErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes(this.serverProperties.getError().isIncludeException());
    }
    @Bean
    @Order(-1)
    public WebFilter apiPrefixFilter(){
        return (serverWebExchange, webFilterChain) -> {
            ServerHttpRequest request=serverWebExchange.getRequest();
            addOriginalRequestUrl(serverWebExchange,request.getURI());
            String path=request.getURI().getRawPath();
            if(!path.contains(prefix)){
                ServerHttpResponse response=serverWebExchange.getResponse();
                response.setStatusCode(HttpStatus.BAD_GATEWAY);
                DataBuffer buffer = response.bufferFactory().wrap(HttpStatus.BAD_GATEWAY.getReasonPhrase().getBytes());
                return response.writeWith(Mono.just(buffer));
            }
            String newPath=path.replaceFirst(prefix,"");
            ServerHttpRequest newRequest=request.mutate().path(newPath).build();
            serverWebExchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR,newRequest.getURI());
            return webFilterChain.filter(serverWebExchange.mutate().request(newRequest).build());
        };
    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration cfg = new CorsConfiguration();
        cfg.setAllowCredentials(true);
        cfg.addAllowedOrigin("*");
        cfg.addAllowedMethod("*");
        cfg.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return new CorsWebFilter(source);
    }

}
