package com.example.myapplication;

import java.util.*;

class problem_database
{
    private static List<problem> myList = new ArrayList<problem>(); // store all questions

    problem_database()
    {
        // new problem(id, description, complexity, option1, option2, option3, option4, answer)
        myList.add(new problem(1, "Sorting problem 的複雜度為何 ?", 1, "P", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(2, "0/1 Knapsack problem 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(3, "Traveling salesman problem 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(4, "Unbounded Knapsack Problem 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(5, "Bounded Knapsack Problem 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(6, "Tower of Hanoi problem 的複雜度為何 ?", 4, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 3));
        myList.add(new problem(7, "Money Changing problem 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(8, "Halting problem 的複雜度為何 ?", 5, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 4));
        myList.add(new problem(9, "P / NP problem 的複雜度為何 ?", 5, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 4));
        myList.add(new problem(10, "Partition problem 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));

        myList.add(new problem(11, "0-1 Integer programming 的複雜度為何 ?", 3, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 2));
        myList.add(new problem(12, "Mixed integer programming 的複雜度為何 ?", 3, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 2));
        myList.add(new problem(13, "Barber paradox 的複雜度為何 ?", 5, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 4));
        myList.add(new problem(14, "Omnipotence paradox 的複雜度為何 ?", 5, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 4));
        myList.add(new problem(15, "Brute-force algorithm 的複雜度為何 ?", 4, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 3));
        myList.add(new problem(16, "Boolean satisfiability problem 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(17, "Clique problem 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(18, "Covering problem 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(19, "Directed Hamiltonian cycle 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));
        myList.add(new problem(20, "Undirected Hamiltonian cycle 的複雜度為何 ?", 2, "NP-complete", "NP-hard", "intractable-problem", "unsolvable", 1));

        myList.add(new problem(21, "在 polynomial time 內可以解決的問題種類是哪個 ?", 3, "Bounded Knapsack Problem", "Omnipotence paradox", "Unbounded Knapsack Problem", "Sorting problem", 4));
        myList.add(new problem(22, "在 polynomial time 內可以解決的問題是哪個 ?", 3, "Bounded Knapsack Problem", "Omnipotence paradox", "Unbounded Knapsack Problem", "Sorting problem", 4));
        myList.add(new problem(23, "Sorting problem 演算法的時間複雜度大多落在 ?", 5, "O(n^2) ~ O(n log n)", "O(n^3) ~ O(n2)","O(n) ~ O(1)", "O(n^3) ~ O(1)", 1));
        myList.add(new problem(24, "哪一種背包問題給定物品的數量是無限的 ?", 5, "0/1 Knapsack problem", "Bounded Knapsack Problem", "Unbounded Knapsack Problem", "None Knapsack problem", 3));
        myList.add(new problem(25, "如果河內塔的盤子數量為4個，請問總共需要幾步才能把所有盤子移動到另一個杆上 ?", 4, "7 次", "15 次", "31 次", "63 次", 2));
        myList.add(new problem(26, "如果河內塔的盤子數量為6個，請問總共需要幾步才能把所有盤子移動到另一個杆上 ?", 2, "7 次", "15 次", "31 次", "63 次", 4));
        myList.add(new problem(27, "在0/1背包問題中，假設背包的負重是15kg，有五件物品他們的重量跟價值分別是{5 , 3}、{4 , 7}、{10 , 10}、{1 , 3}、{6 , 4}，請問價值最大是多少 ?", 2, "13", "14", "20", "10", 3));
        myList.add(new problem(28, "在無限背包問題中，假設背包的負重是15kg，有五件物品他們的重量跟價值分別是{5 , 3}、{4 , 7}、{10 , 10}、{1 , 3}、{6 , 4}，請問價值最大是多少 ?", 2, "50", "45", "9", "30", 2));
        myList.add(new problem(29, "在有限背包問題中，假設背包的負重是15kg，有五件物品他們的重量、價值跟物品數量分別是{5 , 3 , 2}、{4 , 7, 1}、{10 , 10 , 3}、{1 , 3 , 4}、{6 , 4 , 3}，請問價值最大是多少 ?", 2, "23", "25", "11", "21", 1));
        myList.add(new problem(30, "請問關於 Directed Hamiltonian cycle 的選項何者為真 ?", 2, "給定一個無向、有權重的圖", "給定一個無向、無權重的圖", "給定一個有向、無權重的圖", "給定一個有向、有權重的圖", 3));

        myList.add(new problem(31, "請問關於 Undirected Hamiltonian cycle 的選項何者為真 ?", 3, "給定一個無向、有權重的圖", "給定一個無向、無權重的圖", "給定一個有向、無權重的圖", "給定一個有向、有權重的圖", 2));
        myList.add(new problem(32, "請問我們總共介紹了幾種問題 ?", 3, "18", "20", "22", "24", 2));
        myList.add(new problem(33, "Clique problem ，分團問題是問一個圖中是否有大小是[?]於k的團。請問[]中的是以下何者 ?", 5, ">=", "<=", "=", ">", 4));
        myList.add(new problem(34, "關於 Brute-force algorithm 的敘述錯誤的是以下何者 ?", 5, "是一種非常低效的解決問題的技術", "稱為暴力搜尋或窮舉搜尋", "檢查特定選項是否符合問題描述", "系統地列舉解決方案的所有可能候選項", 3));
        myList.add(new problem(35, "Boolean satisfiability problem、Directed Hamiltonian cycle、Brute-force algorithm，請問以下關於他們分類的敘述何者為真 ?", 4, "Boolean satisfiability problem、Directed Hamiltonian cycle是NP Complete", "Boolean satisfiability problem、Directed Hamiltonian cycle是NP Hard", "Directed Hamiltonian cycle是NP Hard", "Brute-force algorithm是 intractable-problem", 4));
        myList.add(new problem(36, "下列哪個是千禧年七大難題 ?", 2, "Directed Hamiltonian cycle", "Brute-force algorithm", "P / NP problem", "Clique problem", 3));
        myList.add(new problem(37, "「給定一個幣值的集合，給定一個目標金錢的數值，求使用集合內幣值來湊出目標金錢共有幾種方法？以及零錢的最少數目為何 ?」以上敘述是哪個問題 ?", 2, "Money Changing problem", "Covering problem", "Brute-force algorithm", "Omnipotence paradox", 1));
        myList.add(new problem(38, "Partition problem，給定一個集合，將集合內的元素分成兩個子集合，兩個子集合中的元素相加要[?]。請問[]中的是 ?", 2, ">=", "<=", "=", ">", 3));
        myList.add(new problem(39, "小城裡的理髮師放出豪言 : 他要為城裡人刮鬍子，而且一定只要為城裡所有「不為自己刮鬍子的人」刮鬍子。「但問題是 : 理髮師該為自己刮鬍子嗎？如果他為自己刮鬍子，那麼按照他的豪言「只為城裡所有不為自己刮鬍子的人刮鬍子」他不應該為自己刮鬍子；但如果他不為自己刮鬍子，同樣按照他的豪言「一定要為城裡所有不為自己刮鬍子的人刮鬍子」他又應該為自己刮鬍子。」以上敘述是哪個問題 ?", 2, "Money Changing problem", "Covering problem", "Brute-force algorithm", "Barber paradox", 4));
        myList.add(new problem(40, "關於 Omnipotence paradox 的敘述錯誤的是以下何者 ?", 2, "如果任一個體是「全能」的話，那麼他就一定能夠制訂出一個他不能履行的工作，如此他就不會是全能的", "若一個「全能」的個體不能夠制訂出一個他不能履行的工作，如此他也不會是全能的", "無論他能否制訂這項工作，他都不會是全能的", "如果任一個體不是「全能」的話，那麼他就不能夠制訂出一個他能履行的工作，如此他就不會是全能的", 4));

        myList.add(new problem(41, "「是否存在一個程式P，對於任意輸入的程式w，能夠判斷w會在有限時間內結束或者無窮迴圈。」以上敘述是哪個問題 ?", 3, "Undirected Hamiltonian cycle", "Halting problem", "Clique problem", "Barber paradox", 2));
        myList.add(new problem(42, "「0-1規劃是決策變數僅取值0或1的一類特殊的整數規劃。在處理經濟管理中某些規劃問題時，若決策變數採用 0-1變數即邏輯變數，可把本來需要分別各種情況加以討論的問題統一在一個問題中討論。」以上敘述是哪個問題 ?", 3, "0/1 Knapsack problem", "Halting problem", "0-1 Integer programming", "Barber paradox", 3));
        myList.add(new problem(43, "關於 Covering problem 的敘述錯誤的是以下何者 ?", 5, "圖一定會覆蓋至少一個頂點（或邊）", "圖的覆蓋是一些頂點（或邊）的集合", "圖中的每一條邊（每一個頂點）都至少接觸集合中的一個頂點（邊）", "尋找最小的頂點覆蓋的問題稱為頂點覆蓋問題", 1));
        myList.add(new problem(44, "關於 Boolean satisfiability problem 的敘述錯誤的是以下何者 ?", 5, "不可滿足性是用來解決給定的真值方程式，是否存在一組變數賦值，使問題為可滿足。", "可滿足性是用來解決給定的真值方程式，沒有存在一組變數賦值，使問題為可滿足。", "可滿足性是用來解決給定的真值方程式，有存在一組變數賦值，使問題為可滿足。", "可滿足性是用來解決給定的真值方程式，是否存在一組變數賦值，使問題為可滿足。", 4));
        myList.add(new problem(45, "Mixed integer programming，只要求當中某幾個未知數為[?]的線性規劃問題叫做混合整數規劃。請問[]中的是以下何者 ?", 4, "虛數", "實數", "整數", "正整數", 3));
        myList.add(new problem(46, "Traveling salesman problem 能用以下什麼方法解 ?", 2, "brute force method", "branch-and-bound method", "Dynamic Programming", "以上皆是", 4));
        myList.add(new problem(47, "第一個被證明屬於 NP-complete 的問題是哪一個 ?", 2, "Covering problem", "Partition problem", "Money Changing problem", "Boolean satisfiability problem", 4));
        myList.add(new problem(48, "如果河內塔的盤子數量為64個，假設每秒可以移動一個盤子，請問總共需要多少時間才能把所有盤子移動到另一個杆上 ?", 2, "約 3760 億年", "約 4380 億年", "約 5850 億年", "約 6565 億年", 3));
        myList.add(new problem(49, "給定50個問題，每個問題有不同的權重，求在限制權重下如何選出適當的10題題目，這是屬於哪個問題的範圍 ?", 2, "Money Changing problem", "0/1 Knapsack problem", "Traveling salesman problem", "Clique problem", 2));
        myList.add(new problem(50, "關於 NP-hard 與 NP-complete 的敘述錯誤的是以下何者 ?", 2, "NP-complete 是 NP 與 NP-hard 的交集", "NP-hard 不一定屬於 NP", "所有的 NP 問題都可以用 DTM 在 polynomial time 內化約成為這個 NP-hard 問題", "NP-complete 沒有存在任何有效率的演算法的問題", 4));
    }

    public void shuffle() { Collections.shuffle(myList); };
    public int getSize() { return myList.size(); }
    
    public int getId(int k) { return myList.get(k).getId(); }
    public String getDescription(int k) { return myList.get(k).getDescription(); }
    public int getWeight(int k) { return myList.get(k).getWeight(); }
    public String getOption1(int k) { return myList.get(k).getOption1(); }
    public String getOption2(int k) { return myList.get(k).getOption2(); }
    public String getOption3(int k) { return myList.get(k).getOption3(); }
    public String getOption4(int k) { return myList.get(k).getOption4(); }
    public int getAnswer(int k) { return myList.get(k).getAnswer(); }
}