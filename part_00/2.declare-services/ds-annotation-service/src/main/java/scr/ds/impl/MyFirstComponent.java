package scr.ds.impl;




import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import java.util.Date;

@Component
public class MyFirstComponent {

    private volatile boolean doRun;

    /**
     * 此注解用于组件激活时的触发操作，一般做一些初始化操作，不能有返回值
     */
    @Activate
    protected void active() {
        System.out.println("++++ MyFIrstCmponent created active+++++");
        final Thread t = new Thread() {
            public void run() {
                doIt();
            }
        };
        t.setDaemon(true);
        doRun = true;
        t.start();
    }

    /**
     * 此注解用于组件销毁时的触发操作，一般用于收尾操作，不能有返回值
     */
    @Deactivate
    protected void deactive() {
        System.out.println("++++ MyFirstComponent destoryed deactive");
        doRun = false;
    }


    private void doIt() {
        while (doRun) {
            System.out.println("I'm still alive! " + new Date());
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
