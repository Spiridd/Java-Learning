package org.stepic.java.basic;

/**
 * Created by dimon on 03.08.17.
 */
public class Play {
    public static void main(String[] args) {
        Main main = new Main();
        String roles[] = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
        String textLines[] = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.\n",
                "Аммос Федорович: Как ревизор?\n",
                "Артемий Филиппович: Как ревизор?\n",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\n",
                "Аммос Федорович: Вот те на!\n",
                "Артемий Филиппович: Вот не было заботы, так подай!\n",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!\n"
        };
        System.out.println(main.printTextPerRole(roles, textLines));
    }
}
