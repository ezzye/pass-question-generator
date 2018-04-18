package model;

import java.util.Objects;

public class QuestionModel {
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

    public QuestionModel() {
    }

    public QuestionModel(
            String type,
            String what,
            String question,
            String number,
            String light_dark,
            String colour,
            String big_small,
            String cute_ugly,
            String animal,
            String verb
    ) {
        this.type = type;
        this.what = what;
        this.question = question;
        this.number = number;
        this.light_dark = light_dark;
        this.colour = colour;
        this.big_small = big_small;
        this.cute_ugly = cute_ugly;
        this.animal = animal;
        this.verb = verb;
    }

    public String getType() {
        return type;
    }

    public String getWhat() {
        return what;
    }

    public String getQuestion() {
        return question;
    }

    public String getNumber() {
        return number;
    }

    public String getLight_dark() {
        return light_dark;
    }

    public String getColour() {
        return colour;
    }

    public String getBig_small() {
        return big_small;
    }

    public String getCute_ugly() {
        return cute_ugly;
    }

    public String getAnimal() {
        return animal;
    }

    public String getVerb() {
        return verb;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionModel)) return false;
        QuestionModel that = (QuestionModel) o;
        return Objects.equals(getType(), that.getType()) &&
                Objects.equals(getWhat(), that.getWhat()) &&
                Objects.equals(getQuestion(), that.getQuestion()) &&
                Objects.equals(getNumber(), that.getNumber()) &&
                Objects.equals(getLight_dark(), that.getLight_dark()) &&
                Objects.equals(getColour(), that.getColour()) &&
                Objects.equals(getBig_small(), that.getBig_small()) &&
                Objects.equals(getCute_ugly(), that.getCute_ugly()) &&
                Objects.equals(getAnimal(), that.getAnimal()) &&
                Objects.equals(getVerb(), that.getVerb());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getType(), getWhat(), getQuestion(), getNumber(), getLight_dark(), getColour(), getBig_small(), getCute_ugly(), getAnimal(), getVerb());
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "type='" + type + '\'' +
                ", what='" + what + '\'' +
                ", question='" + question + '\'' +
                ", number='" + number + '\'' +
                ", light_dark='" + light_dark + '\'' +
                ", colour='" + colour + '\'' +
                ", big_small='" + big_small + '\'' +
                ", cute_ugly='" + cute_ugly + '\'' +
                ", animal='" + animal + '\'' +
                ", verb='" + verb + '\'' +
                '}';
    }
}
