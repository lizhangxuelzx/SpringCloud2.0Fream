package com.lizx.springcloud.ribbonRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 简易自定义轮询算法，每台服务器调用5次
 *
 * Created by lzx on 2018-12-19.
 */
public class PollRule extends AbstractLoadBalancerRule {

    private int total = 0; //指定每次被调用次数
    private int currentIndex = 0; //当前服务器号：8001，8002
    /**
     * Randomly choose from all living servers
     */
    //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
            //自己注释掉的源码
            // int index = chooseRandomInt(serverCount);
            // server = upList.get(index);

            //改造源码
            if(total < 5){
                server = upList.get(currentIndex);//获得当前服务器
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size())//超出已有服务器数量时，重新开始
                    currentIndex = 0;
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    /*protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }*/

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
