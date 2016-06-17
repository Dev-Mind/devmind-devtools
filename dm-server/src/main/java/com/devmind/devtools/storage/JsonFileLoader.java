package com.devmind.devtools.storage;

import java.io.IOException;
import java.util.List;

import com.devmind.devtools.config.DevMindProperties;
import com.devmind.devtools.model.Identifiable;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This loader helps to find data stored in a Json File. For this test I did'nt want to use
 * a database
 */
public class JsonFileLoader<T extends Identifiable> {

    /**
     * Object mapper use to serialize/deserialize data
     */
    private ObjectMapper objectMapper;
    /**
     * A loader is specific to a type
     */
    private Class<T> type;
    /**
     * Object with all the project parameters
     */
    private DevMindProperties devMindProperties;


    public JsonFileLoader(ObjectMapper objectMapper,
                          DevMindProperties devMindProperties,
                          Class<T> type) {
        this.objectMapper = objectMapper;
        this.devMindProperties = devMindProperties;
        this.type = type;
    }

    /**
     * Load and deserialize
     */
    public List<T> load() {
        try {
            return objectMapper.readValue(
                    devMindProperties.getDataFile(type),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, type)
            );
        }
        catch (IOException e) {
            throw new LoadDataException(e);
        }
    }
}
