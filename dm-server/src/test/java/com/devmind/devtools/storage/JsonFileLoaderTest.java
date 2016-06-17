package com.devmind.devtools.storage;

import static java.nio.file.Files.write;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.devmind.devtools.config.DevMindProperties;
import com.devmind.devtools.model.Vote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Test {@link JsonFileLoader}
 *
 * @author Dev-Mind <guillaume@dev-mind.fr>
 * @since 15/06/16.
 */
public class JsonFileLoaderTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Mock
    private DevMindProperties devMindProperties;

    private Path repoDirectory;
    private ObjectMapper objectMapper;
    private JsonFileLoader loader;


    @Before
    public void setUp() throws IOException {
        repoDirectory = Paths.get(temporaryFolder.newFolder("jsonrepository").getPath());
        objectMapper = new ObjectMapper();

        when(devMindProperties.getDataFile(Vote.class)).thenReturn(repoDirectory.resolve("votes.json").toFile());

        loader = new JsonFileLoader<>(objectMapper, devMindProperties, Vote.class);
    }

    private void addToRepository(List<Vote> votes) throws Exception {
        write(repoDirectory.resolve("votes.json"), objectMapper.writeValueAsString(votes).getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void should_load_data() throws Exception {
        List<Vote> votes = Arrays.asList(
                new Vote().setValue(Boolean.TRUE).setId("1"),
                new Vote().setValue(Boolean.FALSE).setId("2")
        );

        addToRepository(votes);
        assertThat(loader.load()).isEqualTo(votes);
    }
}