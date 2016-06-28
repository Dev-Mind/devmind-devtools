package com.devmind.devtools.config;

import java.io.File;
import java.io.IOException;

import com.devmind.devtools.model.Identifiable;
import com.devmind.devtools.model.Session;
import com.devmind.devtools.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ResourceLoader;

/**
 * @author Dev-Mind <guillaume@dev-mind.fr>
 * @since 15/06/16.
 */
@ConfigurationProperties(prefix = "devmind.storage")
public class DevMindProperties {

    @Autowired
    private ResourceLoader resourceLoader;

    private String speakerFilename;
    private String sessionFilename;

    public <T extends Identifiable> File getDataFile(Class<T> type) throws IOException {
        if (type.equals(Session.class)) {
            return resourceLoader.getResource(getSessionFilename()).getFile();
        }
        else if (type.equals(Speaker.class)) {
            return resourceLoader.getResource(getSpeakerFilename()).getFile();
        }
        throw new IllegalArgumentException(String.format("Data file not known for type [%s]", type));
    }

    public String getSpeakerFilename() {
        return speakerFilename;
    }

    public DevMindProperties setSpeakerFilename(String speakerFilename) {
        this.speakerFilename = speakerFilename;
        return this;
    }

    public String getSessionFilename() {
        return sessionFilename;
    }

    public DevMindProperties setSessionFilename(String sessionFilename) {
        this.sessionFilename = sessionFilename;
        return this;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
