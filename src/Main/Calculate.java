package Main;

import Visualize.MyPanel;

import java.util.Scanner;

public class Calculate {
    //	100以内加减法练习小软件（用户目标：小学1年级学生）
    public static void main(String args[]){
        MyPanel myPanel = new MyPanel();
    }

    public static int calculate(int firstNum,int secondNum,String operator){
        int ans = 0;
        switch(operator){
            case "+":
                ans = firstNum + secondNum;
                break;
            case "-":
                ans = firstNum - secondNum;
                break;
            case "*":
                ans = firstNum * secondNum;
                break;
            case "/":
                ans = firstNum / secondNum;
                break;
            default:
                System.out.println("运算符错误");
        }
        return ans;
    }
}
