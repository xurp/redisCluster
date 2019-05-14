package com.raven.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class JedisClusterConfig {
    //这里的nodes直接吃到yml里面的127.0.0.1:6379/127.0.0.1:6380
    
    private List<String> nodes=new ArrayList<String>();
	

	
    /**
     * 注意：
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
     * 似乎这个jedisCluster就直接在springboot里的@Cacheable开始用了
     * @return
     */
	@Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> nodeSet = new HashSet<>();
        for(String node :nodes) {
            String[] split = node.split(":");
            nodeSet.add(new HostAndPort(split[0],Integer.valueOf(split[1])));
        }
        return new JedisCluster(nodeSet);
    }
 
}