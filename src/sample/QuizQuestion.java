package sample;

/**
 * Class created to check answer and compare to user choice to award score
 * Used in Level1
 * @author Seyone Chithrananda
 *
 */

public class QuizQuestion {

    /**
     * answer to question
     */
    private String answer;

    /**
     *
     * @param a answer for question (i.e: A, B or C)
     */
    public QuizQuestion(String a)
    /* each question and option is on the background image.
       Only the answer to each answer (i.e: A, B or C) is needed to compare with
       the button's title and determine the score.
    */
    {
        answer= a;
    }

    /**
     *
     * @return answer to question
     */
    public String getAnswer ()
    {
        return answer;
    }
}
