package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharEncoding;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController{

    //addVehicle() will take a vehicle object and write it to a local text file
    //It will always APPEND to the file
    //So if I make 5 POST requests to /addVehicle, the local file will contain 5 vehicles in JSON
    @AtChurch
    @Timed
    @RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
    public Vehicle addVehicle(@RequestBody Vehicle newVehicle) throws IOException {

        //ObjectMapper provides functionality for reading and writing JSON
        ObjectMapper mapper = new ObjectMapper();

        //Create a FileWrite to write to inventory.txt and APPEND mode is true
        FileWriter output = new FileWriter("C:\\Users\\Anthony\\IdeaProjects\\ProjectSC\\src\\main\\java\\com\\example\\inventory.txt", true);

        //Serialize greeting object to JSON and write it to file
        mapper.writeValue(output, newVehicle);

        //Append a new line character to the file
        //The above FileWriter ("output") is automatically closed by the mapper
        FileUtils.writeStringToFile(new File("C:\\Users\\Anthony\\IdeaProjects\\ProjectSC\\src\\main\\java\\com\\example\\inventory.txt"),
                System.lineSeparator(),  //newline String
                CharEncoding.UTF_8,     //encoding type
                true);
        return newVehicle;
    }

    //getVehicle() will take a given id, and find the vehicle that has the matching id.
    //It will iterate the local file line-by-line, check if the id matches, and if there is a match
    //return the vehicle object.
    @AtChurch
    @Timed
    @RequestMapping(value = "/getVehicle/{id}", method = RequestMethod.GET)
    public Vehicle getVehicle(@PathVariable("id") int id) throws IOException {
        List<String> inventory = FileUtils.readLines(new File("C:\\Users\\Anthony\\IdeaProjects\\ProjectSC\\src\\main\\java\\com\\example\\inventory.txt"), CharEncoding.UTF_8);
        for (String currentLine : inventory) {
            ObjectMapper mapper = new ObjectMapper();
            Vehicle v = mapper.readValue(currentLine, Vehicle.class);
            if (id == v.getId()) {
                return v;
            } else {
                return null;
            }
        }
        return null;
    }

    //updateVehicle() will do the following given a vehicle object passed in:
    //Iterate the local file line-by-line
    //Check if the current line’s vehicle’s id matches the vehicle id that is passed in
    //If there is a match, update the current line with the vehicle that was passed in
    @AtChurch
    @Timed
    @RequestMapping(value = "/updateVehicle", method = RequestMethod.PUT)
    public Vehicle updateVehicle(@RequestBody Vehicle newVehicle) throws IOException {
        List<String> inventory = FileUtils.readLines(new File("C:\\Users\\Anthony\\IdeaProjects\\ProjectSC\\src\\main\\java\\com\\example\\inventory.txt"), CharEncoding.UTF_8);
        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Anthony\\IdeaProjects\\ProjectSC\\src\\main\\java\\com\\example\\inventory.txt",false));
        out.close();

        for (String currentLine : inventory){
            ObjectMapper mapper = new ObjectMapper();
            Vehicle v = mapper.readValue(currentLine, Vehicle.class);

            if (newVehicle.getId() == v.getId()) {
                System.out.println("Put:");
                //deleteVehicle(v.getId());
                //delete/id
                System.out.println("- DELETED vehicle with v: " + v.getId());
                addVehicle(newVehicle);
                System.out.println("-> PUT Updated vehicle:   " + newVehicle + "\n");
            } else {
                addVehicle(v);
            }
        }
        //System.out.println("End of the list. Restarting put...");
        return null;
    }

    //deleteVehicle() simply takes the given id and deletes from the local file.
    //It will iterate the local file line-by-line to check if the given id exists, then perform a
    //delete.
    @AtChurch
    @Timed
    @RequestMapping(value = "/deleteVehicle/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") int id) throws IOException {
        File File = new File("C:\\Users\\Anthony\\IdeaProjects\\ProjectSC\\src\\main\\java\\com\\example\\inventory.txt");
        File newFile = new File("C:\\Users\\Anthony\\IdeaProjects\\ProjectSC\\src\\main\\java\\com\\example\\inventory2.txt");

        ObjectMapper mapper = new ObjectMapper();
        List<String> inventory = FileUtils.readLines(File, CharEncoding.UTF_8);
        Vehicle vehicle;
        FileWriter output;
        Boolean found = false;

        for(int i = 0; i < inventory.size(); i++) {
            // Deserialize JSON to greeting object
            vehicle = mapper.readValue(inventory.get(i), Vehicle.class);

            // Create a FileWrite to write to inventory.txt and APPEND mode is true
            output = new FileWriter(newFile.getPath(), true);

            // Serialize greeting object to JSON and write it to file
            if(id != vehicle.getId()) {
                mapper.writeValue(output, vehicle);
                found = true;
            }

            // Append a new line character to the file
            // The above FileWriter ("output") is automatically closed by the mapper.
            FileUtils.writeStringToFile(newFile,
                    System.lineSeparator(),
                    CharEncoding.UTF_8,
                    true);
        }

        //Copy from source to copy, the delete source.
        org.apache.commons.io.FileUtils.copyFile(newFile, File);
        org.apache.commons.io.FileUtils.deleteQuietly(newFile);

        if(found) {
            return ResponseEntity.ok("Vehicle deleted!");
        }
        return null;
    }
}
