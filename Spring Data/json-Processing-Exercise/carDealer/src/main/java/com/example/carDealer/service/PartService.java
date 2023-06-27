package com.example.carDealer.service;

import com.example.carDealer.excetption.UnableToConvertException;
import com.example.carDealer.model.entity.Part;
import com.example.carDealer.util.FormatConverter;

import java.io.IOException;
import java.util.Set;

public interface PartService {

    Set<Part> randomSetOfParts();

    void seedPartsFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException;

    void seedPartsFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException;
}
