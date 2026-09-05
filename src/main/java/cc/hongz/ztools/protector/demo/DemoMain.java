package cc.hongz.ztools.protector.demo;

import cc.hongz.ztools.aop.ProxyUtil;
import cc.hongz.ztools.aop.aspects.TimeIntervalAspect;
import cc.hongz.ztools.core.lang.Console;

/**
 * 加密混淆演示主类：引用 aop 动态代理，验证加密 class 运行时解密加载。
 *
 * @author hongz
 */
public final class DemoMain {

    /**
     * 私有构造，工具类。
     */
    private DemoMain() {
    }

    /**
     * 启动入口，创建 JDK 动态代理并调用，观察 TimeIntervalAspect 耗时日志。
     *
     * @param args 启动参数
     */
    public static void main(final String[] args) {
        final Animal cat = ProxyUtil.proxy(new Cat(), TimeIntervalAspect.class);
        final String result = cat.eat();
        Console.log("eat 返回值: {}", result);
        cat.seize();
    }

    /**
     * 被代理接口。
     */
    public interface Animal {
        /**
         * 吃。
         *
         * @return 食物名称
         */
        String eat();

        /**
         * 捕猎。
         */
        void seize();
    }

    /**
     * 有接口的实现类，走 JDK 动态代理。
     */
    public static class Cat implements Animal {
        @Override
        public String eat() {
            return "猫吃鱼";
        }

        @Override
        public void seize() {
            Console.log("抓了条鱼");
        }
    }
}
