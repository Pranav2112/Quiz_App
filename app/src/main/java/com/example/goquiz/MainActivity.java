package com.example.goquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   public static ArrayList<Modelclass> list;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();
        list.add(new Modelclass("Who invented Java Programming?","Guido van Rossum"," James Gosling","Dennis Ritchie","Bjarne Stroustrup","James Gosling"));
        list.add(new Modelclass("Which component is used to compile, debug and execute the java programs?","JRE","JIT","JDK","JVM","JDK"));
        list.add(new Modelclass("Which one of the following is not a Java feature?","Object-oriented","Use of pointers","portable","Dynamic and Extensible","Use of pointers"));
        list.add(new Modelclass("Which of these cannot be used for a variable name in Java?","identifier & keyword","identifier","keyword","none of the mentioned","keyword"));
        list.add(new Modelclass("Which environment variable is used to set the java path?","MAVEN_PATH","JavaPATH","JAVA","JAVA_HOME","JAVA_HOME"));
        list.add(new Modelclass("Which of the following is not an OOPS concept in Java?","Polymorphism ","Inheritance","Compilation","Encapsulation","Compilation"));
        list.add(new Modelclass("What is not the use of “this” keyword in Java?"," Referring to the instance variable when a local variable has the same name","Passing itself to the method of the same class"," Passing itself to another method"," Calling another constructor in constructor chaining"," Passing itself to the method of the same class"));
        list.add(new Modelclass("Which of the following is a type of polymorphism in Java Programming?"," Multiple polymorphism","Compile time polymorphism","Multilevel polymorphism","Execution time polymorphism","Compile time polymorphism"));
        list.add(new Modelclass("What is Truncation in Java?","Floating-point value assigned to a Floating type"," Floating-point value assigned to an integer type","Integer value assigned to floating type","Integer value assigned to floating type"," Floating-point value assigned to an integer type"));
        list.add(new Modelclass("Which exception is thrown when java is out of memory?","MemoryError","OutOfMemoryError","MemoryOutOfBoundsException","MemoryFullException","OutOfMemoryError"));
        list.add(new Modelclass("Which of these are selection statements in Java?","break","continue"," for()","if()","if()"));
        list.add(new Modelclass("Which of the below is not a Java Profiler?"," JProfiler"," Eclipse Profiler","JVM","JConsole","JVM"));
        list.add(new Modelclass("Which one of the following is not an access modifier?","Protected","Void","Public","Private","Void"));



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this,DashBoard.class);
                startActivity(intent);
                finish();

            }
        },2000);
    }
}