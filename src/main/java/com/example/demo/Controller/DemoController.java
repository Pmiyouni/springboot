package com.example.demo.Controller;

import com.example.demo.Service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
//final 붙은 것만 처리, rombok에서 제공함

public class DemoController {
    //생성자 주입
//    private DemoService demoService;
//
//    //Demoservice 객체를 매개변수로 하는 생성자
//    @Autowired
//    public  DemoController(DemoService demoService){
//        this.demoService=demoService;
//    }

    //생성자 주입 좀더 편하게 정의
    private  final  DemoService demoService;
    //final--> 도중에 바꿀수 없도록



}
