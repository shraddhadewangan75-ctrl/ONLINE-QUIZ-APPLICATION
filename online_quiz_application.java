import java.util.Scanner;

// Question Class
class Question {
    String questionText;
    String[] options;
    String correctAnswer;

    // Constructor
    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

// QuizManager Class
class QuizManager {
    Question[] questions;
    int score = 0;

    public QuizManager(Question[] questions) {
        this.questions = questions;
    }

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQ" + (i + 1) + ": " + questions[i].getQuestion());

            String[] options = questions[i].getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            System.out.print("Enter answer: ");
            String userAnswer = sc.nextLine();

            if (userAnswer.equalsIgnoreCase(questions[i].getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is: " + questions[i].getCorrectAnswer());
            }
        }

        showResult();
        sc.close();
    }

    public void showResult() {
        System.out.println("\nFinal Score: " + score + "/" + questions.length);
    }
}

// Main Class
public class online_quiz_application {
    public static void main(String[] args) {

        // Questions setup
        Question q1 = new Question(
                "What is Java?",
                new String[] { "a) Language", "b) OS", "c) Browser", "d) Hardware" },
                "a");

        Question q2 = new Question(
                "Which keyword is used to create object?",
                new String[] { "a) new", "b) class", "c) void", "d) static" },
                "a");

        Question q3 = new Question(
                "Which method is entry point of Java program?",
                new String[] { "a) start()", "b) main()", "c) run()", "d) init()" },
                "b");

        // Array of questions
        Question[] questions = { q1, q2, q3 };

        // Start Quiz
        QuizManager quiz = new QuizManager(questions);
        quiz.startQuiz();
    }
}
