package ru.yandex.prakticum.models;

public class FAQModel {
    private final int num;
    private final String question;
    private final String answer;

    public FAQModel(int num, String question, String answer) {
        this.num = num;
        this.question = question;
        this.answer = answer;
    }

    public int getNum() {
        return num;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Вопрос номер " + num +
                " '" + question +
                "' с ответом '" + answer + '\'';
    }
}
