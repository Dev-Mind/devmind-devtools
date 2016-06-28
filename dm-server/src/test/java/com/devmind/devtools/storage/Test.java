package com.devmind.devtools.storage;

import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Dev-Mind <guillaume@dev-mind.fr>
 * @since 16/06/16.
 */
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    private ResourceLoader resourceLoader;

    @org.junit.Test
    public void test(){
        Assertions.assertThat(resourceLoader).isNotNull();
        Resource resource = resourceLoader.getResource("classpath:sessions.json");
        Assertions.assertThat(resource.exists()).isTrue();
    }
}
