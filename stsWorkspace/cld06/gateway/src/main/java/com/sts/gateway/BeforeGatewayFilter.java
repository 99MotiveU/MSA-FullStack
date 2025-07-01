package com.sts.gateway;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.PrefixPathGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.PrefixPathGatewayFilterFactory.Config;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class BeforeGatewayFilter 
    extends AbstractGatewayFilterFactory<PrefixPathGatewayFilterFactory.Config>{
    
    public BeforeGatewayFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain)->{
            List list=exchange.getRequest().getHeaders().get("Authorization");
            String token = (String)list.get(0);
            
            if(token==null)throw new UnsupportedOperationException("Unimplemented method 'apply'");
            return chain.filter(exchange);
        };

    }

    
    
}
