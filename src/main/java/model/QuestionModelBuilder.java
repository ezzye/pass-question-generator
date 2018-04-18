package model;

public class QuestionModelBuilder {
    private String type;
    private String what;
    private String question;
    private String number;
    private String light_dark;
    private String colour;
    private String big_small;
    private String cute_ugly;
    private String animal;
    private String verb;

    public QuestionModelBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public QuestionModelBuilder setWhat(String what) {
        this.what = what;
        return this;
    }

    public QuestionModelBuilder setQuestion(String question) {
        this.question = question;
        return this;
    }

    public QuestionModelBuilder setNumber(String number) {
        this.number = number;
        return this;
    }

    public QuestionModelBuilder setLight_dark(String light_dark) {
        this.light_dark = light_dark;
        return this;
    }

    public QuestionModelBuilder setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public QuestionModelBuilder setBig_small(String big_small) {
        this.big_small = big_small;
        return this;
    }

    public QuestionModelBuilder setCute_ugly(String cute_ugly) {
        this.cute_ugly = cute_ugly;
        return this;
    }

    public QuestionModelBuilder setAnimal(String animal) {
        this.animal = animal;
        return this;
    }

    public QuestionModelBuilder setVerb(String verb) {
        this.verb = verb;
        return this;
    }

    public QuestionModel createQuestionModel() {
        return new QuestionModel(type, what, question, number, light_dark, colour, big_small, cute_ugly, animal, verb);
    }
}