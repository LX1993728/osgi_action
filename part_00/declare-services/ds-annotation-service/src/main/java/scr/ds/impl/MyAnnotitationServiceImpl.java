package scr.ds.impl;

import org.osgi.service.component.annotations.Component;
import scr.ds.api.MyAnnotitationService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component(service = MyAnnotitationService.class)
public class MyAnnotitationServiceImpl implements MyAnnotitationService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-HH-dd HH:mm:ss");

    @Override
    public String getPatternDateStr(Date date) {

        return dateFormat.format(new Date()) + "+++++++++++++++";
    }
}
