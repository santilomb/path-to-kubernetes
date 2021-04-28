package com.example.helloWorld;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@SpringBootApplication
public class HelloWorldApplication {

  @CrossOrigin(origins = "*")
  @RestController
  class ImageOverlayController {

      @RequestMapping(path = "/", method = RequestMethod.GET)
      public String Get() {
          String html = "<html><body><h1>API</h1><p>Los metodos habilitado son:<br>- suma<br>- resta</p><p>La forma de invocar es:<br>- /API/{metodo}/{numero_1}/{numero_2}</body></html>";
          return html;
      }
    
      @RequestMapping(value = "/API/suma/{num1}/{num2}", method = RequestMethod.GET)
      @ResponseBody
      public String getSumaDeDosNumeros
        (@PathVariable long num1, @PathVariable long num2) {
          long resultado = num1 + num2;
          String html = "<html><body><h1>Metodo: SUMA</h1><p>Numero 1: " + num1 + "<br>Numero 2: " + num2 + "</p><p>Resultado: " + resultado + "</p></body></html>";
          return html;
      }
   
      @RequestMapping(value = "/API/resta/{num1}/{num2}", method = RequestMethod.GET)
      @ResponseBody
      public String getRestaDeDosNumeros
        (@PathVariable long num1, @PathVariable long num2) {
          long resultado = num1 - num2;
          String html = "<html><body><h1>Metodo: RESTA</h1><p>Numero 1: " + num1 + "<br>Numero 2: " + num2 + "</p><p>Resultado: " + resultado + "</p></body></html>";
          return html;
      }
    }
  
  public static void main(String[] args) throws IOException {
    SpringApplication.run(HelloWorldApplication.class, args);
  }
}
