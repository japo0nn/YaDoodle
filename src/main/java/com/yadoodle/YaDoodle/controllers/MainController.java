package com.yadoodle.YaDoodle.controllers;

import com.yadoodle.YaDoodle.models.Search;
import com.yadoodle.YaDoodle.repo.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private SearchRepository searchRepository;
    public String stext;

    @GetMapping("/")
    public String Home(Model model){
        model.addAttribute("title", "Я.Doodle");
        return "index";
    }

    @PostMapping("/")
    public String HomeS(@RequestParam(value = "poisk", required = false) String poisk, Model model) throws IOException {
        stext = poisk;
        return "redirect:/search";
    }


    @GetMapping("/search")
    public String Searching(Model model) throws IOException {
        model.addAttribute("title", "Поиск");
        /* FileReader reader = new FileReader("c:/Users/3S/Desktop/YaDoodle/src/main/resources/static/js/logs/logs.txt");
        Scanner scan = new Scanner(reader);
        String inputtext = scan.nextLine();
        reader.close(); */
        model.addAttribute("inputtext", stext);
        ArrayList<Search> searches = new ArrayList<>();
        Optional<Search> searchfull = searchRepository.findSearchByName(stext);
        searchfull.ifPresent(searches::add);
        searchfull = searchRepository.findSearchByDesc(stext);
        searchfull.ifPresent(searches::add);
        String[] text = stext.split(" ");
        for(int i = 0; i < text.length; i++) {
            Optional<Search> search = searchRepository.findSearchByName(text[i]);
            search.ifPresent(searches::add);
            search = searchRepository.findSearchByDesc(text[i]);
            search.ifPresent(searches::add);
        }
        model.addAttribute("searches", searches);
        return "search";
    }

    @PostMapping("/search")
    public String Search2(@RequestParam(value = "poisk", required = false) String poisk, Model model) throws IOException {
        stext = poisk;
        return "redirect:/search";
    }



}