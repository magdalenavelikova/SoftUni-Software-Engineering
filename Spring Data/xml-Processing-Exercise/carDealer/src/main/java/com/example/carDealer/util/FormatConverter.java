package com.example.carDealer.util;


import com.example.carDealer.excetption.UnableToConvertException;

import java.util.List;

public interface FormatConverter {
    void setPrettyPrint();

    String serialize(Object obj) throws UnableToConvertException;
    void serialize(Object obj,String filename) throws UnableToConvertException;
    <T> void serializeList(List<T> objectLists, String filename) ;
    <T> T deserialize(String input, Class<T> toType) throws UnableToConvertException;
    <T> T deserializeFromFile(String fileName, Class<T> toType) throws UnableToConvertException;


}
