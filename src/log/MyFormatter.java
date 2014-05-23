package log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;


public class MyFormatter extends Formatter{
	    private final Date dat = new Date();
	@Override
	public String format(LogRecord record) {
		dat.setTime(record.getMillis());

        String message = formatMessage(record);
        return dat+" " +  message + "\n";
	}

}
