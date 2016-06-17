package com.devmind.devtools.service;

import java.util.List;

import com.devmind.devtools.config.DevMindProperties;
import com.devmind.devtools.model.Session;
import com.devmind.devtools.storage.JsonFileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dev-Mind <guillaume@dev-mind.fr>
 * @since 15/06/16.
 */
@Service
public class SessionService {

    @Autowired
    private JsonFileLoader<Session> sessionJsonFileLoader;

    @Autowired
    private DevMindProperties devMindProperties;

    /**
     * Read all the sessions in our source file. For the test I prefer to not use a database
     */
    public List<Session> findAll() {
        return sessionJsonFileLoader.load();
    }
}
