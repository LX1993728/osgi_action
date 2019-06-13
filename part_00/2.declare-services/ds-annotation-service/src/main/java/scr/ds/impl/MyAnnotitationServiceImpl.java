package scr.ds.impl;

import org.osgi.service.component.annotations.Component;
import scr.ds.api.MyAnnotitationService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component(service = MyAnnotitationService.class,property = {"version=1.0"})
public class MyAnnotitationServiceImpl implements MyAnnotitationService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-HH-dd HH:mm:ss");

    public String getPatternDateStr(Date date) {
//        System.out.println("This is a service bundle that be updated");
        return dateFormat.format(new Date()) + "+++++++++++++++";
    }
}
