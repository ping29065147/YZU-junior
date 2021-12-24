
package com.example.myapplication;


class problem
{
    private int id;
    private String description;
    private int complexity;
    /*
     * 1 = "P"
     * 2 = "NP-complete"
     * 3 = "NP-hard"
     * 4 = "intractable"
     * 5 = "unsolvable"
     */
    private int weight;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answer;

    problem(int Id, String Description, int Complexity, String Option1, String Option2, String Option3, String Option4, int Answer)
    {
        id = weight = Id;
        description = Description;
        complexity = Complexity;
        option1 = Option1;
        option2 = Option2;
        option3 = Option3;
        option4 = Option4;
        answer = Answer;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public int getComplexity() { return complexity; }
    public int getWeight() { return weight; }
    public String getOption1() { return option1; }
    public String getOption2() { return option2; }
    public String getOption3() { return option3; }
    public String getOption4() { return option4; }
    public int getAnswer() { return answer; }

    public void setId(int Id) { id = Id; }
    public void setDescription(String Description) { description = Description; }
    public void setComplexity(int Complexity) { complexity = Complexity; }
    public void setWeight(int Weight) { weight = Weight; }
    public void setOption1(String Option1) { option1 = Option1; }
    public void setOption2(String Option2) { option2 = Option2; }
    public void setOption3(String Option3) { option3 = Option3; }
    public void setOption4(String Option4) { option4 = Option4; }
    public void setAnswer(int Answer) { answer = Answer; }
}