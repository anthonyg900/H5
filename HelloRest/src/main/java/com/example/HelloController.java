package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharEncoding;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
class Controller {

    @RequestMapping(value="/greeting", method= RequestMethod.POST)
    public Greeting greetingGet() throws IOException {
        Greeting greeting = new Greeting(1, "Ayy");
        return greeting;
        /* HW 3
        ObjectMapper mapper = new ObjectMapper();
        String message = FileUtils.readFileToString(new File("./message.txt"), CharEncoding.UTF_8);
        Greeting greeting = mapper.readValue(message, Greeting.class);
        return greeting;
        */
    }

    //Asks for user to make greeting
    @RequestMapping(value="/createGreeting", method = RequestMethod.POST)
    public Greeting greetingGet(@RequestBody String name){
        Greeting newGreeting = new Greeting(2, name);
        return newGreeting;
    }

    //Post a greeting object in raw payload
    @RequestMapping(value="/postGreeting", method=RequestMethod.POST)
    public Greeting postGreeting(@RequestBody Greeting greeting){
        return greeting;
    }

    @RequestMapping(value="/updateGreeting", method=RequestMethod.PUT)
    public Greeting updateGreeting(@RequestBody String newMessage) throws IOException{
        //ObjectMapper provides functionality for reading and writing JSON
        ObjectMapper mapper = new ObjectMapper();
        String message = FileUtils.readFileToString(new File("C:\\Users\\Anthony\\IdeaProjects\\HelloRest\\src\\main\\java\\com\\example\\message.txt"), CharEncoding.UTF_8);

        //deserialize JSON to greeting object
        Greeting greeting = mapper.readValue(message, Greeting.class);

        //update message
        greeting.setContent(newMessage);

        //serliaze greeting object to JSON
        mapper.writeValue(new File("C:\\Users\\Anthony\\IdeaProjects\\HelloRest\\src\\main\\java\\com\\example\\message.txt"), greeting);
        return greeting;
    }

    @RequestMapping(value="/deleteGreeting", method=RequestMethod.DELETE)
    public void deleteGreeting(@RequestBody int id) throws IOException{
        //ObjectMapper provides functionality for reading and writing JSON
        ObjectMapper mapper = new ObjectMapper();
        String message = FileUtils.readFileToString(new File("C:\\Users\\Anthony\\IdeaProjects\\HelloRest\\src\\main\\java\\com\\example\\message.txt"), CharEncoding.UTF_8);

        //Deserialize JSON to greeting object
        Greeting greeting = mapper.readValue(message, Greeting.class);
        if (greeting.getId()==id){
            FileUtils.writeStringToFile(new File("C:\\Users\\Anthony\\IdeaProjects\\HelloRest\\src\\main\\java\\com\\example\\message.txt"), "", CharEncoding.UTF_8);
        }


    }
    /*
    @RequestMapping(value="/greeting", method= RequestMethod.POST)
    public Greeting greetingPost(@RequestBody List<Greeting> greetings) throws IOException {
        int index = 0;
        Greeting outload = new Greeting();
        for (Greeting g : greetings) {
            if (g.index > index) {
                index = g.index;
                outload = g;
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("./message.txt"), outload);
        return outload;
    }
    @RequestMapping(value="/greeting", method= RequestMethod.DELETE)
    public void greetingDelete(@RequestBody int index) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String message = FileUtils.readFileToString(new File("./message.txt"), CharEncoding.UTF_8);
        Greeting greeting = mapper.readValue(message, Greeting.class);
        if (greeting.index == index) {
            FileUtils.writeStringToFile(new File("./message.txt"), "", CharEncoding.UTF_8);
        }
    }

    @RequestMapping(value="/greeting", method= RequestMethod.PUT)
    public Greeting greetingPut(@RequestBody String newMessage) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String message = FileUtils.readFileToString(new File("./message.txt"), CharEncoding.UTF_8);
        Greeting greeting = mapper.readValue(message, Greeting.class);
        greeting.content = newMessage;
        mapper.writeValue(new File("./message.txt"), greeting);
        return greeting;
    }

    //Exercise 3
    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "1/2 * * * * * *")
            public void getGreeting(){
            String message = "http://localhost:8080/greeting";
            Greeting g = restTemplate.getForObject(message, Greeting.class);
            System.out.println(g.getContent());
            }

    @Scheduled(cron = "0/4 * * * * *")
            public void helloWorld(){
                    String message = "http://localhost:800/updateGreeting";
                    restTemplate.put(message, "Hello World");
                    }

    @Scheduled(cron = "2/4 * * * * *")
            public void byeWorld(){
                    String message = "http:localhost:8080/updateGreeting";
                    restTemplate.put(message, "Bye World");
                    }
                    */
}