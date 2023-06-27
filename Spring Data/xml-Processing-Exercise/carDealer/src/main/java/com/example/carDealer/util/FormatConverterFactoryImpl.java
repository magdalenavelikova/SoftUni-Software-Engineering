package com.example.carDealer.util;

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
        return switch (formatType.toLowerCase(Locale.ROOT)) {
            case ("xml") -> this.xml;
            case ("json") -> this.json;
            default -> null;
        };

    }

}

