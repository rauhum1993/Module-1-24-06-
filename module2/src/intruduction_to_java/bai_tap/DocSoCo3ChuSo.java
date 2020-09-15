package intruduction_to_java.bai_tap;

import java.util.Scanner;

public class DocSoCo3ChuSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số bạn cần đọc: ");
        int number = scanner.nextInt();
        String nameNumber ="";
        if (number >= 0 && number < 10) {

            switch (number) {
                case 0: nameNumber += "zero";break;
                case 1: nameNumber += "one";break;
                case 2: nameNumber += "two";break;
                case 3: nameNumber += "three";break;
                case 4: nameNumber += "four";break;
                case 5: nameNumber += "five";break;
                case 6: nameNumber += "six";break;
                case 7: nameNumber += "seven";break;
                case 8: nameNumber += "eight";break;
                case 9: nameNumber += "nine";break;

            }
        }else if (number<20){
            switch (number-10){
                case 0: nameNumber+= "ten";break;
                case 1: nameNumber+= "eleven";break;
                case 2: nameNumber+= "twelfth";break;
                case 3: nameNumber+= "thirteen";break;
                case 4: nameNumber+= "fourteen";break;
                case 5: nameNumber+= "fifteen";break;
                case 6: nameNumber+= "sixteen";break;
                case 7: nameNumber+= "seventeen";break;
                case 8: nameNumber+= "eighteen";break;
                case 9: nameNumber+= "nineteen";break;
            }


        }else if(number<100){

                switch (number/10){
                    case 2: nameNumber+= " twenty";break;
                    case 3: nameNumber+= " thirty";break;
                    case 4: nameNumber+= " forty";break;
                    case 5: nameNumber+= " fifty";break;
                    case 6: nameNumber+= " sixty";break;
                    case 7: nameNumber+= " seventy";break;
                    case 8: nameNumber+= " eighty";break;
                    case 9: nameNumber+= " ninety";break;
                }
                switch (number%10){

                        case 1: nameNumber += " one";break;
                        case 2: nameNumber += " two";break;
                        case 3: nameNumber += " three";break;
                        case 4: nameNumber += " four";break;
                        case 5: nameNumber += " five";break;
                        case 6: nameNumber += " six";break;
                        case 7: nameNumber += " seven";break;
                        case 8: nameNumber += " eight";break;
                        case 9: nameNumber += " nine";break;
                }



        }else if (number<1000){
            switch (number/100){
                case 1: nameNumber += " oneHundred";break;
                case 2: nameNumber += " twoHundred";break;
                case 3: nameNumber += " threeHundred";break;
                case 4: nameNumber += " fourHundred";break;
                case 5: nameNumber += " fiveHundred";break;
                case 6: nameNumber += " sixHundred";break;
                case 7: nameNumber += " sevenHundred";break;
                case 8: nameNumber += " eightHundred";break;
                case 9: nameNumber += " nineHundred";break;
            }
            if((number%100!=0)){
                if (number<120){
                    switch ((number%100)%10){
                        case 1: nameNumber+= " eleven";break;
                        case 2: nameNumber+= " twelfth";break;
                        case 3: nameNumber+= " thirteen";break;
                        case 4: nameNumber+= " fourteen";break;
                        case 5: nameNumber+= " fifteen";break;
                        case 6: nameNumber+= " sixteen";break;
                        case 7: nameNumber+= " seventeen";break;
                        case 8: nameNumber+= " eighteen";break;
                        case 9: nameNumber+= " nineteen";break;
                    }

                }else {

            switch ((number%100)/10){
                case 2: nameNumber+= " _twenty";break;
                case 3: nameNumber+= " _thirty";break;
                case 4: nameNumber+= " _forty";break;
                case 5: nameNumber+= " _fifty";break;
                case 6: nameNumber+= " _sixty";break;
                case 7: nameNumber+= " _seventy";break;
                case 8: nameNumber+= " _eighty";break;
                case 9: nameNumber+= " _ninety";break;
                }
            }
                if(number>120){

            switch ((number%100)%10){
                case 0:nameNumber+="";break;
                case 1: nameNumber += " one";break;
                case 2: nameNumber += " two";break;
                case 3: nameNumber += " three";break;
                case 4: nameNumber += " four";break;
                case 5: nameNumber += " five";break;
                case 6: nameNumber += " six";break;
                case 7: nameNumber += " seven";break;
                case 8: nameNumber += " eight";break;
                case 9: nameNumber += " nine";break;

            }
            }


        }
            }

        System.out.print(""+nameNumber);



    }

}
