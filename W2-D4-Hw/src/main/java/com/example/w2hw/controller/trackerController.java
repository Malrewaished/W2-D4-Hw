package com.example.w2hw.controller;

import com.example.w2hw.model.Api;
import com.example.w2hw.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class trackerController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/task")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/task")
    public Api addTasks(@RequestBody Task task) {
        tasks.add(task);
        return new Api("Task added !");
    }

    @PutMapping("/task/{index}")
    public Api updateTasks(@RequestBody Task task, @PathVariable int index) {
        tasks.set(index, task);
        return new Api("Task updated !");
    }

    @DeleteMapping("/task/{index}")
    public Api removeTask(@PathVariable int index) {
        tasks.remove(index);
        return new Api("Task removed !");
    }


    @PutMapping("/task/status/{id}")
    public Api changeStatus(@PathVariable int id){
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId() == id){
                if(tasks.get(i).getStatus().equals("Not done")){
                    tasks.get(i).setStatus("Done");
                } else {
                    tasks.get(i).setStatus("Not done");
                }
            }
            return new Api("The status changed! ");
        }
        return new Api("The id is invalid!");
    }

    @GetMapping("/task/search")
    public Api byGivenTitle(@RequestParam String title){
        for (int i = 0; i <tasks.size() ; i++) {
            if(tasks.get(i).getTitle().equals(title)){
                return new Api("The task is: " + tasks.get(i));
            }
            }
        return new Api("The title is invalid");
    }
}
