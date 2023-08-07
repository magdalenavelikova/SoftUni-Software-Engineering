package bg.softuni.modelmapper.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component()
public class FormatConverterFactoryImpl implements FormatConverterFactory {
    private final FormatConverter xml;
    private final FormatConverter json;

    public FormatConverterFactoryImpl(
            @Qualifier("xml_format_converter") FormatConverter xml,
            @Qualifier("json_format_converter") FormatConverter json) {
        this.xml = xml;
        this.json = json;
    }

    @Override
    public FormatConverter create(String formatType) {
        switch (formatType.toLowerCase(Locale.ROOT)) {
            case ("xml"):
                return this.xml;

            case ("json"):
                return this.json;

            default:
                return null;
        }

    }

}

