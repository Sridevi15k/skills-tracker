package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/", method = {RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public class SkillsController {

    @GetMapping("/")
    public String skillSet() {
        return "<html>" +
                "<h1> Skills Tracker</h1>" +
                "<h2> We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol> <li>Java</li>" +
                "<li> JavaScript </li>" +
                "<li> Python </li>" +
                "</html>";
    }

    @PostMapping("skill")
    public String accessSkill(@RequestParam String name, @RequestParam String[] language) {
        if (name == null) {
            name = "My favorite languages are ";
        }
        return accessSkillSet(name, language);
    }
    public static String accessSkillSet(String n, String[] l) {
        String favorite = "";
        for(String lang : l) {
            if (lang.equals("java")) {
                favorite += "<li>Java</li>";
            } else if (lang.equals("javascript")) {
                favorite += "<li>JavaScript</li>";
            } else if (lang.equals("python")) {
                favorite += "<li>Python</li>";
            }
        }
        return "<html>" +
                "<body>" +
                "<table>" +
                "<tr>" +
                "<th> Name </th>" +
                "<th> Languages </th>" +
                /*"<th> Language2 </th>" +
                "<th> Language3 </th>" +*/
                "<tr>" +
                "<td>" +
                n +
                "</td>" +
                "<td>" +
                favorite +
                "</td>" +
                "</tr>" +
                "</table>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("form")
    @ResponseBody
    public String favoriteSkill() {
        return  "<html>" +
                "<body>" +
                "<form action = '/skill' method = 'post'>" +
                "<h1> Name: </h1>" +
                "<input type = 'text' name = 'name'>" +
                "<h1> My favorite language: </h1>" +
                "<select name = 'language'>" +
                "<option value = 'java'> Java </option>" +
                "<option value = 'javascript'> JavaScript </option>" +
                "<option value = 'python'> Python </option>" +
                "</select><br>" +
                "<h1> My second favorite language: </h1>" +
                "<select name = 'language'>" +
                "<option value = 'java'> Java </option>" +
                "<option value = 'javascript'> JavaScript </option>" +
                "<option value = 'python'> Python </option>" +
                "</select><br>" +
                "<h1> My third favorite language: </h1>" +
                "<select name = 'language'>" +
                "<option value = 'java'> Java </option>" +
                "<option value = 'javascript'> JavaScript </option>" +
                "<option value = 'python'> Python </option>" +
                "</select><br><br>" +
                "<input type = 'submit' value = 'Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
