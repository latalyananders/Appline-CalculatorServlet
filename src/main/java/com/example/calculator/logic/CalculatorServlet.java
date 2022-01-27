package com.example.calculator.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doOperation", value = "/doOperation")
public class CalculatorServlet extends HttpServlet {

    Model model = Model.getInstance();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuffer sb = new StringBuffer();
        String line;

        try {
            BufferedReader reader = request.getReader();
            while (((line = reader.readLine()) != null))
                sb.append(line);
        }
        catch (Exception e){
            System.out.println("Error");
        }

        JsonObject jsonObject = gson.fromJson(String.valueOf(sb), JsonObject.class);
        request.setCharacterEncoding("UTF-8");

       double a = jsonObject.get("a").getAsDouble();
       double b = jsonObject.get("b").getAsDouble();
       String math = jsonObject.get("math").getAsString();

       Response responseContent = new Response();

       switch (math){
           case "+":
               responseContent.setResult(String.valueOf(model.sum(a, b)));
               break;
           case "-":
               responseContent.setResult(String.valueOf(model.sub(a, b)));
               break;
           case "*":
               responseContent.setResult(String.valueOf(model.multiply(a, b)));
               break;
           case "/":
               responseContent.setResult(String.valueOf(model.divide(a, b)));
               break;
           default:
               responseContent.setResult("Неизвестная операция!");
       }

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(gson.toJson(responseContent));

    }
}
