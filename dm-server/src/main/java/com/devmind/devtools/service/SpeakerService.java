package com.devmind.devtools.service;

import java.util.List;

import com.devmind.devtools.model.Speaker;
import com.devmind.devtools.storage.JsonFileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dev-Mind <guillaume@dev-mind.fr>
 * @since 15/06/16.
 */
@Service
public class SpeakerService {

    @Autowired
    private JsonFileLoader<Speaker> speakerJsonFileLoader;


    /**
     * Read all the members in our source file. For the test I prefer to not use a database
     */
    public List<Speaker> findAll() {
        return speakerJsonFileLoader.load();
    }
}
