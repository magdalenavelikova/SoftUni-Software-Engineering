package com.example.json.service;

import com.example.json.model.entity.Part;

import java.io.IOException;
import java.util.Set;

public interface PartService {
    void seedParts() throws IOException;
    Set<Part> randomSetOfParts();
}
