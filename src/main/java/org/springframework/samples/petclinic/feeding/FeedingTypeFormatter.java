package org.springframework.samples.petclinic.feeding;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class FeedingTypeFormatter implements Formatter<FeedingType>{

    @Autowired
    private FeedingService fs;

    @Override
    public String print(FeedingType object, Locale locale) {
        if(object != null) {
            return String.format(locale, "%s", object.getName());
        }
        return null;
    }

    @Override
    public FeedingType parse(String text, Locale locale) throws ParseException {
        FeedingType ft = this.fs.getFeedingType(text);

        if(ft!=null) {
            return ft;
        } else {
            throw new ParseException("Hola", 1);
        }
    }
    
}
