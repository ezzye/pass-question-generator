package com.itshackney.passquestions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.AwsProxyResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class QuestionTest {

    Question question;
    InputStream inputStream;
    OutputStream outputStream = new ByteArrayOutputStream();;

    @Mock Context context;

    @Mock LambdaLogger logger;

    ObjectMapper objectMapper = new ObjectMapper();


    @Before
    public void setUp() throws Exception {
        question = new Question();
        Path path = Paths.get(getClass().getClassLoader().getResource("inputEvent.json").toURI());
        byte[] data = Files.readAllBytes(path);
        inputStream = new ByteArrayInputStream(data);
    }

    @Test
    public void questionGeneratorTest() throws IOException, URISyntaxException {

        //test
        question.handleRequest(inputStream,outputStream, context);

        String jsonActualData = outputStream.toString();

        AwsProxyResponse actual = objectMapper.readValue(jsonActualData, AwsProxyResponse.class);

        System.out.println(jsonActualData);

        Path path = Paths.get(
                getClass().getClassLoader().getResource("questions.json").toURI()
        );
        byte[] jsonExpectedData = Files.readAllBytes(path);

        AwsProxyResponse expected = objectMapper.readValue(jsonExpectedData, AwsProxyResponse.class);

        assertThat(actual.getStatusCode(),is(expected.getStatusCode()));
    }
}