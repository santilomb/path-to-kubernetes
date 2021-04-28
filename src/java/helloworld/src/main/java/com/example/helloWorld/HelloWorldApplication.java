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
          String html = "<html><body><h1>Hello World en HTML</h1><p>Un parrafo html para agregar un tag P.</p></body></html>";
          return html;
      }
    
      @RequestMapping(value = "/API/metodo/{metodoid}/dato/{datoid}", method = RequestMethod.GET)
      @ResponseBody
      public String getFoosBySimplePathWithPathVariables
        (@PathVariable long metodoid, @PathVariable long datoid) {
          return "Se llamo al metodo: " + metodoid + 
            " con el dato: " + metodoid;
      }
    
    }
  
  public static void main(String[] args) throws IOException {
    SpringApplication.run(HelloWorldApplication.class, args);
  }
}
