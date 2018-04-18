package com.itshackney.passquestions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.AwsProxyRequest;
import model.AwsProxyResponse;
import model.QuestionModel;
import model.QuestionModelBuilder;

import java.io.*;
import java.util.Random;

public class Question implements RequestStreamHandler {

    ObjectMapper objectMapper = new ObjectMapper();
    Random rand = new Random();
//    JsonParser parser = new JsonParser();

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

//        LambdaLogger logger = context.getLogger();
//        logger.log("Loading Question Lambda handler.. ");

        String reader = getStringFromInputStream(inputStream);

        AwsProxyRequest inputEvent;

        inputEvent = getInputEvent(reader);

        String animalType = inputEvent.getQueryStringParameters().get("name");

        QuestionModel[] questions = new QuestionModel[4];
        String[] what = {"wild animal","pet animal","farm animal"};
        String[] quest = {"can","is able to","could"};
        String[] number = {"one","two","three"};
        String[] light_dark = {"light","dark"};
        String[] colour = {"red","brown","grey"};
        String[] big_small = {"big","small"};
        String[] cute_ugly = {"cute","ugly","beautiful","horrid"};
        String[] animal = {"tiger","hamster","lion","dog","cow","chicken"};
        String[] verb = {"fight with","dance with","be friends with"};

        for(int i =0; i < 4; i++) {
            QuestionModel question = new QuestionModelBuilder()
                    .setType(animalType)
                    .setWhat(randomItem(what))
                    .setQuestion(randomItem(quest))
                    .setNumber(randomItem(number))
                    .setLight_dark(randomItem(light_dark))
                    .setColour(randomItem(colour))
                    .setBig_small(randomItem(big_small))
                    .setCute_ugly(randomItem(cute_ugly))
                    .setAnimal(randomItem(animal))
                    .setVerb(randomItem(verb))
                    .createQuestionModel();
            questions[i] = question;
        }

        AwsProxyResponse awsProxyResponse = new AwsProxyResponse();

        awsProxyResponse.addHeader("testheader","test");
        awsProxyResponse.setBody(objectMapper.writeValueAsString(questions));
        awsProxyResponse.setBase64Encoded(false);
        awsProxyResponse.setStatusCode(200);

        String responseJson = objectMapper.writeValueAsString(awsProxyResponse);
//        logger.log(responseJson);
        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(outputStream,"UTF-8");
            writer.write(responseJson);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private AwsProxyRequest getInputEvent(String reader) throws IOException, JsonParseException, JsonMappingException {
        return objectMapper.readValue(reader, AwsProxyRequest.class);
    }

    private String randomItem(String[] items) {
        int length = items.length;
        return items[rand.nextInt(length)];
    }

    // convert InputStream to String
    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             if (br != null) {
                 try {
                     br.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        }
        return sb.toString();
    }
}
